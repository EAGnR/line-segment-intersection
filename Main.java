public class Main
{
    public static void main(String[] args)
    {
        new Main();
    }
    
    public Main()
    {
        LineSegment lineSegment1 = new LineSegment();
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 0);
        LineSegment lineSegment2 = new LineSegment(p1, p2);
        
        System.out.println("Intersection between " + lineSegment1 + " and " + lineSegment2 + " is: ");
    }
}