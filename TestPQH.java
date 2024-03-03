// Import the neccesary Java utility package
import java.util.Scanner;

// Define TestPQH class
public class TestPQH 
{
    // Main method 
    public static void main(String[] args) 
    {
        // Declare a scanner object to read user input
        Scanner in = new Scanner(System.in);
        // Declare and initialize pq as null initially, using a wildcard for the generic type
        PQ_Heap<?> pq = new PQ_Heap<>();
        // Declare variable queueType to hold data type from user in option 0
        String queueType = "";
        // Declare variable option and set it to -1
        int option = -1;
        // Declare a boolean to ensure option 0 is executed first
        boolean option0Executed = false;

        // Use while loop to check if user input correct option and execute corresponding option
        while (option != 8) 
        {
            // Call printMenu method to display the option menu
            printMenu();
            // Read the user input and store it in variable option            
            option = in.nextInt();
            // Consume the newline character
            in.nextLine(); 
            
            // Option 0: Read data type from user (integer or string)
            if (option == 0)
            {
                // Prompt user to input data type
                System.out.print("Please enter Queue Type (integer or string): ");
                // Read user input and store it in variable queueType
                queueType = in.next();
                
                // Use if statement to check if user enter 'integer'
                if (queueType.equalsIgnoreCase("integer")) 
                {
                    // Set queue type to integer
                    pq = new PQ_Heap<Integer>(); // Create an integer priority queue
                } 
                // If user enter 'string'
                else if (queueType.equalsIgnoreCase("string")) 
                {
                    // Set queue type to string
                    pq = new PQ_Heap<String>(); // Create a string priority queue
                } 
                else 
                {
                    // Display error message
                    System.out.println("Invalid data type. Please enter 'integer' or 'string'.");
                }
                option0Executed = true;
                // Display queue type message
                System.out.println("The priority queue data type set to: " + queueType);
            }
            
            // If statement to force the user to start with option 0 to select the queue data type first
            else if (!option0Executed) 
            {
                // Display error message
                System.out.println("Error. Please set the priority queue data type first (Option 0).");
            } 
            
            // Option 1: Enqueue the element to the queue
            else if (option == 1)
            {
                // Prompt user to input an element for adding to the queue
                System.out.print("Please enter an element to enqueue: ");
                
                // Check the data type selected by the user   
                if (queueType.equalsIgnoreCase("integer")) 
                {
                    // Read an integer value from the user
                    int value = in.nextInt();
                    // Call enqueue() method to enqueue the integer value into the priority queue
                    ((PQ_Heap<Integer>) pq).enqueue(value);
                } 
                else if (queueType.equalsIgnoreCase("string")) 
                {
                    // Read a string value from the user
                    String value = in.next();
                    // Call enqueue() method to enqueue the string value into the priority queue
                    ((PQ_Heap<String>) pq).enqueue(value);
                }
            }
                    
            // Option 2: Dequeue element from the queue
            else if (option == 2)
            {
                // Check the data type selected by the user  
                if (queueType.equalsIgnoreCase("integer")) 
                {
                    // Dequeue an integer from the priority queue and store it in variable dequeued
                    Integer dequeued = ((PQ_Heap<Integer>) pq).dequeue();
                    if (dequeued != null) 
                    {
                        // Display the dequeued integer value
                        System.out.println("Dequeued: " + dequeued);
                    }
                } 
                else if (queueType.equalsIgnoreCase("string")) 
                {
                    // Dequeue a string from the priority queue and store it in variable dequeued
                    String dequeued = ((PQ_Heap<String>) pq).dequeue();
                    if (dequeued != null) 
                    {
                        // Display the dequeued string value
                        System.out.println("Dequeued: " + dequeued);
                    } 
                }
            }
            
            // Option 3: Check if the priority queue is full
            else if (option == 3)
            {
                // Check if the queue is full
                if (!pq.is_full())
                {
                    // Display message for not full queue
                    System.out.println("Queue is not full.");
                }
                else
                {
                    // DIsplay message for full queue
                    System.out.println("Queue is full.");
                } 
            }
            
            // Option 4: Check if the priority queue is empty
            else if (option == 4)
            {
                // Check if the queue is empty
                if (!pq.is_empty())
                {
                    // Display message for non-empty queue
                    System.out.println("Queue is not empty.");
                }
                else
                {
                    // Call emptyMessage() to display empty message for empty queue
                    emptyMessage();
                }
            }
            
            // Option 5: Display the size of the priority queue
            else if (option == 5)
            {
                // Check if queue is empty
                if (!pq.is_empty())
                {
                    // Call size() method to get queue size and display it
                    System.out.println("The Priority Queue Size: " + pq.size());
                }
                else
                {
                    // Display empty message for empty queue
                    emptyMessage();
                }
            }
            
            // Option 6: Display the front element of the priority queue
            else if (option == 6)
            {
                // Check the data type selected by the user
                if (queueType.equalsIgnoreCase("integer"))
                {
                    // Check if the queue is empty
                    if (!pq.is_empty()) 
                    {   
                        // Get the front integer element from the priority queue and store it in variable frontInt                     
                        Integer frontInt = (Integer) pq.front();
                        // Display fron element
                        System.out.println("Front Element: " + frontInt);
                    } 
                    else 
                    {
                        // Display empty message for empty queue
                        emptyMessage();
                    }
                }
                else if (queueType.equalsIgnoreCase("string")) 
                {
                    // Check if the queue is empty
                    if (!pq.is_empty()) 
                    {   
                        // Get the front string element from the priority queue and store it in variable frontStr                   
                        String frontStr = (String) pq.front();
                        // Display fron element
                        System.out.println("Front Element: " + frontStr);
                    } 
                    else 
                    {
                        // Call emptyMessage() to display empty message for empty queue
                        emptyMessage();
                    }
                }               
            }
            
            
            // Option 7: Print the elements of the priority queue
            else if (option == 7)
            {
                // Check if queue is empty
                if (!pq.is_empty())
                {   
                    // Display a message indicating the content is being displayed           
                    System.out.println("Priority Queue Content:");
                    // Check the data type selected by the user  
                    if (queueType.equalsIgnoreCase("integer"))
                    {
                        // Cast the priority queue to the correct type
                        PQ_Heap<Integer> integerPQ = (PQ_Heap<Integer>) pq;
                        // Call display() method to display the elements of the integer priority queue
                        integerPQ.display();
                    }
                    else if (queueType.equalsIgnoreCase("string"))
                    {
                        // Cast the priority queue to the correct type
                        PQ_Heap<String> stringPQ = (PQ_Heap<String>) pq;
                        // Call display() method to display the elements of the string priority queue
                        stringPQ.display();
                    }
                }
                else 
                {
                    // Display empty message for empty queue
                    emptyMessage();
                }
            }
            
            // Option 8: Exit the program
            else if (option == 8)
            {
                // Display the exit message
                System.out.println("Exiting program.");
            }            
            
            // If user input is not from 0 to 8
            else 
            {
                // Display invalid option
                System.out.println("Invalid option. Please select a valid option.");
            }
            // Display a blank line for spacing
            System.out.println();
        }
    }
    
    // Method printMenu to display the main menu
    public static void printMenu()
    {
        System.out.println("\n----------------MAIN MENU---------------");
        System.out.println("0. Enter Queue Type (integer or string)");
        System.out.println("1. Enqueue Element");
        System.out.println("2. Dequeue Element");
        System.out.println("3. Check is_Full");
        System.out.println("4. Check is_Empty");
        System.out.println("5. Print PQueue Size");
        System.out.println("6. Display Front Element");
        System.out.println("7. Print PQueue Elements");
        System.out.println("8. Exit program");
        System.out.println(); // Display a blank line for spacing
        System.out.print("Enter option number: ");
    }
    
    // Method to display message for empty queue
    public static void emptyMessage()
    {
        System.out.println("Queue is empty.");
    }
}
