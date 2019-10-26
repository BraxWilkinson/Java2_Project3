import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DateTimeOne extends MesoDateTimeOneAbstract {
	
	private LocalDateTime myTime;
	private HashMap<String,LocalDateTime> myHash;
	
	public DateTimeOne() {
		myTime = LocalDateTime.now();
		myHash = new HashMap<String, LocalDateTime>();
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
	   DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	   System.out.println(pattern.format(myTime));
   }
   
   public void dateTimeOfOtherCity() {
	   DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mm");
	   LocalDateTime tempTime = myTime;
	   System.out.println("Time on Server: " + tempTime.format(pattern));
	   System.out.println("GMT: " + LocalDateTime.now(ZoneId.of("GMT")).format(pattern));
	   System.out.println("BST (90E): " + LocalDateTime.now(ZoneId.of("BST")).format(pattern));
	   System.out.print("CST (90W): " + LocalDateTime.now(ZoneId.of("CST")).format(pattern));
   }
   
   public void dateTimeDifferentZone() {
	   //TODO
   }
   
   public void timeZoneHashMap() {
	   //TODO
   }
}