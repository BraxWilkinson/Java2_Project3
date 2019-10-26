import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;

public class DateTimeOne extends MesoDateTimeOneAbstract {
	
	private LocalDateTime myTime;
	private HashMap<String,String> stringHash;
	private DateTimeFormatter printPattern = DateTimeFormatter.ofPattern("hh:mm");
	private DateTimeFormatter hashPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
	
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
	   System.out.println(printPattern.format(myTime));
   }
   
   public void dateTimeOfOtherCity() {
	   stringHash.put("GMT", LocalDateTime.now(ZoneId.of("GMT")).format(hashPattern));
	   stringHash.put("BST", LocalDateTime.now(ZoneId.of("BST")).format(hashPattern));
	   stringHash.put("CST", LocalDateTime.now(ZoneId.of("CST")).format(hashPattern));
	   
	   System.out.println("Time on Server: " + myTime.format(hashPattern));
	   System.out.println("GMT: " + stringHash.get("GMT"));
	   System.out.println("BST (90E): " + stringHash.get("BST"));
	   System.out.print("CST (90W): " + stringHash.get("CST"));
   }
   
   public void dateTimeDifferentZone() {
	   stringHash.put("ZST", "11/05/2018 19:59");
	   stringHash.put("AST", "10/01/2020 19:59");
	   
	   HashMap<String,String> secondStringHash = new HashMap<String,String>();
	   secondStringHash.put(stringHash.get("GMT"),"GMT");
	   secondStringHash.put(stringHash.get("BST"),"BST");
	   secondStringHash.put(stringHash.get("CST"),"CST");
	   secondStringHash.put(stringHash.get("ZST"),"ZST");
	   secondStringHash.put(stringHash.get("AST"),"AST");
	   
	   DateTimeFormatter arrayPattern = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm");
	   LocalDateTime[] dateArray = new LocalDateTime[5];
	   dateArray[0] = LocalDateTime.parse(stringHash.get("GMT"),arrayPattern);
	   dateArray[1] = LocalDateTime.parse(stringHash.get("BST"),arrayPattern);
	   dateArray[2] = LocalDateTime.parse(stringHash.get("CST"),arrayPattern);
	   dateArray[3] = LocalDateTime.parse(stringHash.get("ZST"),arrayPattern);
	   dateArray[4] = LocalDateTime.parse(stringHash.get("AST"),arrayPattern);
	   
	   System.out.println("Print Style 1: ");
	   
	   
   }
   
   public void timeZoneHashMap() {
	   //TODO
   }
}