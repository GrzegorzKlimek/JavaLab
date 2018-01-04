import java.io.IOException;

import logic.PollsManager;
import view.ConsoleView;

public class Runner {
	
	public static void main(String [] args) throws IOException {
		ConsoleView cv = new ConsoleView(new PollsManager());
		//cv.run();
	}

}
