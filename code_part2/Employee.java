
public class Employee {

	String name;
	int hours;
	double rate;
	Address[] address= new Address[6];
	
	Employee(String n,int h,double r) {
		this.name=n;
		this.hours=h;
		this.rate=r;
		//this.address=a;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Address getAddress(int i) {

		return address[i];
	}
	public void setAddress(Address a, int i) {//make work with spots in array
		this.address[i] = a;
	}
	public void addAddress(Address a) {
		for (int i=0; i<6;i++) {
			if (address[i]==null) {
				setAddress(a,i);
				break;
			}
		}
	}
	
	public void printEmployee() {
		System.out.println("Name: "+name+" Hours: "+hours+" Rate: "+rate);
		//System.out.println(address[1]);
		for (int i=0; i<6;i++) {
			if (address[i]!=null) {
				System.out.println("Address"+i+": "+address[i]);
			}
		}
	}
}
