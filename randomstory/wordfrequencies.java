import edu.duke.*;
import java.util.*;

public class wordfrequencies {

    private ArrayList<String> mywords;
    private ArrayList<Integer>myfreqs;
    
    public wordfrequencies(){
    
    mywords = new ArrayList<String>();
    myfreqs = new ArrayList<Integer>();
    }
    
    public void unique(){
    mywords.clear();
    myfreqs.clear();
    FileResource fr = new FileResource();
    for(String word : fr.words()){
    String in =word.toLowerCase();
    int idx = mywords.indexOf(in);
    if(idx==-1)
    {    
      mywords.add(in);
      myfreqs.add(1);
    }
    else
    {
      int val = myfreqs.get(idx);
      myfreqs.set(idx,val+1);
    }
     }
    }
    public int indexmax(){
    int max=0;
    int idx=0;
        for(int i=0; i<myfreqs.size(); i++){
    if(myfreqs.get(i)>max)
     {max=myfreqs.get(i);
     idx=i;}
    }
    return idx;
    }
    
    public void tester(){
    unique();
    
    for(int i=0; i<mywords.size(); i++){
    System.out.println(myfreqs.get(i) + "\t" + mywords.get(i));
    }
    int idx = indexmax();
    System.out.println("max element occurs " + myfreqs.get(idx) +" times and is: " + mywords.get(idx));
    System.out.println("no of unique words: "+  mywords.size());
    }
    
}
