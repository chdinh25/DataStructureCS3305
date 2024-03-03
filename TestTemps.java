// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;
// Define a class named TestTemps
public class TestTemps
{
   // Main method
   public static void main(String[] args)
   {
      // Create a Scanner object to reat user's input
      Scanner in = new Scanner(System.in);
      
      // Array to store day names
      String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
      
      // Declare an array to store temperature for 7 days of the week
      int[] temps = new int[7];
      
      // Use a for loop to go throgh the array,and prompt the user for the temperature
      for ( int i = 0; i < days.length; i++)
      {
         // Prompt the user for temperature for the current day
         System.out.println("Enter the temperature on " + days[i]);
         // Read the user input and store it in the temps array
         temps[i] = in.nextInt();
      }
      
      // Create a dailyTemps using the temperatures data
      DailyTemps dailyTemps = new DailyTemps(temps);
      
      // Call printTemps method to display the recorded temperatures
      dailyTemps.printTemps();
      
      // Display the number of freezing days using Freezing() method
      System.out.println("Number of freezing days is " + dailyTemps.Freezing() + " days.");
      
      // Display the warmest day using the Warmest() method
      System.out.println("The warmest day of the week is " + dailyTemps.Warmest() + ".");
      System.out.println();
      
      // Test the setTemp method
      System.out.println("Testing method setTemp:");
      // Declare a variable to hold index that user input
      int dayIndex; 
      // Use the do-while loop to check if the user input the right index from 0 to 6
      do
      {
         // Prompt the user to enter the index
         System.out.print("Enter the day index from 0 to 6 to set the temperature with Monday being 0: ");
         // Read the input and store it in the variable
         dayIndex = in.nextInt();
      }
      while (dayIndex < 0 || dayIndex > 6);
      // Prompt the user to enter new value for temperature
      System.out.print("Enter the new temperature: ");
      // Read the input and store it in newTemp variable
      int newTemp = in.nextInt();
      
      // Call the setTemp method to set the new value for that specific day
      dailyTemps.setTemp(dayIndex, newTemp);
      
      //Test Freezing and Warmest methods
      System.out.println("Testing method Freezing: " + dailyTemps.Freezing());
      System.out.println("Testing method Warmest: " + dailyTemps.Warmest()); 
   }
}  