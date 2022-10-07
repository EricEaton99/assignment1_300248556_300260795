
public class Address {
	
	String street;
	int number;
	String postal;
	
	Address(String s, int n, String p) {
		this.street=s;
		this.number=n;
		this.postal=p;
	}
	
	//Getters and setters
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String toString() {
		return "Street: "+street+ ", Number: "+number+", Postal: "+postal;
	}
}
