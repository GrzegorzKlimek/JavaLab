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
		System.out.println("give NIP of new customer");
		long nip = Long.parseLong(br.readLine());
		System.out.println("Give name of new customer");
		String name = br.readLine();
		System.out.println("Give last name of new customer");
		String lastName = br.readLine();
		System.out.println("Give numbert of new customer");
		long telephone = Long.parseLong(br.readLine());

		controller.addNewCustomer(nip, name, lastName, telephone);
	}
	

	private void makeReservation() throws NumberFormatException, IOException {
		System.out.println("Give your NIP");
		long customerID;
		boolean customerExist;
		do {
			customerID = Long.parseLong(br.readLine());
			customerExist = controller.doCustomerExist(customerID);
			if (!customerExist) {
				System.out.println(
						"You are not in the system. You need to register first" + "If you want to register press 'r'"
								+ "If you want to try again press 'c'" + "If you want go back press anything else");
				String decision = br.readLine();
				switch (decision) {
				case "r":
					addNewCustomer();
					break;
				case "c":
					break;
				default:
					return;
				}
			}

		} while (!customerExist);

	}

	@Override
	public void run() {
		boolean programIsterminated = false;
		while (!programIsterminated) {

		}

	}

}
