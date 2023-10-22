
/* Jared Semke
 * Sunny Jackson
 * CSC-241 Final Project
 */


	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

	public class FinalProject {
		
		//function used to make sure there is somebody over 25 for renting
		public static void rentalAgecheck(int renterAge ) {
			//declare variables
			Scanner scnr = new Scanner(System.in);
			Renter renter = new Renter(); //Object used to store information of the renter
			
			//make sure someone over 25 is assisting renter
			while (renterAge < 24) {
				//ask for the age of someone who is old enough to rent
				System.out.println("Not old enough to rent.");
				System.out.println("You will not be able to rent a vehicle without a parent.");
				System.out.println("Will a parent be assisting you with this rental?");
				System.out.println("If so, please enter their age.");
				
				//store renter age in variable
				renterAge = scnr.nextInt();
				}
			
			//set the age of the renter
			renter.setAge(renterAge);
			
			//display age of renter
			System.out.println("The adult is " + renter.getAge() + " years old.");
		}
		
		//selection sort algorithm
		public static void selectionSort(ArrayList<Double> numbers) {
		      //declare variables
			  int i;
		      int j;
		      int indexSmallest;
		      double temp;      // Temporary variable for swap
		      
		      //outer loop to set the smallest index of the unsorted part 
		      for (i = 0; i < numbers.size() - 1; ++i) {

		         // Find index of smallest remaining element
		         indexSmallest = i;
		         
		         //inner loop used to check the values and sort if needed
		         for (j = i + 1; j < numbers.size(); ++j) {
		        	 
		        	 //if current number is less than the number at the smallest index, make that number the new smallest index
		            if (numbers.get(j) < numbers.get(indexSmallest)) {
		               indexSmallest = j;
		            }
		         }

		         // Swap numbers[i] and numbers[indexSmallest]
		         temp = numbers.get(i);
		         numbers.set(i, numbers.get(indexSmallest));
		         numbers.set(indexSmallest, temp);
		      }
		   }
		
		//binary search algorithm
		public static int binarySearch(ArrayList<Double> numbers, double key) {
		      //declare variables
			  int mid;
		      int low;
		      int high;
		      
		      //set low and high indices before while loop
		      low = 0;
		      high = numbers.size() - 1;
		      
		      //continue looping until high index >= low index
		      while (high >= low) {
		    	  //find mid index
		         mid = (high + low) / 2;
		         //if number at the mid is less than the user value, search the upper half of the list
		         if (numbers.get(mid) < key) {
		            low = mid + 1;
		         } 
		         //if number at mid is greater than user value, search lower half of the list
		         else if (numbers.get(mid) > key) {
		            high = mid - 1;
		         }
		         //return the index if neither of the previous conditions are met
		         else {
		            return mid;
		         }
		      }

		      return -1; // not found
		   }
		

		public static void main(String[] args) throws Exception {
			//Declare Variables
			Scanner scnr = new Scanner(System.in);
			//file input objects
			FileInputStream fileStreamIn = new FileInputStream("nums.txt");
			Scanner inFS = new Scanner(fileStreamIn);
			//file output objects
			FileOutputStream fileStreamOut = new FileOutputStream("Records.txt");
			PrintWriter outFS = new PrintWriter(fileStreamOut);
			//int vehicleId = 0;
			int rentAge;
			String firstName;
			String lastName;
			//Renter info object
			Renter renter = new Renter();
			//vehicle info object
			Vehicle rentalCar = new Vehicle();
			boolean invalidAge = true;
			boolean invalidNumber = true;
			boolean invalidInput = true;
			String answer;
			//arraylist used to store rental values
			ArrayList<Double> rentals = new ArrayList<Double>();
			IntNode headObj; // Create IntNode reference variables
		    IntNode currObj;
		    IntNode lastObj;
			//double currentRental;
			//boolean anotherCar = true;
			
			//ask and get user first name
			System.out.println("Hello, may I please have your first name?"); 
			firstName = scnr.next();
			
			// Store Users Name.
			renter.setFirstName(firstName);
			
			//ask and get last name
			System.out.println("May I please have your last name?");
			lastName = scnr.next();
			
			//Store last name in object
			renter.setLastName(lastName);
			  						
			// Used to print the first name only. ask and get age	
			System.out.println("Hello " + renter.getFirstName());
			System.out.println("May I please have your age?");
			
			//repeat try-catch block until a valid age has been entered
			while (invalidAge) {
			try {
			//get rent age
			rentAge = scnr.nextInt();
			
			//throw exception if user enters a negative number
			if (rentAge <= 0) {
				throw new RuntimeException("Must be a positive integer.");
			}
			
			// set user age
			renter.setAge(rentAge); //this line could produce an error. if so, catch block executes
			
			//function call to check to see if user is old enough to rent
			rentalAgecheck(renter.getAge());
			
			//if try block executes with no errors, set flag to false so loop terminates
			invalidAge = false;
			}
			
			//if user entered a non-integer value, execute catch block
			catch (InputMismatchException excpt) {
				//print error message
				System.out.println("Input must be a integer. Please try again.");
				//move cursor to the next line for reading
				scnr.nextLine();
			}
			//if user entered a negative integer
			catch (RuntimeException excpt) {
				//print error message
				System.out.println(excpt.getMessage());
				//move cursor to next line for reading
				scnr.nextLine();
			}
		}
			
			//set renter info
			rentalCar.setRenter(renter);
			
			//display the information of the renter
			System.out.println(rentalCar.getRenter());
			
			//create the GUI object and call the constructor
			//will display in a separate window
			RentalCalcFrame myFrame = new RentalCalcFrame();
			//set the window to best fit the GUI components
			myFrame.pack();
			//make the window visible to the user
			myFrame.setVisible(true);
			
			//boolean flag for input validation
			boolean done = false;
			//user input string used to end the while loop
			String userInput;
			
			//get the arraylist from the rental GUI
			rentals = myFrame.getRentalValues();
			
			//stop the rest of the code from executing until you type that you are done with the GUI
			while (!done) {
				//show message that tells user what to do once done with GUI
				System.out.println("Type done when you have closed the GUI.");
				//get user input
				userInput = scnr.next();
				//check if user entered the word to end the loop
				if (userInput.equals("done")) {
					//change boolean flag to end loop
					done = true;
				}
				else {
					//reiterate message to user
					System.out.println("Please enter 'done'.");
					//keep boolean value the same so that loop continues to execute
					done = false;
				}
			}
			
			//sort values in array list of rentals
			selectionSort(rentals);
			
			//used to store sum of all car rentals
			double sum = 0;
			
			//print list of sorted rentals
			for (int i = 0; i < rentals.size(); i++) {
				//show the cost of each rental
				System.out.println("Rental Cost: " + rentals.get(i));
				//add each rental to the sum variable
				sum += rentals.get(i);
			}
			
			//output the total rental price to a file
			outFS.println("Total Price of all car rentals: " + sum);
			//close the file
			outFS.close();
			
			//used to get the key value user wants to search for
			double keyValue = 0;
			//represents the index location of the key value
			int index;
			
			//ask user what information they want to search for
			System.out.println("What value do you want to search for?");
			
			//flag used to indicate whether loop should continue asking for a value
			boolean invalidSearchItem = true;
			
			//loop until user enters a valid integer
			while (invalidSearchItem) {
				try {
					//get user input
					keyValue = scnr.nextDouble();
					//if input is valid, change flag to false to end loop
					invalidSearchItem = false;
				}
				//catch any input entered that isn't an integer
				catch (InputMismatchException excpt) {
					//print error message
					System.out.println("Please enter a valid number.");
				}
				//move cursor to the next line for reading
				scnr.nextLine();
			}
			
			
			//call binary search
			index = binarySearch(rentals, keyValue);
			
			//if index = -1, key value wasn't found
			if (index == -1) {
		         System.out.println(keyValue + " was not found.");
		      } 
		      else {
		    	  //print the index where the key value was found
		         System.out.println("Found " + keyValue + " at index " + index + ".");
		      }
			
			
			//create head node and assign as last node for now
			headObj = new IntNode(-1); // Front of nodes list
		    lastObj = headObj;
		      
		      //create loop to add numbers to IntNode objects
		      while (inFS.hasNext()) { // Append 300 numbers from an input file
		         int currNum = inFS.nextInt(); // numbers from file
		         currObj = new IntNode(currNum); //make the current object with the data of currNum
		         
		         lastObj.insertAfter(currObj); // Append curr
		         lastObj = currObj; //make the current object the new last object
		      }
		      
		      //assign the head object with the current object
		      currObj = headObj;
		      
		      // Print the list until current object doesn't point to another node
		      while (currObj != null) {
		    	  //print data
		         currObj.printNodeData();
		         //assign current object to the next object for the next iteration
		         currObj = currObj.getNext();
		      }
		      
		      //terminate program
		      System.exit(0);
		}	
}