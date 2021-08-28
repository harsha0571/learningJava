
import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
public class miniproject {
    
    public void totalbirths(CSVParser parser){
        int bbirths=0;
        int gbirths=0;
        int nogirls=0;
        int noboys=0;
        for (CSVRecord rec : parser){
         String gender = rec.get(1);
         String nobirths = rec.get(2);
         int birthno = Integer.parseInt(nobirths);
         if(gender.equals("F")){
            nogirls++;
            gbirths += birthno;
            }
         else
         {
            noboys++;
            bbirths += birthno;
            }
            
        }
        System.out.println("total births: " + (bbirths+gbirths) + " girl births: " + gbirths + " boy births: " + bbirths );
        System.out.println("total no of names : " + (nogirls+noboys) + " no of girl names: " + nogirls + " no of boy names: " + noboys );
    
    
    }
    
    public int getrank(int year , String gender , String name ){
    int rank=0;
    int check=0;
    FileResource fr= new FileResource("yob" + year + ".csv") ;
    CSVParser parser= fr.getCSVParser(false);
    
    
    for (CSVRecord rec : parser){
    String gen = rec.get(1);
    String nameof = rec.get(0);
    
    if(gen.equals(gender)&&nameof.equals(name)){
      rank++;
      check=1;
      break;
      }
    if(gen.equals(gender)){
      rank++;
    }
    
   }
   if(check==1)
    return rank;
    else
    return -1;
    
}
    
    
 public String getname(int year , int rank , String gender){
    int rankof=0;
    int check=0;
    String nameatrank="";
    FileResource fr= new FileResource("yob" + year + ".csv") ;
    CSVParser parser= fr.getCSVParser(false);
    
    for (CSVRecord rec : parser){
    String gen = rec.get(1);
    String nameof = rec.get(0);
    if(gen.equals(gender)){
      rankof++;
    }
    if(rankof==rank){
    nameatrank=nameof;
    check=1;
    break;
    }
    
   }
    if(check==1)
    return nameatrank;
    else
    return "none at given rank ";
    
    
    }
  
 public String nameinnewyear(String name ,int year,int newyear ,String gender){
    String neededname = "";
    
    int rank=getrank(year,gender,name);
    neededname=getname(newyear,rank,gender);
    
    return neededname;
    }
    
 public int yearofhighestrank(String name , String gender){
    int yearhighest=-1;
    int previousrank=0;
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
      String year = f.getName();
      String pyear=year.substring(3,7);
      int presentyear = Integer.parseInt(pyear);
      int presentrank=getrank(presentyear,gender,name);
      if(previousrank==0 && presentrank!=-1){
        previousrank=presentrank;
        yearhighest=presentyear;
        continue;
        }
      if(presentrank<previousrank && presentrank!=-1){
        yearhighest=presentyear;
        previousrank=presentrank;
        }
    
   }
    return yearhighest;
    }

  public double getavgrank(String name , String gender){
    double avgrank=-1;
    int noy=0;
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
      String year = f.getName();
      String pyear=year.substring(3,7);
      int presentyear = Integer.parseInt(pyear);
      int presentrank=getrank(presentyear,gender,name);
      if(presentrank!=-1 && avgrank==-1){
        avgrank += presentrank+1;
        noy++;
        continue;
        }
      if(presentrank!=-1 ){
        avgrank += presentrank;
        noy++;
        }
    
   }
     double result =((double)avgrank/noy);
     return result;
    
    }
  
  public int totalbirthsrankedhigher(String name, String gender)  {
    int birthshigher=0;
    
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
      String year = f.getName();
      String pyear=year.substring(3,7);
      int presentyear = Integer.parseInt(pyear);
      int presentrank=getrank(presentyear,gender,name);
      if(presentrank==-1){
        break;
        }
      
      FileResource fr= new FileResource( "yob" + pyear + ".csv") ;
      CSVParser parser= fr.getCSVParser(false);
    
       for (CSVRecord rec : parser){
        String gen=rec.get(1);
        String nameof=rec.get(0);
        String births=rec.get(2);
        int nobirths= Integer.parseInt(births);
        int recrank = getrank(presentyear , gen , nameof);
        
        if(recrank<presentrank&&recrank!=-1&&gen.equals(gender)){
         birthshigher += nobirths ;
       }
     }
   }
    
    
    
    return birthshigher;
    }
  
 public void testing(){
    //FileResource fr= new FileResource() ;
    //CSVParser parser= fr.getCSVParser(false);
    //totalbirths(parser);
    
    //int rank=getrank(1960,"F","Emily");
    //System.out.println(rank);
    
    //String name=getname(1982,450,"M");
    //System.out.println(name);
    
    //String name=nameinnewyear("Owen",1974,2014,"M");
    //System.out.println("name in new year is: "+name);
    
    //int year=yearofhighestrank("Mich","M");
    //System.out.println("highest year: " +year);
    
    //double avgrank=getavgrank("Robert","M");
    //System.out.println("average rank: " +avgrank);
    
    int higherranks=totalbirthsrankedhigher("Emily","F");
    System.out.println("higher births than present rank : " +higherranks);
    
    }
    
    
}
