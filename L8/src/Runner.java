import logic.ValidatorOfHipothesis;

public class Runner {
	
	
	static public void main (String [] args) {
		
		ValidatorOfHipothesis validator = new ValidatorOfHipothesis();
		
		for (int i = 5; i < 100; i = i + 5) {
			String prefix = "For number of dates equal " + i + ": ";
			System.out.println(prefix + validator.validate(100, i, 0.05, 0.5));
		}
		
		
	}

}
