package wwsis.wypozyczalnia.runner;

import wwsis.wypozyczalnia.view.View;
import wwsis.wypozyczalnia.view.console.ConsoleView;

public class Runner {

	public static void main(String[] args) {
		View conloseInterface = new ConsoleView();
		conloseInterface.run();
	}

}
