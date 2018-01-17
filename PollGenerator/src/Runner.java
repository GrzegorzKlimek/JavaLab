import java.io.IOException;

import logic.PollsManager;
import view.CommandLineView;

public class Runner {
	
	public static void main(String [] args) throws IOException {

		CommandLineView view = new CommandLineView();
		view.run();

	}

}
