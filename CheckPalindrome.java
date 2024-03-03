// Import the neccesary Java utility packages
import java.util.Scanner;
import java.util.Stack;

// Define CheckPalindrome class
public class CheckPalindrome
{
   // Main method
   public static void main (String[] args)
   {
      // Create a scanner object to read user input
      Scanner in = new Scanner(System.in);
      // Create a new stack of characters
      Stack<Character> stack = new Stack<>();
      // Declare a variable str to hold user input
      String str = "";   
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
            in.nextLine();
            // Prompt the user to input the string            
            System.out.print("Please enter a string to check for palindrome: ");   
            // Read user input and store it in str variable      
            str = in.next();
         }
         
         // Option 2: Check if the string is palindrome and display result
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
               System.out.println("Entered string:    " + str);
               // DIsplay result message 
               System.out.print("Judgment:          ");
               // Call checkPal method to check if the string is palindrome
               checkPalindrome(str, stack);
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
      System.out.println("1 - Read input string");
      System.out.println("2 - Check if palindrome");
      System.out.println("3 - Exit program");
      System.out.println(); // Display a blank line for spacing
      System.out.print("Enter option number: ");
   }
   
   // Method to check if the input string is palindrome
   // This method use input string and stack as parameters
   public static void checkPalindrome(String str, Stack stack)
   {
      // Convert the input string to lowercase 
      str = str.toLowerCase();
      // Use for loop to traverse through the string
      for (int i = 0; i < str.length(); i++)
      {
         // Call push() method to push character to the stack
         stack.push(str.charAt(i));
      }
      
      // Declare variable pushedString to hold the string after opping from the stack
      String pushedString = "";
      // Use for loop to traverse through the stack
      while (!stack.isEmpty())
      {  
         // Call pop() method to pop the character from the stack and store it in variable pushedString
         pushedString = pushedString + stack.pop();
      }
      // Use if-else statement to check if 2 strings are equal
      if (str.equals(pushedString))
      {
         // Display the palindrome message
         System.out.print("Palindrome\n");
      }
      else
      {
         // Display the not palindrome message
         System.out.print("Not Palindrome\n");  
      }
   }        
}
   
   