package utilies;

public class Converter {
	
	public double [] convertTextIntoNumbers (String [] sringNumbers) {
		double [] numbers = new double [sringNumbers.length];
		for (int i = 0; i < sringNumbers.length; i++) {
			numbers[i] = Double.parseDouble(sringNumbers[i]);
		}
		return numbers;
	} 

}
