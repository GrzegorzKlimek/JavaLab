package wwsis.wypozyczalnia.view.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.attribute.standard.NumberUp;

import wwsis.wypozyczalnia.controller.AppController;
import wwsis.wypozyczalnia.view.View;

public class ConsoleView implements View {

	private BufferedReader br;
	private AppController controller;

	public ConsoleView() {
		br = new BufferedReader(new InputStreamReader(System.in));
		controller = new AppController();
	}

	private void addNewCar() throws NumberFormatException, IOException {
		System.out.println("Model of car?");
		String model = br.readLine();
		System.out.println("Year of production?");
		int yearOfProduction = Integer.parseInt(br.readLine());
		System.out.println("Course of car?");
		int course = Integer.parseInt(br.readLine());
		controller.addNewCar(model, yearOfProduction, course);
		System.out.println("New car has been added");
	}

	private void addNewCustomer() throws IOException {
		System.out.println("give your NIPr");
		long nip = Long.parseLong(br.readLine());
		System.out.println("Give  your name");
		String name = br.readLine();
		System.out.println("Give your last name");
		String lastName = br.readLine();
		System.out.println("Give lour telephone number");
		long telephone = Long.parseLong(br.readLine());

		controller.addNewCustomer(nip, name, lastName, telephone);
	}
	
	private Long getNIPFromUser() throws IOException {
		
		System.out.println("Give your NIP");

		return Long.parseLong(br.readLine());
		
	}
	

	private void makeReservation() {

	}

	@Override
	public void run()  {
		boolean programIsNotTerminated = true;
		
		while (programIsNotTerminated) {
			try {
				String decision = br.readLine();
				switch (decision) {
				case "customer":
					break;
				case "reser":
					break;
				case "d":
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
