  
import java.io.File;
import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class mapper {
  public static void main (String args[]){
        FileResource fr= new FileResource() ;
        CSVParser parser= fr.getCSVParser(false);
        HashMap <String,Integer> map = new HashMap<String,Integer>();
        
        for (CSVRecord rec : parser){
            String crime=rec.get(2);
            if(!map.containsKey(crime)){
                map.put(crime,1);
            }
            else{
                map.put(crime,map.get(crime)+1);
            }
         }
         
         for(String s: map.keySet()){
            System.out.println(s+"\t"+map.get(s));
            }
    }
}
