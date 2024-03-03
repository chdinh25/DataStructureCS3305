// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;

// Define myTest class
public class myTest
{
   //	Main method
   public static void main	(String[] args)
   {
   	// Create a scanner object to read user input
      Scanner in = new Scanner(System.in);
      // Create a list object
      LinkedList myList = new LinkedList();
      
      // Declare and initialize the variable option to 0
      int option = 0;
      
      // Use while loop to check if user input correct option and execute corresponding option
      while (option != 10)
      {
         // Call printMenu method to display the option menu
         printMenu();
         // Read the user input and store it in variable option
         option = in.nextInt();
         // Read the new line after reading the integer
         in.nextLine();
         
         // Use if-else statement to check the input and execute the corresponding actions     
         // Option 1: Add a node to the beginning of the list
         if (option == 1)
         {
            // Prompt the user to input the value to add to the beginning of the list
            System.out.print("Please enter the value to add to the beginning of the list: ");
            // Read user input and store it in variable input
            int input = in.nextInt();
            
            // Display the testing message
            System.out.println("Testing method addFirstNode()");
            System.out.printf("Adding value %d as first node.\n", input);
            
            // Display the message for outputing the list before adding node
            System.out.printf("List content before adding %d is: ", input);
            // Call printList method to output the list content 
            myList.printList();
            // Start a new line
            System.out.print("\n");
            
            // Call addFirstNode method to add user input to the beginning of the list
            myList.addFirstNode(input);
            
            // Display the message for outputing the list after adding node
            System.out.printf("List content after adding %d is:  ", input);
            // Call printList method to output the list content 
            myList.printList();
            // Start a new line
            System.out.print("\n");
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 2: Add a node to the end of the list
         else if (option == 2)
         {
            // Prompt the user to input the value to add to the end of the list
            System.out.print("Please enter the value to add to the end of the list: ");
            // Read user input and store it in variable input
            int input = in.nextInt();
            
            // Display the testing message
            System.out.println("Testing method addLastNode()");
            System.out.printf("Adding value %d as last node.\n", input);
            
            // Display the message for outputing the list before adding node
            System.out.printf("List content before adding %d is: ", input);
            // Call printList method to output the list content 
            myList.printList();
            // Start a new line
            System.out.print("\n");
         
            // Call addLastNode method to add user input to the end of the list
            myList.addLastNode(input);
            
            // Display the message for outputing the list after adding node
            System.out.printf("List content after adding %d is:  ", input);
            // Call printList method to output the list content 
            myList.printList();
            // Start a new line
            System.out.print("\n");
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 3: Add node at corresponding index
         else if (option == 3)
         {
            // Prompt the user to input the index that the user want to add a node
            System.out.print("Please enter the index to add at: ");
            // Read user input and store it in variable index
            int index = in.nextInt();
            
            // Use if-else statement to check if the user input is in the range of list size           
            // If the index is out of the range, display error message
            if (index < 1 || index > myList.countNodes())
            {
               // Display erroe message for invalid input
               System.out.println("Invalid index, try again");
            }
            // If the index is valid, move to the next step    
            else
            {
               // Prompt the user to input the value to add to the list
               System.out.print("Please enter the value to add to the list: ");
               // Read user input and store it in variable input
               int input = in.nextInt();
               
               // Display the testing message
               System.out.println("Testing method addAtIndex()");
               System.out.printf("Adding value %d at index %d.\n", input, index);
               
               // Display the message for outputing the list before adding node
               System.out.printf("List content before adding %d at index %d is: ", input, index);
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
               
               // Call addAtIndex method to add user input to corresponding index of the list
               myList.addAtIndex(index, input);
               
               // Display the message for outputing the list after adding node
               System.out.printf("List content after adding %d at index %d is:  ", input, index);
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
            }           
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 4: Remove the first node
         else if (option == 4)
         {
            // Use if-else statement to check whether the list is empty
            // If list is empty, display empty message
            if (myList.countNodes() == 0)
            {
               // Call emptyMessage method to display message for empty list
               emptyMessage();
            }
            else
            {
               // Display the testing message
               System.out.println("Testing method removeFirstNode()");
               System.out.println("Removing first node.");
               
               // Display the message for outputing the list before removing first node
               System.out.print("List content before removing first node is: ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
            
               // Call removeFirstNode method to remove the first node of the list
               myList.removeFirstNode();
               
               // Display the message for outputing the list before removing first node
               System.out.print("List content after removing first node is:  ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
            }
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 5: Remove the last node
         else if (option == 5)
         {
            // Use if-else statement to check whether the list is empty
            if (myList.countNodes() == 0)
            {
               // Call emptyMessage method to display message for empty list
               emptyMessage();
            }
            else
            {
               // Display the testing message
               System.out.println("Testing method removeLastNode()");
               System.out.println("Removing last node.");
               
               // Display the message for outputing the list before removing last node
               System.out.print("List content before removing last node is: ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
            
               // Call removeLastNode method to remove the last node of the list
               myList.removeLastNode();
               
               // Display the message for outputing the list before removing last node
               System.out.print("List content after removing last node is:  ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
            }
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 6: Remove node at corresponding index
         else if (option == 6) 
         {
            // Use if-else statement to check whether the list is empty
            if (myList.countNodes() == 0)
            {
               // Call emptyMessage method to display message for empty list
               emptyMessage();
            }
            else
            {
               // Prompt the user to input the index that the user want to remove
               System.out.print("Please enter the index to remove the corresponding node: ");
               // Read user input and store it in variable index
               int index = in.nextInt();              
               
               // Use if-else statement to check if the user input is in the range of list size           
               // If the index is out of the range, display error message   
               if (index < 1 || index > myList.countNodes())
               {
                  // Display erroe message for invalid input
                  System.out.println("Invalid index, try again");
               }
               // If the index is valid, move to the next step
               else
               {   
                  // Display the testing message
                  System.out.println("Testing method removeAtIndex()");
                  System.out.printf("Removing node at index %d.\n", index);
                  
                  // Display the message for outputing the list before removing node
                  System.out.printf("List content before removing node at index %d is: ", index);
                  // Call printList method to output the list content 
                  myList.printList();
                  // Start a new line
                  System.out.print("\n");
                  
                  // Call removeAtIndex method to remove the node at the corresponding index
                  myList.removeAtIndex(index);
                  
                  // Display the message for outputing the list after removing node
                  System.out.printf("List content after removing node at index %d is:  ", index);
                  // Call printList method to output the list content 
                  myList.printList();
                  // Start a new line
                  System.out.print("\n");
               }
            }
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 7: Print the list size
         else if (option == 7) 
         {
            // Use if-else statement to check whether the list is empty
            // If list is empty, display empty message
            if (myList.countNodes() == 0)
            {
               // Call emptyMessage method to display message for empty list
               emptyMessage();
            }
            else
            {
               // Display the output for list size
               System.out.println("List size is: " + myList.countNodes());
            }
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 8: Print the list in forward order
         else if (option == 8) 
         {
            // Use if-else statement to check whether the list is empty
            // If list is empty, display empty message
            if (myList.countNodes() == 0)
            {
               // Call emptyMessage method to display message for empty list
               emptyMessage();
            }
            else
            {
               // Display the testing message
               System.out.println("Testing method printList()");
               System.out.println("Printing list in forward order.");
               
               // Display the message for outputing the list
               System.out.print("List content before printing is: ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
            
               // Display the message for output list content
               System.out.print("List content after printing is:  ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");              
            }
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 9: Print list in reverse order
         else if (option == 9) 
         {
            // Use if-else statement to check whether the list is empty
            // If the list is empty, display empty message
            if (myList.countNodes() == 0)
            {
               // Call emptyMessage method to display message for empty list
               emptyMessage();
            }
            else
            {
               // Display the testing message
               System.out.println("Testing method printInReverse()");
               System.out.println("Printing list in reverse order.");
               
               // Display the message for outputing the list before reversing
               System.out.print("List content before reversing is: ");
               // Call printList method to output the list content 
               myList.printList();
               // Start a new line
               System.out.print("\n");
              
               // Display the message for output list content in reverse order
               System.out.print("List content after reversing is:  ");
               // Call printList method to output the list content in reverse order
               myList.printInReverse(myList.head);
               // Start a new line
               System.out.print("\n");
            }
            // Display a blank line for spacing
            System.out.println();
         }
         
         // Option 10: Exit the program
         else if (option == 10) 
         {
            // Display an exit message
            System.out.println("Exiting program.");
         } 
         
         else
         {
            // Display an invalid option message
            System.out.println("Invalid option. Please enter the number from 1 to 10.");
            // Display a blank line for spacing
            System.out.println();
         }
      }  
   } 
   
   // Method printMenu to display the main menu
   public static void printMenu() 
   {
      System.out.println("---------MAIN MENU--------");
      System.out.println("1 - Add First Node");
      System.out.println("2 - Add Last Node");
      System.out.println("3 - Add At Index");
      System.out.println("4 - Remove First Node");
      System.out.println("5 - Remove Last Node");
      System.out.println("6 - Remove At Index");
      System.out.println("7 - Print List Size");
      System.out.println("8 - Print List (Forward)");
      System.out.println("9 - Print List (In Reverse)");
      System.out.println("10- Exit program");
      System.out.println(); // Display a blank line for spacing
      System.out.print("Enter option number: ");
   }
   
   // Method emptyMessage to display empty message
   public static void emptyMessage()
   {
      // Display empty message
      System.out.println("List is Empty");
   }
}
    
