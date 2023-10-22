import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RentalCalcFrame extends JFrame implements ActionListener {
   private JLabel carSelectionLabel;     // Label for hourly salary
   private JLabel daysLabel;      // Label for yearly salary
   private JTextField carSelectionField;  // Displays hourly salary 
   private JTextField daysField; // Displays yearly salary
   private JButton calcButton;   // Triggers salary calculation
   private JTextField totalField; //display the total rental cost
   private RentalInfo vehicle; //object used to access rental information
   private ArrayList<Double> rentals = new ArrayList<Double>(); //store rental values

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   RentalCalcFrame() {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set frame's title
      setTitle("Car Rental");

      // Set car selection and days labels and text fields
      carSelectionLabel = new JLabel("Car Selection (Sedan, SUV, Luxury):");
      daysLabel = new JLabel("Days Rented:");

      //set properties for car text field
      carSelectionField = new JTextField(15);
      carSelectionField.setEditable(true);

      //set properties for days text field
      daysField = new JTextField(15);
      daysField.setEditable(true);
      
      //set properties for total text field
      totalField = new JTextField(45);
      totalField.setEditable(false);

      // Create a "Calculate" button
      calcButton = new JButton("Calculate");
      
      // Use "this" class to handle button presses
      calcButton.addActionListener(this);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      // Specify component's grid location
      positionConst.gridx = 0;
      positionConst.gridy = 0;
      
      // 10 pixels of padding around component
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      // Add component using the specified constraints
      add(carSelectionLabel, positionConst);

      //continue setting component properties and adding to the window
      positionConst.gridx = 1;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(carSelectionField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(daysLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(daysField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(calcButton, positionConst);
      
      positionConst.gridx = 1;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(totalField, positionConst);
   }

   /* Method is automatically called when an event 
      occurs (e.g, button is pressed) */
   @Override
   public void actionPerformed(ActionEvent event) {
      String selection; // User specified car selection
      String days; //user specified number of days
      int numDays = 0; //used to store converted number of days from string variable
      vehicle = new RentalInfo(); //create new RentalInfo object
      double rentTotal; //store total value
      boolean addEntry = false; //boolean to indicate whether to add a value to the list
      boolean validNumDays = false; //boolean to indicate whether a valid number of days was input

      // Get user's rental input
      selection = carSelectionField.getText();
      days = daysField.getText();
      
      //convert the days string to a integer; catch error if not possible to do so
      try {
    	  //convert string to int
      	 numDays = Integer.parseInt(days);
      	 //if no errors, set boolean to true
      	 validNumDays = true;
        }
      //in case user enters a value that can't be converted
        catch (Exception excpt) {
        	//show error message
      	  JOptionPane.showMessageDialog(this, "Please enter a valid number of days.");
      	  //set flag to indicate no new entry
      	  addEntry = false;
      	  //set flag to indicate that this part of the input is invalid
      	  validNumDays = false;
        }
        
      //if the user enters valid input for days, continue to check if selection is valid
      if (validNumDays) {
    	//use if statements to determine the car rental price
          if (selection.equalsIgnoreCase("Sedan")) {
    		//set add entry to true so arraylist will get a new value
        	  addEntry = true;
    			//store rent duration value in field in rental class
    			vehicle.setRentalTime(numDays);
    			
    			//calculate total rental price
    			rentTotal = (vehicle.getSedenPrice() * vehicle.getRentalTime());
    			
    			//store rent total in field value in class
    			vehicle.setRentTotal(rentTotal);
    			
    			//display rental total formatted to 2 decimal places
    			totalField.setText("Your rental for " + vehicle.getRentalTime() + 
          " days will come out to a total of $" + vehicle.getRentalTotal());
    			
    		}
          
        //repeat process for other vehicle selections
    		else if (selection.equalsIgnoreCase("SUV")) {
    			//set add entry to true so arraylist will get a new value
    			addEntry = true;
    			//set rental time
    			vehicle.setRentalTime(numDays);
    			//calculate rental total
    			rentTotal = (vehicle.getSUVPrice() * vehicle.getRentalTime());
    			//set rental total
    			vehicle.setRentTotal(rentTotal);
    			//display price rounded to 2 decimal places
    			totalField.setText("Your rental for " + vehicle.getRentalTime() + 
    			" days will come out to a total of $" + vehicle.getRentalTotal());
    			
    		}
    		//repeat process again for third choice
    		else if  (selection.equalsIgnoreCase("Luxury")){
    			//set add entry to true so arraylist will get a new value
    			addEntry = true;
    			//set rent duration
    			vehicle.setRentalTime(numDays);
    			//calculate rent total
    			rentTotal = (vehicle.getLuxuryPrice() * vehicle.getRentalTime());
    			//set rent total
    			vehicle.setRentTotal(rentTotal);
    			//display rent total rounded to 2 decimal places
    			totalField.setText("Your rental for " + vehicle.getRentalTime() + 
    			" days will come out to a total of $" + vehicle.getRentalTotal());
    			
    		}
          //if no selection above was entered, show message that says so
    		else {
    			JOptionPane.showMessageDialog(this, "Please enter one of the 3 options.");
    			//change flag to indicate that selection was invalid, so no new entry
    			addEntry = false;
    		} 
      }
      else {
    	  //if number of days was invalid, make boolean false
    	  addEntry = false;
      }
      
      
      //add the rental entry into arraylist if boolean is true
      if (addEntry) {
    	  rentals.add(vehicle.getRentalTotal());
      }
      
   }
   
   public ArrayList<Double> getRentalValues() {
	  //return arrraylist with values to the main method for further use
	   return rentals;
   }
}
