import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project 3
 * @author Braxton Wilkinson
 */

public class MesoLexicographical extends MesoSortedAbstract {
	
	/**
	 * MesoLexicographical constructor, initializes an object with the sortedMap method call.
	 * @param asciiVal An unsorted HashMap of station IDs.
	 */
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		Map<String, Integer> sortedAsciiVal = sortedMap(asciiVal);
		for (String y : sortedMap(asciiVal).keySet()) {
			System.out.println(y + " " + sortedAsciiVal.get(y));
		}
	}

	/**
	 * Sorts the given HashMap of station IDs and returns a Map.
	 * @param unsorted An unsorted HashMap of station IDs.
	 */
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		Map<String, Integer> result = unsorted.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(
				Map.Entry::getKey, 
				Map.Entry::getValue, 
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		return result;
	}
}