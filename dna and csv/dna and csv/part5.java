import edu.duke.*;
import java.io.*;
import java.io.File;

public class part5 {

  public int fstopcodon(String dna, String stopcodon,int startindex){
    
    int currindex=dna.indexOf(stopcodon,startindex+3);
    while(currindex!=-1){
       if((currindex-startindex)%3==0){
        return currindex;
        }
       else
        currindex=dna.indexOf(stopcodon,currindex+1);
    }
    return dna.length();
    }
    
    public String fgene(String dna,int where){
        
        
        int startindex=dna.indexOf("atg",where);
        if(startindex==-1)
         {return "";}
        
        int taaindex=fstopcodon(dna,"taa",startindex);
        int tgaindex=fstopcodon(dna,"tag",startindex);
        int tagindex=fstopcodon(dna,"tga",startindex);
        int minindex=Math.min(taaindex,Math.min(tgaindex,tagindex));
       if(minindex==dna.length())
         return "";
       else 
         return dna.substring(startindex,minindex+3);
      }
    
    public void fallgene(String dna){
         dna=dna.toLowerCase();
        int startindex=0;
        while(true){
            
            String cgene=fgene(dna,startindex);
            
            if(cgene.isEmpty())
             {break;}
            
            System.out.println(cgene);
            System.out.println(cgratio(cgene));
             
            startindex=dna.indexOf(cgene,startindex)+cgene.length();    
        }
       
     }
    public float cgratio(String s){
    int c=0;
    int g=0;   
    int cindex=s.indexOf("c");
    int gindex=s.indexOf("g");
    float l=s.length();
    while(cindex!=-1){
    c++;
    cindex=s.indexOf("c",cindex+1);
    }
    
    while(gindex!=-1){
    g++;
    gindex=s.indexOf("g",gindex+1);
    }
    float result =(float)(c+g)/l;
    
    return result;
    
  }
     public void testgene(){
        
        System.out.println("test 1:");
        String dna="ATGCCATAG";
        fallgene(dna);
        /*System.out.println("test 5:");
        dna="Atgffftgaatgnaetaa ";
        fallgene(dna);
        System.out.println("test 2:");
        dna="atgfffTgaaaFTAAATG ";
        fallgene(dna);
        System.out.println("test 3:");
        dna="";
        fallgene(dna);
        System.out.println("test 4:");
        dna="atgfftgatgfffatg";
        fallgene(dna);
       */
       }        
        
    }


