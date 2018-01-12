package wwsis.wypozyczalnia.view.command_line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import wwsis.wypozyczalnia.controller.AppController;
import wwsis.wypozyczalnia.model.Car;
import wwsis.wypozyczalnia.view.View;

public class CommandLineConsoleView implements View {
	
	private static String WRONG_COMMANT_MESSAGE = "Not understandeble command";
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
		validateSize(commands);
		String firstCommand = commands[0];
		
		switch(firstCommand) {
		case "add":
			System.out.print("Adding new ");
			adding(tail(commands));
			break;
		case "list":
			listing(tail(commands));
			break;
		default:
			System.out.println(WRONG_COMMANT_MESSAGE);
		}
	}
	
	private void validateSize(String [] commands) {
		if (commands.length < 1) {
			System.out.println(WRONG_COMMANT_MESSAGE);
			return;
		}
	}
	
	private String [] tail (String [] commands) {
		return Arrays.copyOfRange(commands, 1,commands.length);
	}
	
	private void listing (String [] commands) {
		validateSize(commands);
		String firstCommand = commands[0];
		switch(firstCommand) {
		case "car":
			listCars();
			break;
		case "customer":
			break;
		default:
			System.out.println(WRONG_COMMANT_MESSAGE);
		}
		
	}
	
	private void listCars() {
		Collection<Car> cars = controller.getCarsInSystem();
		System.out.println(cars);
	}
	
	private void adding (String [] commands) {
		validateSize(commands);
		String firstCommand = commands[0];
		switch(firstCommand) {
		case "car":
			System.out.print("car ");
			addNewCar(tail(commands));
			break;
		case "customer":
			System.out.print("customer ");
			break;
		default:
			System.out.println(WRONG_COMMANT_MESSAGE);
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
			System.out.print("model: " + model + " producted in " + yearOfProduction + " with course " + course);
		}
		
	}

	


}
