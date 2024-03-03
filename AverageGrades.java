// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;

// Define AverageGrades class
public class AverageGrades
{
   // Create a scanner object to read user input
   private static Scanner in = new Scanner(System.in);
   // Declare an array named grades
   private static int[] grades;
   // Declare a classSize variable
   private static int classSize;
   
   // Main method
   public static void main(String[] args)
   {
      // Declare and initialize the option variable to 0
      int option = 0;
      
      // Use wile loop to check if user input correct option and execute corresponding option
      while (option != 4)
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
            // Call readClassSize method to read user input for class size
            readClassSize();
         }
         else if (option == 2)
         {
            // Call readClassGrade method to read user input for class grades
            readClassGrade();
         }
         else if (option == 3)
         {
            // Call computeClassAverage to compute and display the class average 
            computeClassAverage();
         }
         else if (option == 4)
         {
            // Display an exit message
            System.out.println("Exiting program.");
         }
         else
         {
            // Display an invalid option message
            System.out.println("Error. Please enter valid option 1, 2, 3 or 4");
         }
         
         if (option != 4)
         {
            // Display a blank line for spacing 
            System.out.println();
         }
      }   
   }
   
   // Method printMenu to display the main menu
   public static void printMenu() 
   {
      System.out.println("--------MAIN MENU--------");
      System.out.println("1. Read class size");
      System.out.println("2. Read class grades");
      System.out.println("3. Compute class average");
      System.out.println("4. Exit program");
      System.out.println();
      System.out.print("Enter option number: ");
   }
   
   // Method readClassSize to read the user input for class size
   public static void readClassSize()
   {
      // Prompt the user to input the class size
      System.out.print("Please enter the class size: ");
      // Read the input and store it in classSize variable
      classSize = in.nextInt();
      // Set the array length with class size
      grades = new int[classSize];
      // Display a blank line for spacing
      System.out.println();
   }
   
   // Method readClassGrade to read grades for the class
   public static void readClassGrade()
   {
      // Check if the grades array is not empty
      if (grades != null)
      {
         // Prompt the user to input grades
         System.out.print("Please enter grades: ");
         // Use for loop to loop through the array, read each grade from user input,
         // and store it in the array
         for (int i = 0; i < grades.length; i++)
         {
            // Initialize the input to the corresponding index
            grades[i] = in.nextInt();
         }
      }
   }
   
   // Method computeClassAverage to compute and display the class average
   public static void computeClassAverage()
   {
      // Check if the grades array is not empty
      if (grades != null)
      {
         // Call findAverage method to calculate the class average 
         // and store it in average variable 
         double average = findAverage(grades, classSize);
         // Display a blank line for spacing
         System.out.println();
         // Display the entered input for class size
         System.out.printf("You entered class size:   %d\n", classSize);
         // Call printGrades method to display the entered class grades
         printGrades(grades);
         // Display the class average message with 2 decimals place
         System.out.printf("Class average:            %.2f\n", average);
      }
   }
   
   // Method printGrades to display the entered class grades 
   // that use grades array as a parameter
   public static void printGrades(int[] grades)
   {
      // Display a message
      System.out.print("You entered grades:       ");
      // Use for loop to traverse the array and print all the elements
      for (int i = 0; i < grades.length; i++)
      {
         // Display the elements
         System.out.print(grades[i] + " ");
      }
      // End of the display message and start a new line foe the next output
      System.out.print("\n"); 
   }
   
   // Method findAverage to calculate the class average
   // that use grades array and array's size as parameters
   public static double findAverage(int[] grades, int index)
   {
      // Declare sum variable and initialize it to 0
      double sum = 0;
      // Base case: the array has only one element
      if (index == 1)
      {
         // Return the only element
         return grades[0];
      }
      else
      {
         // Calculate the sum of all elements in the array using recursion
         sum = grades[index - 1] + (index - 1) * findAverage(grades, index - 1);
         // Return the avaerage by dividing sum by numbers of elements
         return sum/index;
      }
   }
}
   
   
      
      
