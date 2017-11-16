package wwsis.wypozyczalnia.model;

import java.time.LocalDate;

public class Renting {
	private static int globalID = 0;
	private int rentID;
	private int carID;
	private Customer customerID;
	private LocalDate start;
	private LocalDate end;
	private boolean isEnded;
	private int cost;
	
	Renting () {
		rentID = globalID;
		globalID ++;
	}
	public int getRentID() {
		return rentID;
	}
	public void setRentID(int rentID) {
		this.rentID = rentID;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public Customer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
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
		return isEnded;
	}
	public void setEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
