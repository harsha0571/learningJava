
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer test = new LogAnalyzer();
        test.readFile("short-test_log");
        test.printAll();
    }
    
    public void testUniqueIP(){
    LogAnalyzer test = new LogAnalyzer();
    test.readFile("short-test_log");
    int unique = test.countUniqueIPs();
    System.out.println("no of unique ips:" + unique);
    }
    public void testStatusCode(){
    LogAnalyzer test = new LogAnalyzer();
    test.readFile("short-test_log");
    test.printAllHigherThanNum(200);
    }
    public void testVisitsOnDay(){
    LogAnalyzer test = new LogAnalyzer();
    test.readFile("weblog-short_log");
    ArrayList<LogEntry> list = test.uniqueIPVisitsOnDay("Sep 14");
    System.out.println("arraylist of "+list.size()+" items");
    ArrayList<LogEntry> list2 = test.uniqueIPVisitsOnDay("Sep 30");
    System.out.println("arraylist of "+list2.size()+" items");
    }
    public void testIPsInRange(){
    LogAnalyzer test = new LogAnalyzer();
    test.readFile("short-test_log");
    int no = test.countUniqueIPsInRange(200,299);
    System.out.println("200-299: " + no);
    no = test.countUniqueIPsInRange(300,399);
    System.out.println("300-399: " + no);
    }
}
