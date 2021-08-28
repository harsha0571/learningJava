import edu.duke.*;
import java.io.File;
import java.util.Arrays;  
public class caesarcipher {

    
    public String encrypt(String input , int key){
    
    StringBuilder sb = new StringBuilder(input);
    //            12345678901234567890123456
    String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alpha2="abcdefghijklmnopqrstuvwxyz";
    String  shift= alpha.substring(key) + alpha.substring(0,key);
    String  shift2= alpha2.substring(key) + alpha2.substring(0,key);
    for(int i = 0; i<sb.length() ; i++){
    char cur = sb.charAt(i);
    int idx = 0;
    if(Character.isLowerCase(cur))
    {
    idx = alpha2.indexOf(cur);
    if(idx!=-1){
    char ncur = shift2.charAt(idx);
    sb.setCharAt(i,ncur);
         }
    }
    else
    {
    idx = alpha.indexOf(cur);
    if(idx!=-1){
    char ncur = shift.charAt(idx);
    sb.setCharAt(i,ncur);
         }
    }

       } 
    
    return sb.toString() ; 
    }
    
    public String encryptwokeys(String input , int key1 , int key2){
    StringBuilder sb = new StringBuilder(input);
    
    for(int i = 0; i<sb.length() ; i++){
    if(i%2==0){
    char cur = sb.charAt(i);
    String one = Character.toString(cur);
    String en = encrypt(one , key1);
    char ncur = en.charAt(0);
    sb.setCharAt(i,ncur);
    }
    else
    {
    char cur = sb.charAt(i);
    String one = Character.toString(cur);
    String en = encrypt(one , key2);
    char ncur = en.charAt(0);
    sb.setCharAt(i,ncur);
     }
   }
   return sb.toString();
 }
    
    public void wordlengths(FileResource f , int[] count ){
        int largest=0;
        for (String word : f.words()) {
          int c=0;
          
          String input = word.toLowerCase();
          StringBuilder sb = new StringBuilder(input);
          
            for(int i = 0; i<sb.length() ; i++){
             char cur = sb.charAt(i);
             int idx = 0;
           if(i==0 || i == sb.length()-1) {
             if(Character.isLetter(cur))
              c++;}
           else 
             c++;
          }
          count[c]++;
          
         }
        
         for(int i=0; i< count.length; i++ ) {
        if(count[i]!=0)
        System.out.println("no of words of length " + i + " is " + count[i] );
        
        if(count[i]>largest)
          {largest = i ;}
        }
        System.out.println("index of max element is  " + largest );
    }
    
    public int [] countleters(String input ){
    String alph ="abcdefghijklmnopqrstuvwxyz";
    int [] count = new int[26];
    
    for(int i=0;i<input.length(); i++){
    char ch = Character.toLowerCase(input.charAt(i));
    int dex = alph.indexOf(ch);
    if(dex!=-1){
    count[dex]++;
      }
    }
    return count;
    }
    
    public int maxindex(int [] input){
        int largest = 0 ;
        for(int i=0; i<input.length ; i++){
        if(input[i]>input[largest])
          {largest = i ;}
          }
       return largest;
    }
    
    public String decrypt(String encrypted){
    //caesarcipher cc = new caesarcipher();
    int [] freqs = countleters(encrypted);
    int max = maxindex(freqs);
    int dkey = max - 4;
    if(max< 4)
    {dkey = 26 - (4-max);}
    System.out.println(dkey);
    return encrypt(encrypted , 26-dkey);
   }
   
   public String splitstring(String input , int start){
    
    String answer="";
    for(int i= start; i<input.length(); i+=2 ) 
    {
        answer += input.charAt(i);
    }
    return answer;
    }
    
    
    public String decryptwokeys(String encrypted){
    String one= splitstring(encrypted , 0 );
    String two = splitstring(encrypted , 1);
    StringBuilder oned = new StringBuilder(decrypt(one));
    StringBuilder twod = new StringBuilder(decrypt(two));
    StringBuilder sb = new StringBuilder(encrypted);
    int k=0 , j=0 ;
    for(int i = 0 ; i<encrypted.length() ; i++){
    if(i%2==0){
    char cur = oned.charAt(k);
    sb.setCharAt(i,cur);
    k++;
    }
    else
    {char cur2 = twod.charAt(j);
    sb.setCharAt(i,cur2);
    j++;
    }
     }    
     return sb.toString();
    }
    
    public void testwordlength(){
    
    int [] a = new int[31];
    FileResource fr = new FileResource();
    wordlengths(fr, a);
    
    }
    public void testdecryptwokets(){
    FileResource fr = new FileResource();
    String in = fr.asString();
    String out = decryptwokeys(in);
    System.out.println(out);
    
    }
    public void testencrypt(){
    
    String in = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
    String out = encryptwokeys(in,12,2);
    System.out.println(out);
    
    }

}
