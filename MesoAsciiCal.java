
/**
 * Project 3
 * @author Braxton Wilkinson
 */

public class MesoAsciiCal extends MesoAsciiAbstract {
	
	/**
	 * The station ID
	 */
	private String stid;
	
	/**
	 * MesoAcsiiCal constructor, initializes an object with a station ID.
	 * @param stid
	 */
	public MesoAsciiCal(MesoStation stid) {
		this.stid = stid.getStID();
	}
	
	/**
	 * Calculates the Ascii average of the given station ID and NRMN.
	 */
	public int calAverage() {
		int[] result = new int[6];
		
		int char1 = stid.charAt(0);
		int char2 = stid.charAt(1);
		int char3 = stid.charAt(2);
		int char4 = stid.charAt(3);
		
		double charAvg = (char1 + char2 + char3 + char4)/4.0;
		result[0] = (int)Math.ceil(charAvg);
		result[1] = (int)Math.floor(charAvg);
		
		double decimalVal = charAvg - (int)charAvg;
		if (decimalVal<0.25) {
			result[2] = result[1];
		} else {
			result[2] = result[0];
		}
		
		String fixedStation = "NRMN";
		char1 = fixedStation.charAt(0);
		char2 = fixedStation.charAt(1);
		char3 = fixedStation.charAt(2);
		char4 = fixedStation.charAt(3);
		
		charAvg = (char1 + char2 + char3 + char4)/4.0;
		result[3] = (int)Math.ceil(charAvg);
		result[4] = (int)Math.floor(charAvg);
		
		decimalVal = charAvg - (int)charAvg;
		if (decimalVal<0.25) {
			result[5] = result[4];
		} else {
			result[5] = result[3];
		}
		
		int finalAvg = (int)Math.ceil((result[2]+result[5])/2.0);
		return finalAvg;
	}
}