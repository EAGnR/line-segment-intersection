public class Main
{
    public static void main(String[] args)
    {
        new Main();
    }
    
    public Main()
    {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(0.5, 0.5);
        Point p3 = new Point(1.75, 1.75);
        Point p4 = new Point(2.0, 2.0);
        LineSegment lineSegment1 = new LineSegment(p1, p2);
        LineSegment lineSegment2 = new LineSegment(p3, p4);
        
        //System.out.println("Intersection between " + lineSegment1 + " and " + lineSegment2 + " is: ");

        lineSegment1.CollinearLineSegmentsIntersection(lineSegment2, null, null);
    }
}