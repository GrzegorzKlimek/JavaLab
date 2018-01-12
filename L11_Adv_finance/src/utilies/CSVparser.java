package utilies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVparser {

	
	public String []  read (String pathToCSVFile) throws IOException {	
	        String line;
	        String cvsSplitBy = ",";
	        BufferedReader bufferReader = new BufferedReader(new FileReader(pathToCSVFile)); 
			line = bufferReader.readLine();	
			bufferReader.close();
			return line.split(cvsSplitBy);
	}


}
