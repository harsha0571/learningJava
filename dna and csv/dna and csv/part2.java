import edu.duke.*;
import java.io.*;

public class part2 {
public String findsimplegene(String dna, String startcodon,String stopcodon){
    int start=0;
    int stop=0;
     start = dna.indexOf(startcodon);
    if(start==-1)
     return ""; 
    
    stop = dna.indexOf(stopcodon,start+3);
    if(stop==-1)
     return "";
    
    if((stop-start)%3==0)
     return dna.substring(start,stop+3);
    else
    return "";
   }
   
   public void  testsimplegene(){
    
    String a="taratgaatgatfargtagtataagonza";
    String result=findsimplegene(a.toUpperCase(),"ATG","TAA");
    System.out.println("gene is " + result);
    
    }
}
