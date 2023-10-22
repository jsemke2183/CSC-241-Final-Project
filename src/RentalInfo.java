//derived class of vehicle class
public class RentalInfo extends Vehicle {
//declare private fields
	private int rentalTime;
	private double rentTotal;
	private double[] vehicleRates = new double[3];
	
	//define values of fields in default constructor
	public RentalInfo() {
		rentalTime = 0;
		rentTotal = 0;
		vehicleRates[0] = 100.00;
		vehicleRates[1] = 88.78;
		vehicleRates[2] = 154.00;
	}
	
	//create mutator methods
	public void setRentalTime(int days) {
		rentalTime = days;
	}
	public void setRentTotal(double rentTotal2) {
		rentTotal = rentTotal2;
	}
	
	//create accessor methods
	public int getRentalTime() {
		return rentalTime;
	}
	public double getRentalTotal() {
		return rentTotal;
	}
	public double getSedenPrice() {
		return vehicleRates[0];
	}
	public double getSUVPrice() {
		return vehicleRates[1];
	}
	public double getLuxuryPrice() {
		return vehicleRates[2];
	}
}
