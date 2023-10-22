
public class Vehicle {
// declare protected fields due to inheritance relationship
	protected int vehicleNum;
	protected Renter user; //composition relationship
	
	//provide default constructor
	public Vehicle() {
		vehicleNum = 0;
		user = new Renter();
	}
	
	//constructor with parameters to pass in as arguments for Renter object
	public Vehicle(int age, String first, String last) {
		vehicleNum = 0;
		user = new Renter(age, first, last);
	}
	
	//constructor with object parameter
	public Vehicle(Renter r) {
		user = r;
	}
	
	//constructor with all parameters
	public Vehicle(int age, String first, String last, int vNum) {
		vehicleNum = vNum;
		user = new Renter(age, first, last);
	}
	
	//write mutator methods for each field
	public void setVehicleNum(int carNum) {
		vehicleNum = carNum;
	}
	
	public void setRenter(Renter u) {
		user = u;
	}
	
	//write accessor methods for each field
	public int getVehicleNum() {
		return vehicleNum;
	}
	
	public String getRenter() {
		String output;
		
		output = "Name: " + user.getFirstName() + " " + user.getLastName() + "\n";
		output += "Age: " + user.getAge();
		
		return output;
	}
}
