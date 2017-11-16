package wwsis.wypozyczalnia.dataAccess;

import java.util.HashMap;
import java.util.Map;

import wwsis.wypozyczalnia.model.Car;
import wwsis.wypozyczalnia.model.Customer;
import wwsis.wypozyczalnia.model.Renting;

public class DataBase {
	
	private Map<Integer, Car> cars;
	private Map <Long, Customer> customers;
	private Map <Integer, Renting> rentings;
	
	public DataBase() {
		cars = new HashMap<>();
		customers = new HashMap<>();
		rentings = new HashMap<>();
	}
	
	public void saveCustomer(Customer customer) {
		customers.put(customer.getNIP(), customer );
	}
	
	public Customer loadCustomer (int NIP) {
		return customers.get(NIP);
	}
	
	public void saveCar(Car car) {
		cars.put(car.getCariD(), car);
	}
	
	public Car loadCar (int carID) {
		return cars.get(carID);
	}
	
	public void saveRent (Renting rent) {
		rentings.put(rent.getRentID(), rent);
	}

	public Map<Integer, Car> getCars() {
		return cars;
	}

	public Map<Long, Customer> getCustomers() {
		return customers;
	}

	public Map<Integer, Renting> getRentings() {
		return rentings;
	}
	

}
