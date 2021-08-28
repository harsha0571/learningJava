
import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
public class part8 {

public CSVRecord incold(CSVParser parser){
     CSVRecord coldest = null ;
     
     double t2 =0;
     for(CSVRecord record : parser   ){
         
         String temp = record.get("TemperatureF");
         double tet = Double.parseDouble(temp);
         if(coldest==null&& tet!=-9999){
             t2 = tet;
             
             coldest = record ;
          }
          
          
         if(tet<t2 && tet!=-9999){
            t2=tet;
            coldest =record;
            
            
            }
         
         
         
               }
      
     return coldest;
     }
public CSVRecord inh(CSVParser parser){
     CSVRecord humid = null ;
     
     double t2 =0;
     for(CSVRecord record : parser   ){
         
         
         String temp = record.get("Humidity");
         if(temp.equals("N/A")){
            continue;
            
            }
         double tet = Double.parseDouble(temp);
         
         if(humid== null&& tet!=-9999){
             humid = record ;
             t2=tet;
          }
          
          
         if(tet<t2 && tet!=-9999){
            
            humid =record;
            t2=tet;
            
            }
         
         
         
               }
      
     return humid;
     }

public void tester(){
   
   double  t4=0;
   CSVRecord coldall = null; 
   DirectoryResource dr = new DirectoryResource();
   for( File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    CSVParser parser= fr.getCSVParser();
    CSVRecord rec = incold(parser);
    String temp =rec.get("TemperatureF");
    double te = Double.parseDouble(temp);
    if(coldall== null && te!=-9999 ){
        t4= te;
        
        coldall =rec ;
            }
            
    if(te<t4 && te!=-9999){
        t4=te;
        coldall =rec ;
            }
            
            
    
   }
   String tcall=coldall.get("TemperatureF");
    //String time=coldall.get("TimeEDT");
    String date=coldall.get("DateUTC");
    System.out.println("coldest day was in file weather - " +date + ".csv");
    //System.out.println("coldest temperature that day was " +tcall + " at "+ time);
    System.out.println("coldest temperature that day was " +tcall + " at ");
 }
 public double inavg(CSVParser parser){
    double result =0; 
    int  nod=0;
    for(CSVRecord record : parser   ){
         nod++;
         String temp = record.get("TemperatureF");
         double count = Double.parseDouble(temp);
         if(count!=-9999){
            result += count;
            
            }
         }
    
    return (result/nod);
    }
    public double inavgh(CSVParser parser , int value ){
    double result =0; 
    int  nod=0;
    for(CSVRecord record : parser   ){
         
         String humid = record.get("Humidity");
         if(humid.equals("N/A")){
            continue;
            }
         double hum= Double.parseDouble(humid);
         String temp = record.get("TemperatureF");
         double count = Double.parseDouble(temp);
         if(hum>=value&&count!=-9999){
            nod++;
             result += count;
            
            }
         }
    
    return (result/nod);
    }
public void tester2(){
   
   double  t4=0;
   CSVRecord humidall = null; 
   DirectoryResource dr = new DirectoryResource();
   for( File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    CSVParser parser= fr.getCSVParser();
    CSVRecord rec = inh(parser);
    String temp =rec.get("Humidity");
    if(temp.equals("N/A")){
    continue;
    }
    double te = Double.parseDouble(temp);
    if(humidall == null && te!=-9999 ){
        t4= te;
        
        humidall =rec ;
            }
            
    if(te<t4 && te!=-9999 ){
        t4=te;
        humidall =rec ;
            }
            
            
    
   }
    String tcall=humidall.get("Humidity");
    //String time=humidall.get("TimeEST");
    String date=humidall.get("DateUTC");
    System.out.println("least humid day was in file weather - " +date + ".csv");
    //System.out.println("least humidity that day was " +tcall + " at "+ time);
    System.out.println("least humidity that day was " +tcall + " at ");
 }
 public void tester3(){
   
   double result=0;
   int nod=0;
   DirectoryResource dr = new DirectoryResource();
   for( File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    CSVParser parser= fr.getCSVParser();
    double count = inavg(parser);
    nod++;
    result += count;
    
            
    
   }
  System.out.println("avg temperature" + (result/nod) );
  
 }
 public void tester4(){
   
   double result=0;
   int nod=0;
   DirectoryResource dr = new DirectoryResource();
   for( File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    CSVParser parser= fr.getCSVParser();
    double count = inavgh(parser,80);
    nod++;
    result += count;
    
            
    
   }
  System.out.println("avg temperature with humidity greater than 80 " + (result/nod) );
  
 }
}
