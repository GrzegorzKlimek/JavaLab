package wwsis.wypozyczalnia.view.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import wwsis.wypozyczalnia.controller.AppController;
import wwsis.wypozyczalnia.view.View;

public class ConsoleView implements View {
	
	private BufferedReader br;
	private AppController controller;
	
	public ConsoleView() {
		br = new BufferedReader(new InputStreamReader(System.in));
		controller = new AppController();
	}
	
	public void addNewCar() throws NumberFormatException, IOException { 
		System.out.println("Model of car?");
		String model = br.readLine();
		System.out.println("Year of production?");
		int yearOfProduction = Integer.parseInt(br.readLine());
		System.out.println("Course of car?");
		int course = Integer.parseInt(br.readLine());
		controller.addNewCar(model, yearOfProduction, course);
		System.out.println("New car has been added");
	}
	
	public void addNewCustomer() throws IOException {
		System.out.println("NIP of new customer");
	}
	
	@Override
	public void run() {
		boolean programIsterminated = false;
		while ( !programIsterminated) {
			
			
		}

	}

}
