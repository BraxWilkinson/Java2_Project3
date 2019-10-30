import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Project 3
 * @author Braxton Wilkinson
 */

public class DateTimeOne extends MesoDateTimeOneAbstract {
	
	/**
	 * The current time
	 */
	private LocalDateTime myTime;
	
	/**
	 * A map with String keys and values
	 */
	private Map<String,String> stringHash;
	
	/**
	 * DateTimeOne constructor, initializes an object with myTime and stringHash
	 */
	public DateTimeOne() {
		myTime = LocalDateTime.now();
		stringHash = new HashMap<String, String>();
   }
   
	/**
	 * @return The value of seconds of the current time
	 */
   public int getValueOfSecond() {
	   return myTime.getSecond();
   }
   
   /**
    * Sleep the program for 5 seconds
    */
   public void sleepForFiveSec() {
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		System.out.println("Sleep interrupted");
		e.printStackTrace();
	}
   }
   
   /**
    * Print the current date and time
    */
   public void dateTimeNow() {
	   DateTimeFormatter nowPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	   System.out.println("Current Date/Time: " + nowPattern.format(myTime));
   }
   
   /**
    * Print the current time in time zones CST, GMT, BST and CST
    */
   public void dateTimeOfOtherCity() {
	   DateTimeFormatter hashPattern = DateTimeFormatter.ofPattern("HH:mm");
	   
	   System.out.println("Time on Server: " + myTime.format(hashPattern));
	   System.out.println("GMT: " + LocalDateTime.now(ZoneId.of("Z")).format(hashPattern));
	   System.out.println("BST (90E): " + LocalDateTime.now(ZoneId.of("Asia/Dhaka")).format(hashPattern));
	   System.out.println("CST (90W): " + LocalDateTime.now(ZoneId.of("America/Chicago")).format(hashPattern));
   }
   
   /**
    * Print the current date and time in time zones GMT, BST and CST and add them to the stringHash map
    */
   public void dateTimeDifferentZone() {
	   DateTimeFormatter printPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	   stringHash.put("GMT", LocalDateTime.now(ZoneId.of("Z")).format(printPattern));
	   stringHash.put("BST", LocalDateTime.now(ZoneId.of("Asia/Dhaka")).format(printPattern));
	   stringHash.put("CST", LocalDateTime.now(ZoneId.of("America/Chicago")).format(printPattern));
	   
	   System.out.println("GMT: " + stringHash.get("GMT"));
	   System.out.println("BST: " + stringHash.get("BST"));
	   System.out.println("CST: " + stringHash.get("CST"));
   }
   
   /**
    * Add the ZST and AST time zones to the stringHash map and create a second HashMap of Strings with
    * the values and keys of the first map swapped. Then print out the maps in Styles 1, 3, and 5.
    */
   public void timeZoneHashMap() {
	   stringHash.put("ZST", "11/05/2018 19:59");
	   stringHash.put("AST", "10/01/2020 19:59");
	   
	   HashMap<String,String> secondStringHash = new HashMap<String,String>();
	   secondStringHash.put(stringHash.get("GMT"),"GMT");
	   secondStringHash.put(stringHash.get("BST"),"BST");
	   secondStringHash.put(stringHash.get("CST"),"CST");
	   secondStringHash.put(stringHash.get("ZST"),"ZST");
	   secondStringHash.put(stringHash.get("AST"),"AST");
	   
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
	   
	   DateTimeFormatter arrayPattern = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MM/dd/yyyy HH:mm").toFormatter(Locale.ENGLISH);
       ArrayList<LocalDateTime> dateArray = new ArrayList<LocalDateTime>();
	   dateArray.add(LocalDateTime.parse(stringHash.get("GMT"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("BST"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("CST"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("ZST"),arrayPattern));
	   dateArray.add(LocalDateTime.parse(stringHash.get("AST"),arrayPattern));
	   
	   System.out.println("Print Style 5: Final sorted Array:");
	   Collections.sort(dateArray);
	   for (LocalDateTime z : dateArray) {
		   String entry = z.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		   System.out.println(entry.substring(0, 16));
	   }
   }
}