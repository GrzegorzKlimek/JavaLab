package wwsis.wypozyczalnia.view.command_line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import wwsis.wypozyczalnia.controller.AppController;
import wwsis.wypozyczalnia.model.Car;
import wwsis.wypozyczalnia.model.Customer;
import wwsis.wypozyczalnia.model.Renting;
import wwsis.wypozyczalnia.view.View;

public class CommandLineConsoleView implements View {
	
	private static String WRONG_COMMANT_MESSAGE = "Not understandeble command";
	private static String WRONG_NUMBER_OF_ARGUMENTS = "Wrong number of customers";
	private AppController controller;
	
	public CommandLineConsoleView() {
		controller = new AppController();
	}
	
	@Override
	public void run()  {
		String[] commands = {""};
		try {
			while (true) {
				commands = readCommandFromUSer();
				executeCommand(commands);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	private String [] readCommandFromUSer() throws IOException {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String commandLine = bufferReader.readLine();
		return commandLine.split(" ");
		 
	}
	
	private void executeCommand (String [] commands) {
		String firstCommand = commands[0];
		
		switch(firstCommand) {
		case "add":
			adding(tail(commands));
			break;
		case "list":
			listing(tail(commands));
			break;
		case "rent":
			rentACar(tail(commands));
			break;
		default:
			System.out.println(WRONG_COMMANT_MESSAGE);
		}
	}
	
	
	private String [] tail (String [] commands) {
		return Arrays.copyOfRange(commands, 1,commands.length);
	}
	
	private void listing (String [] commands) {
		if (commands.length < 1) {
			System.out.println(WRONG_COMMANT_MESSAGE);
		} else {
			String firstCommand = commands[0];
			switch(firstCommand) {
			case "cars":
				listCars();
				break;
			case "customers":
				listCustomers();
				break;
			case "reservations":
				listReservations(tail(commands));
				break;
			default:
				System.out.println(WRONG_COMMANT_MESSAGE);
			}			
		}
		
	}
	
	private void listCars() {
		Collection<Car> cars = controller.getCarsInSystem();
		System.out.println(cars);
	}
	
	private void listCustomers() {
		Collection<Customer> customers = controller.getCustomersInSystem();
		System.out.println(customers);
	}
	private void listReservations(String [] commands) {
		if (commands.length != 1) {
			System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
		} else {
			
			List<Renting> rentings = controller.rentingsOfCustomer(Long.parseLong(commands[0]));
			System.out.println(rentings);
		}
	}
	
	private void adding (String [] commands) {
		if (commands.length < 2) {
			System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
		} else {
			String firstCommand = commands[0];
			switch(firstCommand) {
			case "car":
				addNewCar(tail(commands));
				break;
			case "customer":
				addNewCustomer(tail(commands));
				break;
			default:
				System.out.println(WRONG_COMMANT_MESSAGE);
			}			
		}
	}
	
	private void addNewCar(String [] commands) {
		if (commands.length != 3) {
			System.out.println(WRONG_COMMANT_MESSAGE);
		} else {
			String model = commands[0];
			int yearOfProduction = Integer.parseInt(commands[1]);
			int course = Integer.parseInt(commands[2]);
			controller.addNewCar(model, yearOfProduction, course);
		}
		
	}
	
	private void addNewCustomer (String [] commands) {
		if (commands.length != 4) {
			System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
		} else {
			long NIP = Long.parseLong(commands[0]); 
			String name = commands[1] ;
			String lastName = commands[2] ;
			long telephone = Long.parseLong(commands[3]) ;
			controller.addNewCustomer(NIP, name, lastName, telephone);
		}
	} 
	
	private void rentACar(String [] commands) {
		if (commands.length != 4) {
			System.out.println(WRONG_NUMBER_OF_ARGUMENTS);
		} else {
			long nipCustomer = Long.parseLong(commands[0]); 
			int carId = Integer.parseInt(commands[1]); ;
			int days = Integer.parseInt(commands[2]);  
			int cost= Integer.parseInt(commands[3]);  
			
			boolean validCar = controller.doCarExist(carId);
			boolean validCustomer = controller.doCustomerExist(nipCustomer);
			boolean validDuration = days > 0;
			if (!validCar ) {
				System.out.println("There are no car with this id in the system");
			}
			
			if (!validCustomer) {
				System.out.println("There are no customer with this nip in the system");
			}
			
			if (!validDuration) {
				System.out.println("Cannot make reservation for less than 1 day");
			}
			
			if (validCar && validCustomer && validDuration) {
				System.out.println("Making new reservation");
				controller.makeReservation(nipCustomer, carId, days, cost);				
			}
		}
	}
	



}
