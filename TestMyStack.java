// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;

// Define TestMyStack class
public class TestMyStack
{
   // Main method
   public static void main(String[] args)
   {
      // Create a new stack of integers
      Stack<Integer> stack = new Stack<>();
      // Create a scanner object for user input
      Scanner in = new Scanner(System.in);
      // Declare and initialize the variable option to 0
      int option = 0;
      
      // Use while loop to check if user input correct option and execute corresponding option
      while (option != 7)
      {
         // Call printMenu method to display the option menu 
         printMenu();
         // Read the user input and store it in variable option
         option = in.nextInt();
         
         // Use if-else statement to check the input and execute the corresponding actions     
         // Option 1: Add an element to the stack
         if (option == 1) 
         {
            // Prompt the user to input the value to add to the stack
            System.out.print("Enter element to push: ");
            // Read user input and store it in variable element
            int element = in.nextInt();
            
            // Display the testing message for push() method
            System.out.println("Testing method push()");
            System.out.printf("Pushing value %d to the stack.\n", element);
            
            // Display the message for outputing the list before adding element
            System.out.print("Stack content before pushing the element: ");
            // Call printStack() method to output the stack content 
            stack.printStack();
            
            // Call push() method to add user input to the stack
            stack.push(element);
            
            // Display the message for outputing the list after adding element
            System.out.print("Stack content after pushing the element:  ");
            // Call printStack() method to output the stack content 
            stack.printStack();
         } 
         
         // Option 2: Remove the top element
         else if (option == 2) 
         {
            // Check if the stack is not empty
            if (stack.size() != 0)
            {
               // Display the testing message
               System.out.println("Testing method pop()");
               System.out.println("Popping the element from the stack.");
               
               // Display the message for outputing the list before removing the top element
               System.out.print("Stack content before popping the element: ");
               // Call printStack() method to output the stack content 
               stack.printStack();
               
               // Call pop() method to pop an element from the stack and store it in variable popElement
               int popElement = stack.pop();
               
               // Display the message for outputing the list after removing the top element
               System.out.print("Stack content after popping the element:  ");
               // Call printStack() method to output the stack content 
               stack.printStack();
            }
            // If the stack is empty
            else
            {
               // Call emptyMessage method to display message for empty stack
               emptyMessage();
            }
         } 
         
         // Option 3: Display the top element without removing it
         else if (option == 3)
         {
            // Check if the stack is not empty
            if (stack.size() != 0)
            {
               // Call top() method to get the top element and store it in variable topElement               
               int topElement = stack.top();
               // Display the top element
               System.out.println("Top element of the stack is: " + topElement);
            }
            // If the stack is empty 
            else
            {
               // Call emptyMessage method to display message for empty stack
               emptyMessage();
            }
         }
         
         // Option 4: Display the size of the stack
         else if (option == 4)
         {
            // Call size() method to get the stack size and display the message
            System.out.println("The size of stack is: " + stack.size());
         } 
         
         // Option 5: Check if the stack is empty
         else if (option == 5) 
         {
            // If the stack is not empty
            if (stack.size() != 0)
            {
               // Display the not empty message
               System.out.println("The stack is not empty.");
            }
            else
            {
               // Call emptyMessage method to display message for empty stack
               emptyMessage();
            }            
         } 
         
         // Option 6: Display the stack content
         else if (option == 6) 
         {
            // If the stack is not empty
            if (stack.size() != 0)
            {
               // Display the message
               System.out.print("The stack content: ");
               // Call printStack method to print out the stack content
               stack.printStack();
            }
            else
            {
               // Call emptyMessage method to display message for empty stack
               emptyMessage();
            }          
         } 
         
         // Option 7: Exit the program
         else if (option == 7) 
         {
            // DIsplay the exit message
            System.out.println("Exiting program.");
         } 
         
         // If the user input is not from 1 to 7
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
      System.out.println("--------MAIN MENU-------");
      System.out.println("1 - Push element");
      System.out.println("2 - Pop element");
      System.out.println("3 - Top element");
      System.out.println("4 - Size of stack");
      System.out.println("5 - Is Empty stack?");
      System.out.println("6 - Print stack content");
      System.out.println("7 - Exit program");
      System.out.println(); // Blank line for spacing
      System.out.print("Enter option number: ");
   }
   
   // Method to display empty message
   public static void emptyMessage()
   {
      // Display message for empty stack
      System.out.println("The stack is empty.");
   }
}