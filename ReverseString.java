// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;

// Define ReverseString class
public class ReverseString
{
   // Main method
   public static void main(String[] args)
   {
      // Create a scanner object to read user input
      Scanner in = new Scanner(System.in);
      // Create a new stack of string
      Stack<String> stack = new Stack<>();
      // Declare a variable str to hold user input
      String str = ""
      ;
      // Declare and initialize the variable option to 0
      int option = 0;
      
      // Use while loop to check if user input correct option and execute corresponding option
      while (option != 3)
      {
         // Call printMenu method to display the option menu 
         printMenu();
         // Read the user input and store it in variable option
         option = in.nextInt();
         
         // Use if-else statement to check the input and execute the corresponding actions     
         // Option 1: Read user input string
         if (option == 1) 
         {
            // Move to the new line                  
            in.nextLine();
            // Prompt the user to input the string            
            System.out.print("Please enter a string of words: ");   
            // Read user input and store it in str variable      
            str = in.nextLine();
            
            // Create an array type string to hold words from user input,
            // use split() to skip space between words          
            String[] words = str.split(" ");   
            // Use enhance for loop to read elements from the array  
            for (String word : words)
            {
               // Call push() method to push the elements to the stack
               stack.push(word);
            }
         }
         
         // Option 2: Display the string and reversed string
         else if (option == 2)
         {
            // Use if statement to check if the inout string is empty
            if (str.length() == 0)
            {
               // Display message for empty string
               System.out.println("Empty. Please enter a string.");
            }
            else
            {
               // Display input string      
               System.out.println("Entered string:     " + str);
                           
               // Display reversed string message
               System.out.print("Reversed string:    ");
               // Call printStack method to display the stack content
               stack.printStack();   
            }
         }        
         
         // Option 3: Exit the program
         else if (option == 3) 
         {
            // DIsplay the exit message
            System.out.println("Exiting program.");
         }
         
         // If the user input is not from 1 to 3
         else 
         {
            // Display an invalid option message
            System.out.println("Invalid option. Please select a valid option.");
         }
         // Display a blank line for spacing
         System.out.println();
      }
   }
   
   // Method printMenu to display the main menu
   public static void printMenu()
   {
      System.out.println("---------------MAIN MENU--------------");
      System.out.println("1 - Read input string of words");
      System.out.println("2 - Reverse and display input string");
      System.out.println("3 - Exit program");
      System.out.println(); // Display a blank line for spacing
      System.out.print("Enter option number: ");
   }
}
      


