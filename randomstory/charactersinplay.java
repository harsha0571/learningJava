import edu.duke.*;
import java.util.*;

public class charactersinplay {

   private ArrayList<String> character;
   private ArrayList<Integer> freq;
  public charactersinplay(){
   character = new ArrayList<String>();
   freq = new ArrayList<Integer>();
   }
   public void findallcharacters(){
    FileResource fr = new FileResource();
    for(String line : fr.lines()){
    int end = line.indexOf(".");
    if(end==-1){
    continue;}
    String name = line.substring(0,end);
    int idx  = character.indexOf(name);
    if(idx==-1){
    character.add(name);
    freq.add(1);
    }
    else
    {
    int val = freq.get(idx);
    freq.set(idx,val+1);
    }
    
    }
  }
  public void numparts(int num1 , int num2){
    
      for(int i =0; i<character.size(); i++){
        int val= freq.get(i);
        if(val>=num1 && val<=num2)
        {System.out.println(character.get(i) + " " + freq.get(i) );}
    }
    
    }
  public void tester (){
    findallcharacters();
    //for(int i =0; i<character.size(); i++){System.out.println(character.get(i) + " " + freq.get(i) );}
    numparts(0,99);
    int max=0;
    for(int k =0; k<character.size(); k++){
    if(freq.get(k)>freq.get(max)){
    max=k;
    }
    }
    System.out.println("max speaking part is for " +character.get(max)+" " + freq.get(max));
    }
}