/**
 *  Tests the CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to fill the CellularData class.
 *
 * @author Foothill College, Parushi Sharma
 */
public class TestCSVReader
{

	/**
	 * Uses a CSVReader to parse a CSV file.
	 * Adds each parsed line to an instance of the CellularData class.
	 */
	public static void main(String[] args) 
	{	
		// NOTE: Make sure to use relative path instead of specifying the entire path 
		// (such as /Users/alicew/myworkspace/so_on_and_so_forth).
		final String FILENAME = "/Users/parushi/git/parushis-project03/resources/cellular_short.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)

		// TODO: Create the class CSVReader to parse the CSV data file
		//       The class constructor should only take a string as argument
		//       for the name of the input file.
		//       The constructor should fill the array of country names, year labels, etc.
		// NOTE: Handle all exceptions in the constructor.
		//       For full credit, do *not* throw exceptions to main. 
		CSVReader parser = new CSVReader(FILENAME);

		// TODO: In class CSVReader the accessor methds should only return values
		//       at instance variables.
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		

		// Stores the 2D array of cellular data for all countries.
		CellularData datatable;
		int numRows = parsedTable.length;
		int numColumns = parser.getNumberOfYears();
		int startingYear = yearLabels[0];
		

		datatable = new CellularData(numRows, numColumns, startingYear);
		

		// From the array that stores parsed information,
		// add one country at a time to an object of type CellularData.
		for (int countryIndex = 0; countryIndex < countryNames.length; countryIndex++) {
			double [] countryData = parsedTable[countryIndex];
			datatable.addCountry(countryNames[countryIndex], countryData);					
		}

		System.out.printf(countryNames[0] + " (1960 to 2012): %.2f \n", datatable.getNumSubscriptionsInCountryForPeriod(countryNames[0],1960,2012));
		// the output is: 
		// Aruba (1960 to 2012): 1170.50 

		System.out.printf(countryNames[100] + " (1960 to 2012): %.2f \n", datatable.getNumSubscriptionsInCountryForPeriod(countryNames[100],1960,2012));
		// the output is: 
		// Hungary (1960 to 2012): 1246.58 

		System.out.printf(countryNames[200] + " (1960 to 2012): %.2f \n", datatable.getNumSubscriptionsInCountryForPeriod(countryNames[200],1960,2012));
		// the output is: 
		// Singapore (1960 to 2012): 1582.80


        // TODO: For full credit, include test cases in addition to those provided.
		//
		// TODO: Also, make sure to test for other invalid requests for range of years.
	}
}
