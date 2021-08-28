
import edu.duke.*;
import java.io.*;
public class part1 {
    
    public String findsimplegene(String dna){
    int start=0;
    int stop=0;
     start = dna.indexOf("atg");
    if(start==-1)
     return ""; 
    
    stop = dna.indexOf("taa",start+3);
    if(stop==-1)
     return "";
    
    if((stop-start)%3==0)
     return dna.substring(start,stop+3);
    else
    return "";
   }
   
   public void  testsimplegene(){
    String a="taratgaatgatfargtagtataagonza";
    String result=findsimplegene(a);
    System.out.println("gene is " + result);
    
    }
    
    

}
