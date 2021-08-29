import java.util.*;
import java.io.File ;
import edu.duke.*;
public class WordsInFiles {
   
 private HashMap<String,ArrayList<String>> map;
    
       public WordsInFiles(){
        map = new HashMap<String,ArrayList<String>>();
       }
    private void addWordFromFile(File f){
    FileResource fr = new FileResource(f);
         String file = f.getName();
        for(String w : fr.words()){
          if(!map.containsKey(w)){
              ArrayList<String> sublist = new ArrayList<String>();
              sublist.add(file);
              map.put(w,sublist);
            }
          else{
               ArrayList<String> sublist = map.get(w);
               if(!sublist.contains(file)){
                sublist.add(file);
            }
               //map.put(w,sublist);
            }
    }
  }
  public void buildWordFileMap(){
    map.clear();
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
        addWordFromFile(f);
    }
    }
    public int  maxNumber(){
     int max=0;
     for(String s: map.keySet()){
         ArrayList<String> sublist = map.get(s);
         if(sublist.size()>max){
            max=sublist.size();
            }
        }
     return max;
    }
    
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> words = new ArrayList<String>();
        for(String s: map.keySet()){
         ArrayList<String> sublist = map.get(s);
         if(sublist.size()==number){
            words.add(s);
            }
        }
        System.out.println("words 5: " +words.size());
        return words;
    }
    public void printFilesIn(String word){
    for(String s: map.keySet()){
         if(s==word){
            ArrayList<String> sublist = map.get(s);
            System.out.println(word+" appears in: ");
            for(int i=0;i<sublist.size();i++){
            System.out.print(sublist.get(i)+" ");
            }
            }
        }
    }
    public void tester(){
    buildWordFileMap();
    
    int m = maxNumber();
    ArrayList<String> list = wordsInNumFiles(5);
    System.out.println("The greatest number of files a word appears in is "+m+ ",and there are "+list.size()+" such words:");
    for(int i=0;i<list.size();i++){
    String word = list.get(i);
    if(i!=0)
    System.out.print(" and "+word);
    if(i==0)
    System.out.print(word);
    }
    /*System.out.println();
    String red = "red";
    String sad = "sad";
    printFilesIn(sad);
    System.out.println();
    printFilesIn(red);*/
    for(int i=0;i<list.size();i++){
    String word = list.get(i);
    printFilesIn(word);
    System.out.println();
    }
    
    }
    
}
