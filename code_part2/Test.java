
public class Test {
	
public static void main(String[] args) {

	Employee o1=new Employee("Falcao",40,15.50);
	Address a1=new Address("Queen",48,"K1P1N2");
	Address a2=new Address("King Edward",800,"K1P6N5");
	o1.addAddress(a1);
	o1.addAddress(a2);

	
	o1.printEmployee();

	}
}
