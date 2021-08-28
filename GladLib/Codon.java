
import edu.duke.*;
import java.util.*;
public class Codon {
   private HashMap<String,Integer> map = new HashMap<String,Integer>();
   public void buildCodonMap(int start , String dna){
    String frame = dna.substring(start);
    System.out.println(frame);
    int present = 0;
    while(present+3 < dna.length()-1)
    {
      
      String codon =frame.substring(present,present+3);
      System.out.println(codon.length());
      if(codon.length()<3){
        break;
      }
        
      if(map.containsKey(codon))
      {
        map.put(codon,map.get(codon)+1);
        }
      else
      {
        map.put(codon,1);
        }
      present += 3 ;
    }
    
    }
    public String mostCommonCodon(){
    int max = 0;
    String m ="";
        for(String s : map.keySet())
    {
     if(map.get(s)>max)
     {
         max= map.get(s);
         m = s ;
        }
     
    }
    
    return m ;
    }
  public void printCodons(int start , int end){
     int count = 0;
     for(String s : map.keySet())
       {
        count = map.get(s);
        if(count>=start && count <= end ){
           System.out.println(s + "\t" + count);
          }
      }
     
    }
  public void tester(){
    FileResource f = new FileResource();
    String dna = f.asString();
    dna=dna.trim();
    //String dna ="CGTTCAAGTTCAA";
    for(int i=0 ; i<3 ; i++){
    buildCodonMap(i,dna);
    System.out.println("Reading frame starting with "+i+" results in " +map.size()+" unique codons");
    String com = mostCommonCodon();
    System.out.println("and the most codon is  "+com+" with count "+ map.get(com));
    System.out.println("Counts of codons between 1 and 5 inclusive are:");
    printCodons(1,5);
    map.clear();
    }
    
   }
}
