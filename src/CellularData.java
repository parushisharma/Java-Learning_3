public class CellularData {

	private Object [][]table; // private to the client
	private int startingYear;
	
	// This method initializes the datatable/ header that contains the year. 
	public CellularData(int numRows, int numColumns, int year) {
		// create object with header. 
		table = new Object[numRows+1][numColumns+1];
		// Create header for country 
		table[0][0] = "Country";
		this.startingYear = year;
		for(int i=1;i<=numColumns;i++) {
			table[0][i] = year++;   //increments the year in the 0th row.
		}
	}
	
	// this method adds the single array of data given by the user in the 
	// test file into the double array created in the method above. 
	public void addCountry(String country, double []num) {
		for(int i = 0; i<table.length;i++) { // read through the table    
			if(table[i][0] == null) {    // create check to see if the first row is empty
				addCountry(country, num, i);  //inserts the data by using helper method 
				break;
			}
		}
	}
	
	// This is a helper method that is private to the client. 
	// It inserts the data into the table
	private void addCountry(String country, double []num, int row) {
		table[row][0] = country; // the country name given should be in the 0th row. 
		for(int j = 1;j < table[row].length;j++) { // read through the row 
			table[row][j] = num[j-1]; 
		}
	}
	
	// This method first checks the name of the country given and the names of the country in the table
	// then proceeds to find the index of the starting/ending year given by the test file to find the sum 
	// of the subscriptions of the proper country's subscriptions  in the proper years. 
	public double getNumSubscriptionsInCountryForPeriod(String country, int sYear, int eYear) {
		System.out.println("Country is " + "\"" + country +"\"," + " subscriptions from " + sYear + " to " + eYear);
		System.out.println("the output is:");
		double sum = 0; // Initialize sum.
		// read through table 
		for (int i = 1; i < table.length; i++) { 
			// cast the table double array as a String to be able to compare.
            if (country.equalsIgnoreCase((String) table[i][0])) { // passed ignoring CAPS 
                int start = 1 + sYear - startingYear;   //first index position of the year
                int end = start + (eYear - sYear);  //end position of the year

                if (start >= 0 && end < table[i].length) {   //checks to see if index position is out of bounds

                    for (int k = start; k <= end; k++) {
                        sum += (Double) table[i][k];   //sum of the subscriptions 
                    }
                }
                else {
                    //returns Error message and sets the sum to -1 
                    System.out.println("ERROR : requested year "+sYear+" from "+ country+" is less than starting year "+this.startingYear);
                    sum = -1;
                    }
            }
		}
		return sum;
    }
	
	//prints the array
	public String toString() { 
		for(Object []a: table) {
			for(Object k:a) {
				System.out.print(k + "\t");
			}
			System.out.println();
		}
		return " ";
    }

 }