import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
	private String[] countryNames;
	private int[] yearLabels;
	private double[][] cellularDatatables;
	Scanner scan;

	//throws FileNotFoundException
	public CSVReader(String filename) { 
	    try {
	    java.io.File file = new java.io.File(filename);
	    Scanner scan = new Scanner(file);
	    scan.nextLine();
	    	while(scan.hasNextLine()) {
	    		String numLine = scan.nextLine();
	    		final int n = Integer.parseInt(numLine.split(",")[1]); //Number is the string portion after the first comma
	    		//Allocate arrays with length n
	    		countryNames = new String[n];
	    		cellularDatatables = new double[n][];
	    
	    
	    		//Read in the header line of years, parse and copy into yearNum
	    		String[] yearHeaders = scan.nextLine().split(",");
	    		final int m = yearHeaders.length-1;
	    		yearLabels = new int[m];
	    			for(int i=0;i<m;i++) {
	    				this.yearLabels[i] = Integer.parseInt(yearHeaders[i+1]); //i+1 to skip the first entry in the string arr
	    			}
	
	    			//Now read until we run out of lines - put the first in country names and the rest in the table
	    			int c = 0;
	    			while(scan.hasNext()) {
	    				String[] inputArr = scan.nextLine().split(",");
	    				countryNames[c] = inputArr[0];
	    				cellularDatatables[c] = new double[m];
	    				for(int i = 0; i < m; i++) {
	    					cellularDatatables[c][i] = Double.parseDouble(inputArr[i+1]);
	    				}
	    			}
	    			scan.close();
	    	}
	    }
	
	    catch(FileNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
	    public String[] getCountryNames(){
	        return this.countryNames;
	    }
	    public int[] getYearLabels(){
	        return this.yearLabels;
	    }
	    public double[][] getParsedTable(){
	        return this.cellularDatatables;
	    }
	    public int getNumberOfYears()
	    {
	        return this.yearLabels.length;
	    }
	}