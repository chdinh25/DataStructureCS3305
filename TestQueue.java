// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;
import java.util.*;

// Define TestQueue class
public class TestQueue
{
   // Main method
   public static void main(String[] args)
   {
      Queue<Integer> queue = new Queue<>();
      // Create a scanner object for user input
      Scanner in = new Scanner(System.in);
      // Declare and initialize the variable option to 0
      int option = 0;
      
      // Use while loop to check if user input correct option and execute corresponding option
      while ( option != 7)
      {
         // Call printMenu method to display the option menu 
         printMenu();
         // Read the user input and store it in variable option
         option = in.nextInt();
         
         // Option 1: Enqueue an element to the queue
         if (option == 1)
         {
            System.out.print("Please enter the element to enqueue: ");
            int element = in.nextInt();
            
            // Display the testing message for enqueue() method
            System.out.println("Testing method enqueue()");
            System.out.printf("Enqueue value %d to the queue.\n", element);
            
            // Display the message for outputing the queue before enqueue element
            System.out.print("Queue content before enqueue the element: ");
            // Call printStack() method to output the queue content 
            queue.printQueue();
            
            // Call push() method to add user input to the queue
            queue.enqueue(element);
            
            // Display the message for outputing the queue after enqueue element
            System.out.print("Queue content after enqueue the element:  ");
            // Call printStack() method to output the queue content 
            queue.printQueue();
         } 
         
         // option 2: Dequeue an element from the queue
         else if (option == 2) 
         {
            // Check if the queue is not empty
            if (!queue.isEmpty())
            {
               // Display the testing message
               System.out.println("Testing method dequeue()");
               System.out.println("Dequeue the element from the queue.");
               
               // Display the message for outputing the queue before removing the front element
               System.out.print("Queue content before dequeue the element: ");
               // Call printStack() method to output the queue content 
               queue.printQueue();
               
               // Call pop() method to pop an element from the queue and store it in variable popElement
               queue.dequeue();
               
               // Display the message for outputing the queue after removing the top element
               System.out.print("Queue content after dequeue the element:  ");
               // Call printStack() method to output the queue content 
               queue.printQueue();
            }
            // If the queue is empty
            else
            {
               // Call emptyMessage method to display message for empty queue
               emptyMessage();
            }
         }
         
         // Option 3: Display the front element without removing it
         else if (option == 3)
         {
            // Check if the queue is not empty
            if (!queue.isEmpty())
            {
               // Call top() method to get the top element and store it in variable frontElement               
               int frontElement = queue.front();
               // Display the front element
               System.out.println("Front element of the queue is: " + frontElement);
            }
            // If the queue is empty 
            else
            {
               // Call emptyMessage method to display message for empty queue
               emptyMessage();
            }
         }
         
         // Option 4: Display the size of the queue
         else if (option == 4)
         {
            
            // Check if the queue is not empty
            if (!queue.isEmpty())
            {
               // Call size() method to get the queue size and display the message
               System.out.println("The size of queue is: " + queue.size());
            }
            else
            {
               // Call emptyMessage method to display message for empty queue
               emptyMessage();
            }
         } 
         
         // Option 5: Check if the queue is empty
         else if (option == 5) 
         {
            // If the queue is not empty
            if (!queue.isEmpty())
            {
               // Display the not empty message
               System.out.println("The queue is not empty.");
            }
            else
            {
               // Call emptyMessage method to display message for empty queue
               emptyMessage();
            }            
         }

         // Option 6: Display the queue content
         else if (option == 6) 
         {            
            // If the queue is not empty
            if (!queue.isEmpty())
            {
               // Display the message
               System.out.print("The queue content: ");
               // Call printStack method to print out the queue content
               queue.printQueue();
            }
            else
            {
               // Call emptyMessage method to display message for empty queue
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
   
   // Method to display the main menu option
   public static void printMenu()
   {
      System.out.println("--------MAIN MENU--------");
      System.out.println("1 - Enqueue element");
      System.out.println("2 - Dequeue element");
      System.out.println("3 - Front element");
      System.out.println("4 - Size of queue");
      System.out.println("5 - Is Empty queue?");
      System.out.println("6 - Print queue content");
      System.out.println("7 - Exit program");
      System.out.println(); // Display a blank line for spacing
      System.out.print("Enter option number: ");   
   }
   
   // Method to display empty message
   public static void emptyMessage()
   {
      // Display message for empty queue
      System.out.println("The queue is empty.");
   }
}