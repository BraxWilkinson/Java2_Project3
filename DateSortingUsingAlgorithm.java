import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Project 3
 * @author Braxton Wilkinson
 */

public class DateSortingUsingAlgorithm {
	
	/**
	 * Map containing LocalDates and Integers
	 */
	private Map<LocalDate,Integer> dateHash = new HashMap<LocalDate,Integer>();
	
	/**
	 * DateSortingUsingAlgorithm constructor, initializes and object with the dateHash Map and fills it
	 * with the output of the reader method.
	 */
	public DateSortingUsingAlgorithm() {
		try {
			dateHash = reader();
		} catch (IOException e) {
			System.out.println("DateSortingUsingAlgortithm reader unsuccessful");
			e.printStackTrace();
		}
	}
	
	/**
	 * Takes the keys from the dateHash Map and sort them in descending order using a Bubble Sort
	 * algorithm, then prints them out in order.
	 */
	public void dateHashMapSortedDescending() {
		ArrayList<LocalDate> dateList = new ArrayList<LocalDate>(dateHash.keySet());
		LocalDate tempSwap;
		// Sort the ArrayList in descending order according to the Bubble Sort algorithm
		for (int j=0; j<dateList.size()-1; j++) {
			for (int i=0; i<dateList.size()-j-1; i++) {
				if (dateList.get(i).getYear() == dateList.get(i+1).getYear()) {
					if (dateList.get(i).getMonthValue() == dateList.get(i+1).getMonthValue()) {
						if (dateList.get(i).getDayOfMonth() < dateList.get(i+1).getDayOfMonth()) {
							tempSwap = dateList.get(i);
							dateList.remove(i);
							dateList.add(i+1, tempSwap);
						}
					} else if (dateList.get(i).getMonthValue() < dateList.get(i+1).getMonthValue()) {
						tempSwap = dateList.get(i);
						dateList.remove(i);
						dateList.add(i+1, tempSwap);
					}
				} else if (dateList.get(i).getYear() < dateList.get(i+1).getYear()) {
					tempSwap = dateList.get(i);
					dateList.remove(i);
					dateList.add(i+1, tempSwap);
				}
			}
		}
		// Print out the results of Bubble Sort
		for (int k=0; k<dateList.size(); k++) {
			System.out.println(dateList.get(k));
		}
	}
	
	/**
	 * Takes the keys from the dateHash Map and sort them in ascending order using a Bubble Sort
	 * algorithm, then prints them out in order.
	 */
	public void dateHashMapSorted() {
		ArrayList<LocalDate> dateList = new ArrayList<LocalDate>(dateHash.keySet());
		LocalDate tempSwap;
		// Sort the ArrayList in ascending order according to the Bubble Sort algorithm
		for (int j=0; j<dateList.size()-1; j++) {
			for (int i=0; i<dateList.size()-j-1; i++) {
				if (dateList.get(i).getYear() == dateList.get(i+1).getYear()) {
					if (dateList.get(i).getMonthValue() == dateList.get(i+1).getMonthValue()) {
						if (dateList.get(i).getDayOfMonth() > dateList.get(i+1).getDayOfMonth()) {
							tempSwap = dateList.get(i);
							dateList.remove(i);
							dateList.add(i+1, tempSwap);
						}
					} else if (dateList.get(i).getMonthValue() > dateList.get(i+1).getMonthValue()) {
						tempSwap = dateList.get(i);
						dateList.remove(i);
						dateList.add(i+1, tempSwap);
					}
				} else if (dateList.get(i).getYear() > dateList.get(i+1).getYear()) {
					tempSwap = dateList.get(i);
					dateList.remove(i);
					dateList.add(i+1, tempSwap);
				}
			}
		}
		// Print out the results of Bubble Sort
		for (int k=0; k<dateList.size(); k++) {
			System.out.println(dateList.get(k));
		}
	}
	
	/**
	 * Reads through the "SortingDates.txt" file, removes the white space from the entries, parses them into LocalDates 
	 * and inserts them as keys into a Map with iterative integers as the values.
	 * @return A Map of LocalDates and Integers containing the entries retrieved from the file.
	 * @throws IOException
	 */
	public Map<LocalDate,Integer> reader() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("SortingDates.txt"));
		String input = reader.readLine();
		Map<LocalDate,Integer> readerHash = new HashMap<LocalDate,Integer>();
		DateTimeFormatter readerHashPattern = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy-MM-dd").toFormatter(Locale.ENGLISH);
		int i = 0;
		while (input!=null) {
			input=input.replaceAll("\\s+","");
			LocalDate hashPut = LocalDate.parse(input, readerHashPattern);
			readerHash.put(hashPut,i);
			input = reader.readLine();
			i++;
		}
		reader.close();
		return readerHash;
	}
}
