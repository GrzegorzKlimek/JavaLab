package wwsis.wypozyczalnia.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import wwsis.wypozyczalnia.dataAccess.DataBase;
import wwsis.wypozyczalnia.model.Car;
import wwsis.wypozyczalnia.model.Customer;
import wwsis.wypozyczalnia.model.Renting;

public class AppController {
	private DataBase db;
	
	public AppController() {
		db = new DataBase();
	}
	
	public void makeReservation (Customer customer, Car car, LocalDate start, LocalDate end, int cost) {
		Renting reservation = new Renting();
		reservation.setCarID(car.getCariD());
		reservation.setCustomerNIP(customer.getNIP());
		reservation.setStart(start);
		reservation.setEnd(end);
		reservation.setCost(cost);
		reservation.setisEnded(false);
		db.saveRent(reservation);
		
	}
	
	public void addNewCar (String model, int yearOfProduction, int course) {
		
		Car newCar = new Car();
		newCar.setModel(model);
		newCar.setYearOfProcution(yearOfProduction);
		newCar.setCourse(course);
		db.saveCar(newCar);
		
	}
	
	public void addNewCustomer (long NIP, String name, String lastName, long telephone) {
		
		Customer newCustomer = new Customer();
		newCustomer.setNIP(NIP);
		newCustomer.setName(name);
		newCustomer.setLastName(lastName);
		newCustomer.setTelephone(telephone);
		db.saveCustomer(newCustomer);
		
	}
	
	public List <Renting> rentingsOfCustomer (Customer customer) {
		
		List<Renting> result = new ArrayList<Renting>();
		Map<Integer, Renting> rentingsmap = db.getRentings();
		for (Entry<Integer, Renting> entry : rentingsmap.entrySet()) {
			if (entry.getValue().getCustomerNIP() == customer.getNIP()) {
				result.add(entry.getValue());
			}
		}
		return result;
	}
	
	public Collection <Car> getCarsInSystem() {
		Collection<Car> cars =  db.getCars().values();
		return cars;
	}
	
	public Collection<Customer> getCustomersinSystem () {
		Collection<Customer> customers = db.getCustomers().values();
		return customers;
	}
	
	public boolean doCustomerExist (long NIP) {
		return db.getCustomers().containsKey(NIP);
	}
	

	
	

}
