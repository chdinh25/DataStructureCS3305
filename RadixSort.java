// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;
import java.util.*;

// Define RadixSort class
public class RadixSort
{
   // Main method
   public static void main(String[] args)
   {
      // Create a scanner object for user input
      Scanner in = new Scanner(System.in);
      // Initialize an array for user inputs
      int[] inputs = null;
      // Initialize an array for the original input
      int[] originalArray = null;
      // Initialize the size of the array
      int arraySize = 0;
      // Declare variable option3 and initialize a flag for option 3
      boolean option3 = false;
      // Declare and initialize the variable option to 0
      int option = 0;
      
      // Create an array of queues for digits 0-9
      Queue<Integer>[] queues = new Queue[10];
      // Use for loop to iterate from i = 0 to i = 9
      for (int i = 0; i < 10; i++) 
      {
         // Create a new queue for each digit         
         queues[i] = new Queue();
      }
      
      // Use while loop to check if user input correct option and execute corresponding option
      while ( option != 5)
      {
         // Call printMenu() method to display the option menu 
         printMenu();
         // Read the user input and store it in variable option
         option = in.nextInt();
         
         // Option 1: Read the array size from user
         if (option == 1)
         {
            // Prompt user to enter array size
            System.out.print("Enter array size: ");
            // Read user input and store it in variable arraySize
            arraySize = in.nextInt();
            // Initialize the input array with size from user input
            inputs = new int[arraySize];
            // Initialize the original array with size from user input
            originalArray = new int[arraySize];
         }
         
         // Option 2: Read the array values from user
         else if (option == 2)
         {
            // Use if-else statement to check if the queue is empty
            // If the array is empty
            if (arraySize == 0)
            {
               // Display message to require for option 1 first
               System.out.println("Please enter the array size first.");
            }
            // If the array is not empty
            else 
            {
               // Prompt user to enter array values
               System.out.println("Please enter the array values:");
               // Use for loop to read user inputs and store it in array
               for (int i = 0; i < arraySize; i++) 
               {
                  // Declare a boolen to check if the input is valid (positive integer)
                  boolean validInput = false;
                  // USe while loop to check if the input is valid (positive integer)
                  while (!validInput) 
                  {
                     // Declare varibale inputValue and initialize it to user input                     
                     int inputValue = in.nextInt();
                     // Use if Statement to check if inputValue is positive
                     // If the inputValue is positive
                     if (inputValue > 0) 
                     {
                        // Store the user input to array
                        inputs[i] = inputValue;
                        // Mark input as valid and exit the validation loop
                        validInput = true;
                     } 
                     // If the inputValue is negative
                     else
                     {
                        // Display an error message if a non-positive integer is entered
                        System.out.println("Please enter a positive integer.");
                     }
                  }
               }               
            }
         }
         
         // Option 3: Run Radix Sort algorithm without printing the content
         else if (option == 3)
         {
            // Use if-else statement to check if the queue is empty
            // If the array is empty
            if (arraySize == 0)
            {
               // Display message to require for option 1 and 2 first
               System.out.println("Please enter the array size and values first.");
            }
            else 
            {  
               // Copy the inputs array to the OriginalArray for displaying in option 4
               originalArray = Arrays.copyOf(inputs, inputs.length);
               // Declare a variable max and initialize it to 0
               int max = 0;
               // Use enhance for loop to traverse through the inputs array
               for (int num : inputs) 
               {
                  // Call digitCount method to calculate the number of digits in a number
                  int numDigits = RadixSort.digitCount(num);
                  // If the digit is greater than the max
                  if (numDigits > max) 
                  {
                     // Update the maximum if a larger number of digits is found
                     max = numDigits;
                  }
               }
               
               // Use for loop to perform the radix sort algorithm for each digit position 
               for (int digitPosition = 1; digitPosition <= max; digitPosition++)
               {
                  // Call distribute() method to distribute elements into queues based on the current digit position
                  distribute(inputs, digitPosition, queues);
                  // Call colect() method to collect elements from queues back into the array
                  collect(inputs, queues);
               }
            }
            // Set a flag to indicate that option 3 has been executed
            option3 = true;
         }
         
         // Option 4: Display the queue content before and after the sorting
         else if (option == 4) 
         {
            // Use if-else statement to check if the queue is empty
            // If the array is empty
            if (arraySize == 0)
            {
               // Display message to require for option 1 and 2 first
               System.out.println("Please enter the array size and values first.");
            }
            else 
            {
               // Use if else statement to check if option 3 is executed
               // If option 3 is not executed
               if (!option3)
               {
                  // Display message require user to choose option 3 first
                  System.out.print("Please choose option 3 for sorting first");
               }
               // If option 3 is executed
               else
               {
                  // Display message for queue content before sorting
                  System.out.print("Array Inputs before sorting:    ");
                  // Use for loop to traverse through the originalArray
                  for (int i = 0; i < arraySize; i++) 
                  {
                     // Print out the array content
                     System.out.print(originalArray[i]);
                     // If it not the last element
                     if (i < arraySize - 1) 
                     {
                        // Add a comma and space
                        System.out.print(", ");
                     }
                  }
                  // Print a new line for spacing
                  System.out.println();
                  
                  // Display message for queue content after sorting
                  System.out.print("Array Inputs after sorting:     ");
                  // Use for loop to traverse through the originalArray
                  for (int i = 0; i < arraySize; i++) 
                  {
                     // Print out the array content
                     System.out.print(inputs[i]);
                     // If it not the last element
                     if (i < arraySize - 1) 
                     {
                        // Add a comma and space
                        System.out.print(", ");
                     }
                  }
               }
               // Print a new line for spacing
               System.out.println();
            }
         }
         
         // Option 5: Exit the program
         else if (option == 5) 
         {
            // Display the exit message
            System.out.println("Exiting program.");
         } 
         
         // If the user input is not from 1 to 5
         else 
         {
            // Display an invalid option message
            System.out.println("Invalid option. Please select a valid option.");
         }
         // Display a blank line for spacing
         System.out.println();
      }
   }
   
