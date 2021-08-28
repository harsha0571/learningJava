
//import edu.duke.*;
public class wordplay {

   public boolean isvowel(char chr){
    char ch = Character.toLowerCase(chr);
    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
    return true;
    else 
    return false;
    }
   
    public String replacevowels(String phrase , char chr){
    StringBuilder sb = new StringBuilder(phrase);
    for(int i=0; i < sb.length(); i++){
      char ch = sb.charAt(i);
      if(isvowel(ch))
      sb.setCharAt(i,chr);
    }
    
    return sb.toString();
    }
    
    public String emphasize(String phrase, char chr){
    
    StringBuilder sb = new StringBuilder(phrase);
    for(int i=0; i < sb.length(); i++){
      char ch = sb.charAt(i);
      if(ch==chr)
      {
       if(i%2==0)
       sb.setCharAt(i,'*');
       else
       sb.setCharAt(i,'+');
        }
    }
    
    return sb.toString();
    
    
    }
    
    
   public void testing (){
    if(isvowel('b'))
    System.out.println("vowel");
    
    
    }    
}
