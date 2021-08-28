import edu.duke.*;


public class part3 {

    public boolean twiceoccur(String a, String b){
     int first=0,second=0;
     first =a.indexOf(b);
     second =a.indexOf(b,(first+b.length()));
     
     if(second!=0 && second!=-1)
      return true;
     else
     return false;
    
   }
   
   public void testing(){
   String one="atg";
   String two="g";
   if(twiceoccur(one, two))
   System.out.println("twice occured ");
   
   else
   System.out.println("twice not");
    
    
    
    }
    
    
}
