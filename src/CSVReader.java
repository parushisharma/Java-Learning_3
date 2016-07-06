import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
	private String[] countryNames;
	private int[] yearLabels;
	private double[][] cellularDatatables;
	Scanner scan;

	//throws FileNotFoundException. This method sets up the Scanner and reads in a filename given in the test file. 
	public CSVReader(String filename) { 
	    try {
	    java.io.File file = new java.io.File(filename);
	    Scanner scan = new Scanner(file);
	    scan.nextLine();
	    	while(scan.hasNextLine()) { // Check to ensure values don't go null. 
	    		String numLine = scan.nextLine();
	    		final int n = Integer.parseInt(numLine.split(",")[1]); //Number is the string portion after the first comma
	    		
	    		//Create proper arrays with length n
	    		this.countryNames = new String[n];
	    		this.cellularDatatables = new double[n][];
	    
	    
	    		//Read in the header line of years, parse and copy into yearNum
	    		String[] yearHeaders = scan.nextLine().split(",");
	    		final int m = yearHeaders.length-1; // minus one because its reading from an array. 
	    		yearLabels = new int[m]; // create new array of the YearLabels.
	    			for(int i = 0;i < m;i++) {
	    				this.yearLabels[i] = Integer.parseInt(yearHeaders[i+1]); //i+1 to skip the first entry in the string array 
	    			}
	
	    		//Now read until we run out of lines - put the first in country names and the rest in the table
	    		int c = 0;
	    		while(scan.hasNext()) {
	    			String[] inputArr = scan.nextLine().split(",");
	    			countryNames[c] = inputArr[0]; // fill in the countryNames Array 
	    			cellularDatatables[c] = new double[m]; // fill in the CellularDatatables array 
	    				for(int i = 0; i < m; i++) { 
	    					cellularDatatables[c][i] = Double.parseDouble(inputArr[i+1]);
	    				}
	    				c++;
	    		}
	    		
	    			
	    	}
	    	scan.close();
	    }
	
	    catch(FileNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	// This method returns the country names 
	public String[] getCountryNames() {
		return this.countryNames;
	}
	    
	// This method returns the getYearlabels 
	public int[] getYearLabels() {
		return this.yearLabels;
	}
	    
	// This method returns the cellularDatatables 
	public double[][] getParsedTable() {
		return this.cellularDatatables;
	}
	    
	// This method returns the number of years 
	public int getNumberOfYears() {
		return this.yearLabels.length;
	}
}