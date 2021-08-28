import edu.duke.*;
import org.apache.commons.csv.*;

public class part7 {

   public void country(CSVParser parser,String country){ 
     
       for(CSVRecord record : parser   ){
         String c=record.get("Country");
           if(c.indexOf(country)!=-1)
         {
            String e=record.get("Exports");
            String d=record.get("Value (dollars)");
            System.out.print(c+":" + e +":"+d);
            break;
            }

      

     }

     
     }
     public void bige(CSVParser parser,String amount){ 
     
       for(CSVRecord record : parser   ){
         String c=record.get("Country");
         String d=record.get("Value (dollars)");
           if(d.length()>amount.length())
         {
            
            
            System.out.println(c+":"+d);
            
            }

      

     }

     
     }
     
     public void ltwoe(CSVParser parser,String item1, String item2){
        
        for(CSVRecord record : parser   ){
        String e =record.get("Exports");
        if(e.contains(item1)&&e.contains(item2)){
        
        String c=record.get("Country");
        System.out.println(c);
        }
      

     }
  }
  public int noe(CSVParser parser,String item){
        int c=0;
        for(CSVRecord record : parser   ){
        String e =record.get("Exports");
        if(e.contains(item)){
        
        c++;
        }
      

     }
     return c;
  }
   
     public void tester(){
        
        FileResource fr = new FileResource();
        CSVParser parser= fr.getCSVParser();
        bige(parser,"$999,999,999,999");
        //System.out.print(noe(parser,"cocoa"));
        //ltwoe(parser,"cotton","flowers");
        //country(parser,"Nauru");
        
        
        }
    
   }
