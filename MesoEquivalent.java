import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Project 3
 * @author Braxton Wilkinson
 */

public class MesoEquivalent {
	
	/**
	 * A MesoAsciiCal object
	 */
	private MesoAsciiCal asciiAverage;
	
	/**
	 * The Ascii average of two station IDs
	 */
	private int asciiAvg = 0;
	
	/**
	 * MesoEquivalent constructor, initializes an object with asciiAverage and asciiAvg
	 * @param stid
	 */
	public MesoEquivalent(String stid) {
		asciiAverage = new MesoAsciiCal(new MesoStation(stid));
		this.asciiAvg = asciiAverage.calAverage();
	}

	/**
	 * Reads through the "Mesonet.txt" file and retrieve the station IDs. Then compare the Ascii average 
	 * of the station ID to the given Ascii average, and if equal then add to the HashMap.
	 * @return A HashMap of String and Integer containing Station IDs with the given Ascii average
	 * @throws IOException
	 */
	public HashMap<String, Integer> calAsciiEqual() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Mesonet.txt"));
		String input = reader.readLine();
		input = reader.readLine();
		input = reader.readLine();
		input = reader.readLine();
		
		String station = "";
		String letter = "";
		int j = 0;
		HashMap<String, Integer> stationHash = new HashMap<String, Integer>();
		
		while (input!=null) {
			j = 0;
			station = "";
			for (int i=0; i<4;) {
				letter = input.substring(j,j+1);
				if (letter.equals(" ")) {
					j++;
				} else {
					station += letter;
					i++;
					j++;
				}
			}
			MesoAsciiCal asciiCalStation = new MesoAsciiCal(new MesoStation(station));
			int stationAsciiAvg = asciiCalStation.calAverage();
			if (asciiAvg==stationAsciiAvg) {
				stationHash.put(station, asciiAvg);
			}
			input = reader.readLine();
		}
		reader.close();
		return stationHash;
	}

}
