import edu.duke.*;
import java.io.File;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
       double totalPerim = 0.0;
       Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
        double currDist = prevPt.distance(currPt);
        totalPerim = totalPerim + currDist;
        prevPt = currPt;
        }
        return totalPerim;
    }
    
    public int numpoints(Shape s){
        int nop=0;
    for (Point currPt : s.getPoints()) {
            nop++;
             }
            return nop;
    }
    public double getlargestside (Shape s) {
       double largeside=0;
       Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
        double currDist = prevPt.distance(currPt);
        if(currDist>largeside)
        largeside=currDist;
        
        prevPt = currPt;
        }
        return largeside;
    }
    public double getlargestx (Shape s) {
       double largex=0;
       
        for (Point currPt : s.getPoints()) {
        double x = currPt.getX();
        if(x>largex)
        {
        largex=x;
        }
        
       }
        return largex;
    }
    

    public void testPerimeter () {
       DirectoryResource dr = new DirectoryResource();
       for ( File f : dr.selectedFiles( )) {
        FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("no of points  = " + numpoints(s));
        System.out.println("avglength  = " + length/numpoints(s));
        System.out.println("largest side  = " + getlargestside(s));
        System.out.println("largest x  = " + getlargestx(s));                                                                                                                                                                                                                                                                                              
        System.out.println("-----------------------------");
        
        }
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
