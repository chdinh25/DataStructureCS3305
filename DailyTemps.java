// Import the neccesary Java utility package
import java.util.*;
// Define a DailyTemps class
public class DailyTemps
{
   // Private intance variable to store daily temperature
   private int[] temperatures;
   // Array days names
   String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; 
   
   // Contructor to receives the iput from the test program,
   // these values passed as parameter
   public DailyTemps(int[] temps)
   {
      temperatures = temps;
   }
   
   // Method to set the temperature for each days
   // It read user's input and pass these parameters to the method
   public void setTemp(int index, int value)
   {
      // Initialize the value to temperature with corresponding index
      temperatures[index] = value;
   }
   
   // Method to count number of days with temperarure below 32
   public int Freezing()
   {
      // Declare a variable to keep track on the number of freezing days
      int count = 0;
      // Use a for loop to go through the array
      for (int i = 0; i < days.length; i++)
      {
         // Use if statement to check if the temperature is below 32
         if (temperatures[i] < 32)
         {
            count++; // Increment the count if the condition is met
         }
      }
      // Returs the total count of freezing days
      return count;
   }
   
   // Method to find the day with highest temperature of the wwek
   public String Warmest()
   {
      // Declare and initialize an index variable to keep track on the warmest day
      int index = 0;
      // Use for loop to go through the array
      for (int i = 0; i < days.length; i++)
      {
         // Use if statement to check if the if the current temperature is higher then index temperature
         if (temperatures[i] > temperatures[index])
         {
            index = i; // Update the index if the condition is met
         }
      }
      // Return the warmest day's name
      return days[index];
   }
   
   // Method to display the the temperatures for the week
   public void printTemps()
   {
      // Use for loop to go through the array
      for (int i = 0; i < days.length; i++)
      {
         // Print the name of the day and its corresponding temperature
         System.out.printf("%-12s%d%n", days[i], temperatures[i]);
      }
   }
}
      