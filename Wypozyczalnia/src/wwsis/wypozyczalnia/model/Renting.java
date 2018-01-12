package wwsis.wypozyczalnia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Renting {
	private static int globalID = 0;
	private int rentID;
	private Car car;
	private Customer customer;
	private LocalDate start;
	private LocalDate end;
	private int cost;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Renting () {
		rentID = globalID;
		globalID ++;
	}
	public int getRentID() {
		return rentID;
	}
	public void setRentID(int rentID) {
		this.rentID = rentID;
	}

	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public boolean isEnded() {
		return LocalDate.now().isAfter(end);
	}

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override 
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String newLine = System.lineSeparator();
		stringBuilder.append("Reservation id =").append(rentID);
		stringBuilder.append(" of car ").append(car.model);
		stringBuilder.append("with id= ").append(car.getCariD());
		stringBuilder.append(" to customer ").append(customer.getName());
		stringBuilder.append(" ").append(customer.getLastName());
		stringBuilder.append(" and NIP= ").append(customer.getNIP());
		stringBuilder.append("started ").append(start);
		stringBuilder.append("due to ").append(end);
		stringBuilder.append("active =").append(!isEnded());
		stringBuilder.append(newLine);
		
		return stringBuilder.toString();
	}
}
