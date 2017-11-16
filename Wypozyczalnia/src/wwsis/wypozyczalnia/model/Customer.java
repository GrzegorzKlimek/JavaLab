package wwsis.wypozyczalnia.model;

public class Customer {
	
	private long  NIP; // NIP is ID of customer
	private String name;
	private String lastName;
	long telephone;
	
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
	public long getNIP() {
		return NIP;
	}
	public void setNIP(long nIP) {
		NIP = nIP;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	
}
