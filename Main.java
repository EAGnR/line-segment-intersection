public class Main
{
    public static void main(String[] args)
    {
        new Main();
    }
    
    public Main()
    {
    	//points taken from the line y = 2x + 5
    	Point p0 = new Point(-6, -7);
    	Point p1 = new Point(-2, 1);
    	Point p2 = new Point(2, 9);
    	Point p3 = new Point(4, 13);
    	Point p4 = new Point(6, 17);
    	Point p5 = new Point(8, 21);
    	Point p6 = new Point(14, 33);
    	
    	//segments using the points from the line y = 2x + 5
    	LineSegment s0 = new LineSegment(p0, p1);
    	LineSegment s1 = new LineSegment(p2, p3);
    	LineSegment s2 = new LineSegment(p2, p6);
    	LineSegment s3 = new LineSegment(p3, p5);
    	LineSegment s4 = new LineSegment(p3, p6);
    	LineSegment s5 = new LineSegment(p2, p5);
    	LineSegment s6 = new LineSegment(p4, p6);
    	
    	//points taken from the vertical line x = 2
    	Point p7 = new Point(2, -1);
    	Point p8 = new Point(2, -0.5);
    	Point p9 = new Point(2, 0.5);
    	Point p10 = new Point(2, 2.25);
    	Point p11 = new Point(2, 3);
    	
    	//segments using the points from the line x = 2
    	LineSegment s7 = new LineSegment(p7, p11);
    	LineSegment s8 = new LineSegment(p9, p10);
    	LineSegment s9 = new LineSegment(p7, p9);
    	LineSegment s10 = new LineSegment(p11, p10);
    	LineSegment s11 = new LineSegment(p8, p11);
    	
    	//points taken from the line y = -4x + 9
    	Point p12 = new Point(-2, 17);
    	Point p13 = new Point(5, -11);
    	Point p14 = new Point(-1, 13);
    	Point p15 = new Point(0.6, 6.6);
    	Point p16 = new Point(1, 5);
    	
    	//segments using the points from the line y = -4x + 9
    	LineSegment s12 = new LineSegment(p13, p12);
    	LineSegment s13 = new LineSegment(p14, p15);
    	LineSegment s14 = new LineSegment(p13, p16);
    	LineSegment s15 = new LineSegment(p12, p16);
    	LineSegment s16 = new LineSegment(p13, p15);
    	
    	//points taken from the horizontal line y = 2
    	Point p17 = new Point(-1, 2);
    	Point p18 = new Point(-0.5, 2);
    	Point p19 = new Point(0.5, 2);
    	Point p20 = new Point(2.25, 2);
    	Point p21 = new Point(3, 2);
    	
    	//segments using the points from the line y = 2
    	LineSegment s17 = new LineSegment(p17, p21);
    	LineSegment s18 = new LineSegment(p19, p20);
    	LineSegment s19 = new LineSegment(p17, p19);
    	LineSegment s20 = new LineSegment(p21, p20);
    	LineSegment s21 = new LineSegment(p18, p21);
    	
    	LineSegment[] segments = {s3, s2, s4, s2, s3, s3, s1, s2, s1, s3, s5, s6, s0, s1, /*y = 2x + 5*/
    			                  s7, s8, s7, s9, s7, s10, s8, s9, s10, s9, s11, s9, s11, s11, /*x = 2*/
    			                  s12, s13, s12, s14, s12, s15, s14, s15, s13, s14, s15, s16, s16, s16, /*y = -4x + 9*/
    			                  s17, s18, s17, s19, s17, s20, s18, s19, s20, s19, s21, s19, s21, s21};
    	String[] answers = {"[(4.0, 13.0), (8.0, 21.0)]", "[(4.0, 13.0), (14.0, 33.0)]", "[(4.0, 13.0), (8.0, 21.0)]", 
    			            "[(2.0, 9.0), (4.0, 13.0)]", "(4.0, 13.0)", "[(6.0, 17.0), (8.0, 21.0)]", "no intersection", /*y = 2x + 5*/
    			            "[(2.0, 0.5), (2.0, 2.25)]", "[(2.0, -1.0), (2.0, 0.5)]", "[(2.0, 2.25), (2.0, 3.0)]", 
    			            "(2.0, 0.5)", "no intersection","[(2.0, -0.5), (2.0, 0.5)]", "[(2.0, -0.5), (2.0, 3.0)]", /*x = 2*/
    			            "[(-1.0, 13.0), (0.6, 6.6)]", "[(1.0, 5.0), (5.0, -11.0)]", "[(-2.0, 17.0), (1.0, 5.0)]", "(1.0, 5.0)", "no intersection",
    			            "[(0.6, 6.6), (1.0, 5.0)]", "[(0.6, 6.6), (5.0, -11.0)]", /*y = -4x + 9*/
    			            "[(0.5, 2.0), (2.25, 2.0)]", "[(-1.0, 2.0), (0.5, 2.0)]", "[(2.25, 2.0), (3.0, 2.0)]", 
    			            "(0.5, 2.0)", "no intersection","[(-0.5, 2.0), (0.5, 2.0)]", "[(-0.5, 2.0), (3.0, 2.0)]" /*y = 2*/};
        
        LineSegment intersectionSegment = new LineSegment();
        Point intersectionPoint = new Point();
		String calculatedSol = "";
		String manualSol = "";
        for(int i = 0; i < segments.length; i++)
        {
        	LineSegment lineSegment1, lineSegment2;
        	
        	//this is used to test if we get the same result if the order of the two segments is inverted
        	if(i % 2 == 0)
        	{
        		lineSegment1 = segments[i];
            	lineSegment2 = segments[i + 1];
        	}
        	else
        	{
        		lineSegment1 = segments[i];
            	lineSegment2 = segments[i - 1];
        	}
        	
        	System.out.println("Intersection between " + lineSegment1 + " and " + lineSegment2 + " is: ");
			Globals.GeometricObjectType intersectionType = lineSegment1.CollinearLineSegmentsIntersection(lineSegment2, intersectionPoint, intersectionSegment);

            if (intersectionType == Globals.GeometricObjectType.LINE_SEGMENT)
            {
				calculatedSol = intersectionSegment.toString();
            }
            else if (intersectionType == Globals.GeometricObjectType.POINT)
            {
				calculatedSol = intersectionPoint.toString();
            }
            else
            {
				calculatedSol = "no intersection";
            }
			
			manualSol = answers[i / 2];
			System.out.println(calculatedSol);
			System.out.println(manualSol + " is the actual answer");

			if(manualSol.equals(calculatedSol))
				System.out.println("Status: PASSED\n");
			else
				System.out.println("Status: FAILED\n");
        }
    }
}