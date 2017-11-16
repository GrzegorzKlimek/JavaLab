package wwsis.wypozyczalnia.model;

public class Customer {
	static private int globalID = 0;
	private int customerID;
	private String name;
	private String lastName;
	private int  NIP;
	long telephone;
	
	Customer () {
		customerID = globalID;
		globalID ++;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getNIP() {
		return NIP;
	}
	public void setNIP(int nIP) {
		NIP = nIP;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	
}
