import java.util.Comparator;
import java.util.Arrays;

public class LineSegment
{
    //begin and end are the end points of line segment; no guarantees on order
    private Point begin;
    private Point end;
    private PointComparator comparator;

    /**
     * Instantiates a LineSegment object with endpoints (0, 0) and (1, 1).
     */
    public LineSegment()
    {
        begin = new Point(0, 0);
        end = new Point(1, 1);
        comparator = new PointComparator();
    }

    /**
     * Instantiates a LineSegment object with endpoints b and e.
     */
    public LineSegment(Point b, Point e)
    {
        begin = b;
        end = e;
        comparator = new PointComparator();
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
        // Here we map points to hashes, so we know to which segment they belong.
        // For convenience p1, p2 belong to this line segment,
        // and p3, p4 belong to the other line segment (ls).
        // This is later used to created a string of sorted points for case comparison.
        int p1 = this.begin.hashCode();
        int p2 = this.end.hashCode();
        int p3 = ls.begin.hashCode();
        int p4 = ls.end.hashCode();

        // This array is used for maintaining the order of the points.
        Point[] points = new Point[4];
        points[0] = this.begin;
        points[1] = this.end;
        points[2] = ls.begin;
        points[3] = ls.end;

        // The array now guarantees order of the points by index number [0,3].
        // Only use after Arrays.sort() returns!
        Arrays.sort(points, comparator);
        
        String sortedPoints = "";
        // Creates a string with the labels of the points in their order.
        for(int i = 0; i < points.length; i++)
        {
            if (points[i].hashCode() == p1)
            {
                sortedPoints += "P1";
            }
            else if (points[i].hashCode() == p2)
            {
                sortedPoints += "P2";
            }   
            else if (points[i].hashCode() == p3)
            {
                sortedPoints += "P3";
            }   
            else if (points[i].hashCode() == p4)
            {
                sortedPoints += "P4";
            }       

            if (i < points.length - 1)
            {
                sortedPoints += " ";
            }
        }
        
        // If the two middle points are equal, that is the point of intersection.
        if (points[1].equals(points[2]))
        {
        	Point result = points[1];
        	pointResult.setX(result.getX());
        	pointResult.setY(result.getY());
        	return Globals.GeometricObjectType.POINT;
        }
        // Middle points are not equal, this is the case where the segments do not intersect (one is to the left of the other).
        else if (sortedPoints.equals("P1 P2 P3 P4") || sortedPoints.equals("P2 P1 P3 P4") 
        		|| sortedPoints.equals("P1 P2 P4 P3") || sortedPoints.equals("P2 P1 P4 P3")
        		|| sortedPoints.equals("P3 P4 P1 P2") || sortedPoints.equals("P4 P3 P1 P2") 
        		|| sortedPoints.equals("P3 P4 P2 P1") || sortedPoints.equals("P4 P3 P2 P1"))
        {
        	return Globals.GeometricObjectType.NO_GEOMETRIC_OBJECT;
        }
        // In all other cases, the middle two points form the segment of intersection.
        else
        {
        	Point resultBegin = points[1];
        	Point resultEnd = points[2];
        	
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

    private class PointComparator implements Comparator<Point>
    {
        // Comparator orders points by their x value, 
        // and orders them by y value if the x values are the same.
        public int compare(Point p1, Point p2)
        {
            if(Math.abs(p1.getX() - p2.getX()) < Globals.POINT_EPSILON)
               return  Double.compare(p1.getY(), p2.getY());
            else
                return Double.compare(p1.getX(), p2.getX());
        }
    }
}
