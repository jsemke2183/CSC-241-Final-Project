
public class Renter {
	//declare protected fields so they can be accessed in vehicle class
	protected int age;
	protected String lastName;
	protected String firstName;
	
	//default constructor
	public Renter() {
		age = 0;
		lastName = "";
		firstName = "";
	}
	//constructor with all parameters
	public Renter(int a, String f, String l) {
		age = a;
		lastName = l;
		firstName = f;
	}
	//constructor with age parameter
	public Renter(int a) {
		age = a;
	}
	
	//mutators
	public void setLastName(String lName) {
		lastName = lName;
	}
	public void setFirstName(String fName) {
		firstName = fName;
	}
	public void setAge(int ageNum) {
		age = ageNum;
	}
	
	//accessors
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getAge() {
		return age;
	}
}
