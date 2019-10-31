# Java2_Project3
OU Fall 2019 - CS 2334 - Java 2 Project 3

Author: Braxton Wilkinson

Version: 10/30/2019
## Description
This program is built to read the text files Dates.txt, Mesonet.txt, and SortingDates.txt and return the 

output as specified by the Main class and Project 3 description. 

## Usage
This program is built to operate as specified by the given Main.java driver class.

# Classes

## DateTimeOne extends MesoDateTimeOneAbstract
### Private fields
LocalDateTime myTime - The current time

Map<String,String> stringHash - A map with String keys and values

### Constructor
DateTimeOne constructor, initializes an object with myTime and stringHash

### public int getValueOfSecond()
@return The value of seconds of the current time

### public void sleepForFiveSec()
Sleep the program for 5 seconds

### public void dateTimeNow()
Print the current date and time

### public void dateTimeOfOtherCity()
Print the current time in time zones CST, GMT, BST and CST.

### public void dateTimeDifferentZone()
Print the current date and time in time zones GMT, BST and CST and add them to the stringHash map

### public void timeZoneHashMap()
Add the ZST and AST time zones to the stringHash map and create a second HashMap of Strings with

the values and keys of the first map swapped. Then print out the maps in Styles 1, 3, and 5.

## DateTimeTwo
### Private fields
LocalDate currentDate - The current date

Map<LocalDate,Integer> dateHash - A Map containing LocalDates and Integers

### Constructor 
DateTimeTwo constructor, initializes an object with currentDate and dateHash

### public void daysOfCurrentMonth()
Prints out the 10th and 18th days of this month

### public void daysOfAnyMonth(int month, int year)
Prints out the 15th and last day of the given month and year

@param month The given month

@param year The given year

### public void compareYear() throws IOException
Read through the file "Dates.txt". For each entry, determine if the year is a leap year, then find 

the difference between the given date and the current date. Then enter the date into the dateHash

Map.

@throws IOException

### public void dateHashMap()
Print out the dateHash Map.

### public void dateHashMapSorted()
Sort the dateHash Map and then print it in order.

## DateSortingUsingAlgorithm
### Private fields
Map<LocalDate,Integer> dateHash - Map containing LocalDates and Integers

### Constructor
DateSortingUsingAlgorithm constructor, initializes and object with the dateHash Map and fills it

with the output of the reader method.

### public void dateHashMapSortedDescending()
Takes the keys from the dateHash Map and sort them in descending order using a Bubble Sort 

algorithm, then prints them out in order.

### public void dateHashMapSorted()
Takes the keys from the dateHash Map and sort them in ascending order using a Bubble Sort

algorithm, then prints them out in order.

### public Map<LocalDate,Integer> reader() throws IOException
Reads through the "SortingDates.txt" file, removes the white space from the entries, parses them into LocalDates 

and inserts them as keys into a Map with iterative integers as the values.

@return A Map of LocalDates and Integers containing the entries retrieved from the file.

@throws IOException

## MesoEquivalent
### Private fields
MesoAsciiCal asciiAverage - A MesoAsciiCal object

int asciiAvg - The Ascii average of two station IDs

### public MesoEquivalent(String stid)
MesoEquivalent constructor, initializes an object with asciiAverage and asciiAvg

@param stid

### public HashMap<String, Integer> calAsciiEqual() throws IOException
Reads through the "Mesonet.txt" file and retrieve the station IDs. Then compare the Ascii average 

of the station ID to the given Ascii average, and if equal then add to the HashMap.

@return A HashMap of String and Integer containing Station IDs with the given Ascii average

@throws IOException

## MesoAsciiCal extends MesoAsciiAbstract
### Private fields
String stid - The station ID

### Constructor
MesoAcsiiCal constructor, initializes an object with a station ID.

@param stid

### public int calAverage()
Calculates the Ascii average of the given station ID and NRMN.

## MesoLexicographical extends MesoSortedAbstract
### Constructor
MesoLexicographical constructor, initializes an object with the sortedMap method call.

@param asciiVal An unsorted HashMap of station IDs.

### public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted)
Sorts the given HashMap of station IDs and returns a Map.

@param unsorted An unsorted HashMap of station IDs.
