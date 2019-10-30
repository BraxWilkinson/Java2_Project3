import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Project 3
 * @author Braxton Wilkinson
 */

public class DateTimeTwo {
	
	/**
	 * The current date
	 */
	private LocalDate currentDate;
	
	/**
	 * A Map containing LocalDates and Integers
	 */
	private Map<LocalDate,Integer> dateHash;
	
	/**
	 * DateTimeTwo constructor, initializes an object with currentDate and dateHash
	 */
	public DateTimeTwo() {
		currentDate = LocalDate.now();
		dateHash = new HashMap<LocalDate,Integer>();
	}
	
	/**
	 * Prints out the 10th and 18th days of this month
	 */
	public void daysOfCurrentMonth() {
		YearMonth thisYearMonth = YearMonth.of(2019, 10);
		LocalDate thisLocalDate = thisYearMonth.atDay(10);
		String day10 = thisLocalDate.getDayOfWeek().name();
		
		LocalDate thisLocalDate2 = thisYearMonth.atDay(18);
		String day18 = thisLocalDate2.getDayOfWeek().name();
		
		System.out.println("The tenth day of this month is " + day10.toUpperCase() + " and eighteenth is " + day18.toUpperCase());
	}
	
	/**
	 * Prints out the 15th and last day of the given month and year
	 * @param month The given month
	 * @param year The given year
	 */
	public void daysOfAnyMonth(int month, int year) {
		YearMonth thisYearMonth = YearMonth.of(year, month);
		LocalDate thisLocalDate = thisYearMonth.atDay(15);
		String day15 = thisLocalDate.getDayOfWeek().name();
		
		LocalDate thisLocalDate2 = thisYearMonth.atDay(thisYearMonth.lengthOfMonth());
		String lastDay = thisLocalDate2.getDayOfWeek().name();
		System.out.println("For the year (" + year + ") and month (" + month + "), the fifteenth day is " + day15.toUpperCase() + " and the last day is " + lastDay.toUpperCase());
	}
	
	/**
	 * Read through the file "Dates.txt". For each entry, determine if the year is a leap year, then find 
	 * the difference between the given date and the current date. Then enter the date into the dateHash
	 * Map.
	 * @throws IOException
	 */
	public void compareYear() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Dates.txt"));
		String input = reader.readLine();
		int i=1;
		
		while (input!=null) {
			LocalDate inputDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
			boolean leapYear = inputDate.isLeapYear();
			
			int yearDifference = currentDate.getYear()-inputDate.getYear();
			int monthDifference = currentDate.getMonthValue()-inputDate.getMonthValue();
			int dayDifference = currentDate.getDayOfMonth()-inputDate.getDayOfMonth();
			
			if (dayDifference<0) {
				dayDifference = dayDifference/-1;
				monthDifference-=1;
			}
			if (monthDifference<0) {
				monthDifference = monthDifference/-1;
				yearDifference-=1;
			}
			
			if (leapYear==true) {
			System.out.println(inputDate.getYear() + " is a leap year, and Difference: " + yearDifference + " years, " + monthDifference + " months, " + dayDifference + " days.");
			} else {
			System.out.println(inputDate.getYear() + " is not a leap year, and Difference: " + yearDifference + " years, " + monthDifference + " months, " + dayDifference + " days.");
			}
			
			dateHash.put(inputDate, i);
			i++;
			input = reader.readLine();
		}
		reader.close();
	}
	
	/**
	 * Print out the dateHash Map.
	 */
	public void dateHashMap() {
		ArrayList<LocalDate> dates = new ArrayList<LocalDate>(dateHash.keySet()); 
		for (LocalDate x : dates) {
			System.out.println(x + ":" + dateHash.get(x));
		}
	}
	
	/**
	 * Sort the dateHash Map and then print it in order.
	 */
	public void dateHashMapSorted() {
		ArrayList<LocalDate> sortedDates = new ArrayList<LocalDate>(dateHash.keySet()); 
		Collections.sort(sortedDates);  
		for (LocalDate y : sortedDates) {
			System.out.println(y + ":" + dateHash.get(y));
		}
	}
}
