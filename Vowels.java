// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;

// Define Vowels class
public class Vowels
{
   // Create a scanner object to read user input
   private static Scanner in = new Scanner(System.in);
   // Declare a variable to store the user input string
   private static String input = "";
   
   // Main method
   public static void main(String[] args)
   {
      // Declare and initialize the option variable to 0
      int option = 0;
      
      // Use wile loop to check if user input correct option and execute corresponding option
      while (option != 3)
      {
         // Call printMenu method to display the option menu
         printMenu();
         // Read the user input and store it in varibale option
         option = in.nextInt();
         // Read the new line after reading the integer
         in.nextLine();
         // Use if statement to check the input and execute the corresponding actions
         if (option == 1)
         {
            // Call readInput method to read the input string
            readInput();
         }
         else if (option == 2)
         {
            // Call computeVowels method to compute and display vowel count
            computeVowels();
         }
         else if (option == 3)
         {
            // Display an exit message
            System.out.println("Exiting program.");
         }
         else
         {
            // Display an invalid option message
            System.out.println("Error. Please enter valid option 1, 2 or 3");
         }
         
         if (option != 3)
         {
            // Display a blank line for spacing 
            System.out.println();
         }
      }   
   }
   
   // Method printMenu to display the main menu
   private static void printMenu()
   {
      System.out.println("---------MAIN MENU---------");
      System.out.println("1. Read input string");
      System.out.println("2. Compute number of vowels");
      System.out.println("3. Exit program");
      System.out.println();
      System.out.print("Enter option number: ");
   }
   
   // Method readInput to read the user input
   private static void readInput()
   {
      // Prompt the user to input a string
      System.out.print("Enter input string: ");
      // Read the input and store it in variable input
      input = in.nextLine();
   }
   
   // Method to compute and display the vowel count for the input string
   private static void computeVowels()
   {
      // Use if statement to check if user enter any string
      if (input != null)
      {
         // call countVowels method to count the vowels and store it in variable count
         int count = countVowels(input);
         // Display a blank line for spacing
         System.out.println();
         // Display the entered string
         System.out.printf("You entered string:  %s\n", input);
         // Display the vowel count
         System.out.printf("Number of vowels:    %d\n", count);
      }
   }
   
   // Method to count the vowels in the input string and use the input string as an arguement
   // This method returns the number of vowels
   private static int countVowels(String str)
   {
      // Convert the iput string to lowercase to make the code simpler since does not need to care about uppercase
      str = str.toLowerCase();
      // Base case: check if the string is empty
      if (str.length() == 0)
      {
         // If the string is empty, return 0 since there is no vowels
         return 0;
      }
      // Check if the first character of the string is vowels (a, e, i, o, u)
      else if ("iouea".contains(Character.toString(str.charAt(0))))
      {
         // if the first character is a vowel, recursively count the remaining vowels of the string 
         return 1 + countVowels(str.substring(1));
      }
      else
      {
         // If the first character is not a vowel, recursively count the remaining vowels of the string 
         return countVowels(str.substring(1));
      }
   }
}
         
      
      
         
      

         
   