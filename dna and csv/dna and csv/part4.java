
import edu.duke.*;

public class part4 {                                                                                      

 URLResource u=new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
 
 int start=0;
 int end=0;
 String ans="";
 
 public String getlinks()
 {
  
    for (String word : u.words()){
        String url=word.toLowerCase();
        start=url.indexOf("youtube.com");
        if(start!=-1){
        start=word.indexOf("\"");
        end=word.lastIndexOf("\"");
        ans=word.substring(start,end+1);
        System.out.println(ans);
       }
       else
       System.out.println("not found");
   }
    return "";
       }  
       
       
       
}
