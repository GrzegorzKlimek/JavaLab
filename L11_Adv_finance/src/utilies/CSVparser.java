package utilies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVparser {

	
	public String []  read (String pathToCSVFile) throws IOException {	
	        String line;
	        String cvsSplitBy = ",";
	        BufferedReader bufferReader = new BufferedReader(new FileReader(pathToCSVFile)); 
			line = bufferReader.readLine();		
			return line.split(cvsSplitBy);
	}
	     


}
