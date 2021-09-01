
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String l : fr.lines()){
            LogEntry log = WebLogParser.parseEntry(l);
            records.add(log);
         }
             
     }
     public int  countUniqueIPs(){
         ArrayList<String> uniqueIps = new ArrayList<String>();
         for(LogEntry log:records){
            String ip = log.getIpAddress();
            if(!uniqueIps.contains(ip)){
            uniqueIps.add(ip);
            }
          }
          return uniqueIps.size();
        }
     public void printAllHigherThanNum(int num){
        for(LogEntry log:records){
        int code = log.getStatusCode();
        if(code>num){
        System.out.println(log);
        }
       }
      }
     public ArrayList<LogEntry> uniqueIPVisitsOnDay(String day){
         //System.out.println(day); 
        ArrayList<LogEntry> uniqueIps = new ArrayList<LogEntry>();
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry log: records){
        Date date = log.getAccessTime();
        String time = date.toString();
        String actual = time.substring(4,10);
        //System.out.println(actual); 
        String ip = log.getIpAddress();
        if((!uniqueIPs.contains(ip))&&(actual.equals(day))){
        uniqueIPs.add(ip);
        uniqueIps.add(log);
        }
        }
        
        return uniqueIps;
        }
     public int countUniqueIPsInRange(int low , int high){
        ArrayList<String> uniqueIps = new ArrayList<String>();
        int inRange = 0;
         for(LogEntry log:records){
            String ip = log.getIpAddress();
            int code = log.getStatusCode();
            if(!uniqueIps.contains(ip) && (code>=low && code <= high)){
            uniqueIps.add(ip);
            inRange++;
            }
          }
          return inRange;
        }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
