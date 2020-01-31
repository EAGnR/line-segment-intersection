import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

public class LineSegment
{
    //begin and end are the end points of line segment; no guarantees on order
    private Point begin;
    private Point end;

    /**
     * Instantiates a LineSegment object with endpoints (0, 0) and (1, 1).
     */
    public LineSegment()
    {
        begin = new Point(0, 0);
        end = new Point(1, 1);
    }

    /**
     * Instantiates a LineSegment object with endpoints b and e.
     */
    public LineSegment(Point b, Point e)
    {
        begin = b;
        end = e;
    }

    /**
     * Calculates the intersection between this line segment and <code>ls</code>,
     * under the assumption that both are collinear. No check for collinearity is 
     * performed. Intersection is either empty, a point, or a line segment.
     * 
     * @param ls line segment which is collinear with this line segment
     * @param pointResult if the intersection is a point, it will be assigned
     *                    to pointResult, null otherwise
     * @param lineSegmentResult if the intersection is a line segment, it will 
     *                          be assigned to lineSegmentResult, 
     *                          null otherwise
     * @return type of the intersection, it can be NO_GEOMETRIC_OBJECT (i.e. empty),
     *         LINE_SEGMENT, or POINT
     */
    public Globals.GeometricObjectType CollinearLineSegmentsIntersection(LineSegment ls, Point pointResult, LineSegment lineSegmentResult)
    {
        // Here we map points to labels, so we know to which segment they belong.
        // For convenience "P1", "P2" belong to this line segment,
        // and "P3", "P4" belong to the other line segment (ls).
        Hashtable<Point, String> ht = new Hashtable<>();
        ht.put(this.begin, "P1");   // This line segment beginning.
        ht.put(this.end, "P2");     // This line segment end.
        ht.put(ls.begin, "P3");     // Other line segment beginning.
        ht.put(ls.end, "P4");       // Other line segment end.

        // This arraylist is used for maintaining the order of the points.
        ArrayList<Point> points = new ArrayList<>();
        points.add(this.begin);
        points.add(this.end);
        points.add(ls.begin);
        points.add(ls.end);

        // The arraylist now guarantees order of the points by index number [0,3].
        // Only use after points.sort() returns!
        points.sort(new Comparator<Point>() 
        {
            // Comparator orders points primarily by their x value, 
            // but also taking into account their y value for special cases.
            public int compare(Point p1,Point p2)
            {
                double xWeight = 10000.0;
                double yWeight = 100.0;
                double sortKeyP1 = xWeight * p1.getX() + yWeight * p1.getY();
                double sortKeyP2 = xWeight * p2.getX() + yWeight * p2.getY();

                return Double.compare(sortKeyP1, sortKeyP2);
            }
        });

        // Testing the ordering of the points.
        /*System.out.printf("Printing points in order: %s%s, %s%s, %s%s, %s%s %n", 
        ht.get(points.get(0)), points.get(0),
        ht.get(points.get(1)), points.get(1),
        ht.get(points.get(2)), points.get(2),
        ht.get(points.get(3)), points.get(3));*/
        
        String sortedPoints = ht.get(points.get(0)) + " " + ht.get(points.get(1)) + " " 
        		+ ht.get(points.get(2)) + " " + ht.get(points.get(3));
        
        //if the two middle points are equal, that is the point of intersection
        if (points.get(1).equals(points.get(2)))
        {
        	Point result = points.get(1);
        	pointResult.setX(result.getX());
        	pointResult.setY(result.getY());
        	return Globals.GeometricObjectType.POINT;
        }
        //middle points are not equal, this is the case where the segments do not intersect (one is to the left of the other)
        else if (sortedPoints.equals("P1 P2 P3 P4") || sortedPoints.equals("P2 P1 P3 P4") 
        		|| sortedPoints.equals("P1 P2 P4 P3") || sortedPoints.equals("P2 P1 P4 P3")
        		|| sortedPoints.equals("P3 P4 P1 P2") || sortedPoints.equals("P4 P3 P1 P2") 
        		|| sortedPoints.equals("P3 P4 P2 P1") || sortedPoints.equals("P4 P3 P2 P1"))
        {
        	return Globals.GeometricObjectType.NO_GEOMETRIC_OBJECT;
        }
        //in all other cases, the middle two points form the segment of intersection
        else
        {
        	Point resultBegin = points.get(1);
        	Point resultEnd = points.get(2);
        	
        	lineSegmentResult.begin.setX(resultBegin.getX());
        	lineSegmentResult.begin.setY(resultBegin.getY());
        	lineSegmentResult.end.setX(resultEnd.getX());
        	lineSegmentResult.end.setY(resultEnd.getY());
        	return Globals.GeometricObjectType.LINE_SEGMENT;
        }
    }
    
    public String toString()
    {
        return "[" + begin.toString() + ", " + end.toString() + "]";
    }
}
