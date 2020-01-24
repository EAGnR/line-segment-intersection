
public class LineSegment
{

    //begin and end are the end points of line segment; no guaranties on order
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
        return Globals.GeometricObjectType.NO_GEOMETRIC_OBJECT;
    }
    
    public String toString()
    {
        return "[" + begin.toString() + ", " + end.toString() + "]";
    }
}
