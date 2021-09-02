
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
     public HashMap<String,Integer> countVisitsPerIp(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(LogEntry le:records){
            String ip = le.getIpAddress();
            if(!map.containsKey(ip)){
            map.put(ip,1);
            }
            else{
            map.put(ip,map.get(ip)+1);
            }
        }
         return map;
        }
     public int mostNumberVisitsByIp(HashMap<String,Integer> map){
        int max =0 ;
        for(String s : map.keySet()){
          if(map.get(s)>max)
           max=map.get(s);
          }
        return max;
        }
     public ArrayList<String> IpsMostVisits(HashMap<String,Integer> map ) {
        ArrayList<String> mostVisits = new ArrayList<String>();
         int max = mostNumberVisitsByIp(map);
         for(String s : map.keySet()){
            if(map.get(s)==max)
            mostVisits.add(s);
            }
         return mostVisits;
        }
     public HashMap<String,ArrayList<String>> IpsForDays(){
        HashMap<String,ArrayList<String>> map = 
        new HashMap<String,ArrayList<String>>();
        
        for(LogEntry log : records){
        Date date = log.getAccessTime();
        String time = date.toString();
        String actual = time.substring(4,10);
        String ip = log.getIpAddress();
        if(!map.containsKey(actual)){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(ip);
        map.put(actual,temp);
        }
        else{
        ArrayList<String> existing = map.get(actual);
        existing.add(ip);
        map.put(actual,existing);
        }
        }
        return map;
        }
     public String dayWithMostIpVisits(HashMap<String,ArrayList<String>> map ){
        String day="";
        int max = 0;
        for(String s : map.keySet()){
        ArrayList<String> ipOnDay = map.get(s);
        if(ipOnDay.size()>max){
        max=ipOnDay.size();
        day= s;
        }
        
        }
        return day;
        }
     public ArrayList<String> IpsWithMostVisitsOnDay
     (HashMap<String,ArrayList<String>> map , String day){
        ArrayList<String> IpsOnDay = new ArrayList<String>();
        HashMap<String,Integer> countIp = new HashMap<String,Integer>();
        ArrayList<String> temp = map.get(day);
        int max = 0;
        for(String str : temp){
            if(!countIp.containsKey(str)){
            countIp.put(str,1);
            }
            else{
            countIp.put(str,countIp.get(str)+1);
            }
        }
        for(String s: countIp.keySet()){
        if(countIp.get(s)>max)
        max=countIp.get(s);
        }
        for(String s: countIp.keySet()){
        if(countIp.get(s)==max)
        IpsOnDay.add(s);
        }
        return IpsOnDay;
        }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
