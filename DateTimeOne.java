import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DateTimeOne extends MesoDateTimeOneAbstract {
	
	private LocalDateTime myTime;
	private HashMap<String,String> stringHash;
	
	public DateTimeOne() {
		myTime = LocalDateTime.now();
		stringHash = new HashMap<String, String>();
   }
   
   public int getValueOfSecond() {
	   return myTime.getSecond();
   }
   
   public void sleepForFiveSec() {
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		System.out.println("Sleep interrupted");
		e.printStackTrace();
	}
   }
   
   public void dateTimeNow() {
	   DateTimeFormatter nowPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	   System.out.println("Current Date/Time: " + nowPattern.format(myTime));
   }
   
   public void dateTimeOfOtherCity() {
	   DateTimeFormatter hashPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
	   stringHash.put("GMT", LocalDateTime.now(ZoneId.of("Z")).format(hashPattern));
	   stringHash.put("BST", LocalDateTime.now(ZoneId.of("Asia/Dhaka")).format(hashPattern));
	   stringHash.put("CST", LocalDateTime.now(ZoneId.of("America/Chicago")).format(hashPattern));
	   
	   System.out.println("Time on Server: " + myTime.format(hashPattern));
	   System.out.println("GMT: " + stringHash.get("GMT"));
	   System.out.println("BST (90E): " + stringHash.get("BST"));
	   System.out.println("CST (90W): " + stringHash.get("CST"));
   }
   
   public void dateTimeDifferentZone() {
	   DateTimeFormatter printPattern = DateTimeFormatter.ofPattern("hh:mm");
	   System.out.println("GMT: " + LocalDateTime.now(ZoneId.of("Z")).format(printPattern));
	   System.out.println("BST: " + LocalDateTime.now(ZoneId.of("Asia/Dhaka")).format(printPattern));
	   System.out.println("CST: " + LocalDateTime.now(ZoneId.of("America/Chicago")).format(printPattern));
   }
   
   public void timeZoneHashMap() {
	   stringHash.put("ZST", "11/05/2018 19:59");
	   stringHash.put("AST", "10/01/2020 19:59");
	   
	   HashMap<String,String> secondStringHash = new HashMap<String,String>();
	   secondStringHash.put(stringHash.get("GMT"),"GMT");
	   secondStringHash.put(stringHash.get("BST"),"BST");
	   secondStringHash.put(stringHash.get("CST"),"CST");
	   secondStringHash.put(stringHash.get("ZST"),"ZST");
	   secondStringHash.put(stringHash.get("AST"),"AST");
	   
	   DateTimeFormatter arrayPattern = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm");
	   ArrayList<LocalDateTime> dateArray = new ArrayList<LocalDateTime>();
	   dateArray.add(LocalDateTime.parse(stringHash.get("GMT"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("BST"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("CST"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("ZST"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("AST"),arrayPattern));
	   
	   System.out.println("Print Style 1: ");
	   ArrayList<String> sortedKeys1 = new ArrayList<String>(stringHash.keySet()); 
	   Collections.sort(sortedKeys1);  
	   for (String x : sortedKeys1) {
		   System.out.println(x + stringHash.get(x));
	   }
	   
	   System.out.println("Print Style 3: ");
	   ArrayList<String> sortedKeys2 = new ArrayList<String>(secondStringHash.keySet()); 
	   Collections.sort(sortedKeys2);  
	   for (String y : sortedKeys2) {
		   System.out.println(y);
	   }
	   
	   System.out.println("Print Style 3: ");
	   Collections.sort(dateArray);  
	   for (LocalDateTime z : dateArray) {
		   System.out.println(z);
	   }
   }
}