   // Method to distribute elements into queues based on the current digit position
   // This method use inputs array, digitPosition and queues as parameteres
   public static void distribute(int[] arr, int digitPosition, Queue[] queue) 
   {
      // Use enhance for loop to travers the array
      for (int num : arr) 
      {
         // Call extracDigit() method to extract a digit at a specific position
         int digit = RadixSort.extractDigit(num, digitPosition);
         // Call enqueue() method to add elements into corresponding queue
         queue[digit].enqueue(num);
      }
   }
   
   // Method to collect elements from queues back into the array
   // This method use inputs array, and queues as parameteres
   public static void collect(int[] arr, Queue[] queues) 
   {
      // Declare a variable index and initialize it to 0
      int index = 0;
      // Use enhance for loop to traverse the queues
      for (Queue queue : queues) 
      {
         // Use while loop to traverse the queues
         while (!queue.isEmpty()) 
         {
            // Call dequeue() method to dequeue elements and store it in the array
            arr[index++] = (int) queue.dequeue();
         }
      }
   }
   
   // Method to display the main menu option
   public static void printMenu()
   {
      System.out.println("--------MAIN MENU--------");
      System.out.println("1 - Read array size");
      System.out.println("2 - Read array values");
      System.out.println("3 - Run Radix Sort algorithm (no printing)");
      System.out.println("4 - Print outputs");
      System.out.println("5 - Exit program");
      System.out.println(); // Display a blank line for spacing
      System.out.print("Enter option number: ");
   }
   
   // Method to extract the digit at a specific position from a number 
   public static int extractDigit(int number, int position) 
   {
      // Extract and return the digit
      return (number / (int) Math.pow(10, position - 1)) % 10;
   }
   
   // Method to count the number of digits in a number
   public static int digitCount(int number) 
   {
      // Special case: if number is 0, it has one digit
      if (number == 0) 
      {
         return 1;
      }
      // Declare varibale count and initialize it to 0
      int count = 0;
      while (number != 0) 
      {
         // Remove the last digit of the number
         number = number/10;
         // Increment the count for each digit removed
         count++;
      }
      // Return the total count, also the number of digits in the original number
      return count;
   }
}