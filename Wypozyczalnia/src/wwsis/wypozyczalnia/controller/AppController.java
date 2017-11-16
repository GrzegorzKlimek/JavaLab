package wwsis.wypozyczalnia.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import wwsis.wypozyczalnia.dataAccess.DataBase;
import wwsis.wypozyczalnia.model.Car;
import wwsis.wypozyczalnia.model.Customer;
import wwsis.wypozyczalnia.model.Renting;

public class AppController {
	private DataBase db;
	
	public AppController() {
		db = new DataBase();
	}
	
	public void makeReservation (Customer customer, Car car, boolean isEnded, LocalDate start, LocalDate end, int cost) {
		Renting reservation = new Renting();
		reservation.setCarID(car.getCariD());
		reservation.setCustomerNIP(customer.getNIP());
		reservation.setStart(start);
		reservation.setEnd(end);
		reservation.setCost(cost);
		reservation.setisEnded(isEnded);
		
	}
	
	public void addNewCar (String model, int yearOfProduction, int course) {
		
		Car newCar = new Car();
		newCar.setModel(model);
		newCar.setYearOfProcution(yearOfProduction);
		newCar.setCourse(course);
		db.saveCar(newCar);
		
	}
	
	public void addNewCustomer (int NIP, String name, String lastName, long telephone) {
		
		Customer newCustomer = new Customer();
		newCustomer.setNIP(NIP);
		newCustomer.setName(name);
		newCustomer.setLastName(lastName);
		newCustomer.setTelephone(telephone);
		db.saveCustomer(newCustomer);
		
	}
	
	List <Renting> rentingsOfCustomer (Customer customer) {
		
		List<Renting> result = new ArrayList<Renting>();
		Map<Integer, Renting> rentingsmap = db.getRentings();
		for (Entry<Integer, Renting> entry : rentingsmap.entrySet()) {
			if (entry.getValue().getCustomerNIP() == customer.getNIP()) {
				result.add(entry.getValue());
			}
		}
		return result;
	}
	

	
	

}
