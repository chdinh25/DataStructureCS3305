// Import the neccesary Java utility package
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

// Define HashFunctions class
public class HashFunctions
{
   // Define a 2D array of ize 50x2 to represent the hash table
   public static int [][] Table = new int[50][2];
   // Declare and initialize the size of the hash table
   public static int size = 50;
   
   // Main method
   public static void main(String[] args)
   {
      // Declare a scanner object to read user input
      Scanner in = new Scanner(System.in);
      // Declare an array of keys for hash functions
      int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                    5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                    5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                    5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                    5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};            
      
      // Declare variable option and set it to 0
      int option = 0;
      
      // Use while loop to check if user input correct option and execute corresponding option
      while (option != 5) 
      {
         // Call printMenu method to display the option menu
         printMenu();
         // Read the user input and store it in variable option            
         option = in.nextInt();
                  
         // Option 1: Division method with Linear Probing
         if (option == 1)
         {
            // Call HF1() method to hash table using Linear Probing and display the content
            HF1(keys);
         }
         
         // Option 2: Division method with Quadratic Probing
         else if (option == 2)
         {
            // Call HF2() method to hash table using Quadratic Probing and display the content
            HF2(keys);
         }
         
         // Option 3: Division method with Double Hashing
         else if (option == 3)
         {
            // Call HF3() method to hash table using Double Hashing and display the content
            HF3(keys);
         }
         
         // Option 4: Chaining metho
         else if (option == 4)
         {
            // Call HF4() method to hash table using Chaining and display the content
            HF4(keys);
         }       
         
         // Option 5: Exit the program
         else if (option == 5)
         {
            // Display the exit message
            System.out.println("Exiting program.");
         }            
            
         // If user input is not from 1 to 5
         else 
         {
            // Display invalid option
            System.out.println("Invalid option. Please select a valid option.");
         }
         // Display a blank line for spacing
         System.out.println();
      }        
   }
   
   // Method HF1() to implement hash function 1 (Division method with Linear Probing)
   // This method use array keys as parameter
   public static void HF1(int[] keys)
   {
      // Display output message
      System.out.println("Hash table resulted from HF1: ");
      System.out.println();
      
      // Call clearTables() method to clear the hash table to initialize it
      clearTable();
      
      // Use enhance for loop to iterate through the array of keys
      for (int key : keys) 
      {
         // Declare and calculate the initial index using modulo operation
         int index = key % size;
         // Initialize the probe count to 0
         int probes = 0;
         // Use while loop to keep searching for the next available slot
         while (Table[index][0] != 0) 
         {
            // Move to the next slot
            index = (index + 1) % size;
            // Increment the probes count
            probes++;
         }
         // Store the key in the table
         Table[index][0] = key;
         // Store the number of probes used
         Table[index][1] = probes;
      }
      // Call displayHashTable() method to display hash table content
      displayHashTable();
   }
   
   // Method HF2() to implement hash function 2 (Division method with Quadratic Probing)
   // This method use array keys as parameter
   public static void HF2(int[] keys)
   {
      // Display output message
      System.out.println("Hash table resulted from HF2: ");
      System.out.println();
      
      // Call clearTables() method to clear the hash table to initialize it
      clearTable();
      // Use enhance for loop to iterate through the array of keys
      for (int key : keys) 
      {
         // Declare and calculate the initial index using modulo operation
         int index = key % size;
         // Initialize the probe count to 0
         int probes = 0;
         // Use while loop to keep searching for the next available slot
         while (Table[index][0] != 0) 
         {
            // Increment the probes count
            probes++;
            // Calculate the next index using a quadratic function
            index = (key % size + (probes * probes)) % size;
            // If probing goes beyond the table size, display the message
            if (probes >= size) 
            {
               // Display message for probing has gone beyond table size
               System.out.println("Unable to hash key " + key + " to the table.");
            }
         }            
         // Store the key in the table
         Table[index][0] = key;
         // Store the number of probes used
         Table[index][1] = probes;
      }
      // Call displayHashTable() method to display hash table content
      displayHashTable();
   }
   
   // Method HF3() to implement hash function 3 (Division method with Double Hashing)
   // This method use array keys as parameter
   public static void HF3(int[] keys)
   {
      // Display output message
      System.out.println("Hash table resulted from HF3: ");
      System.out.println();
      
      // Call clearTables() method to clear the hash table to initialize it
      clearTable();
      
      // Use enhance for loop to iterate through the array of keys
      for (int key : keys) 
      {
         // Declare and calculate the initial index using modulo operation
         int index = key % size;
         // Initialize the probe count to 0
         int probes = 0;

         while (Table[index][0] != 0 && probes < size) 
         {
            // Calculate the second hash value
            int h2 = 30 - (key % 25);
            // Use double hashing to calculate the next index
            index = (index + h2) % size;
            // Increment the probes count
            probes++;
         }
         // If probing goes beyond the table size, display the message
         if (probes >= size) 
         {
            // Display message for probing has gone beyond table size
            System.out.println("Unable to hash key " + key + " to the table.");
         }
         else 
         {
            // Store the key in the table
            Table[index][0] = key;
            // Store the number of probes used
            Table[index][1] = probes;
         }
      }     
      // Call displayHashTable() method to display hash table content
      displayHashTable();
   }
   
   // Method HF4() to implement hash function 4 using Chaining
   // This method use array keys as parameter
   public static void HF4(int[] keys)
   {
      // Display output message
      System.out.println("Hash table resulted from HF4: ");
      System.out.println();
      
      // Call clearTables() method to clear the hash table to initialize it
      clearTable();
      // Declare an array of linked lists to handle collisions
      LinkedList<Integer>[] chains = new LinkedList[size];
      // Declare and initialize the variable hashedCount to 0 to count number of keys that are hashed
      int hashedCount = 0; 
      
      // Use enhance for loop to traverse through the array
      for (int key : keys) 
      {
         // Call customHashFunction() method to calculate the index
         int index = customHashFunction(key);
         
         // If the linked list at the calculated index is null
         if (chains[index] == null) 
         {  
            // Create a new linked list
            chains[index] = new LinkedList<>();
         }
         // Add the key to the linked list
         chains[index].add(key);
         // Increment variable hashCount
         hashedCount++;
      }
      
      // Use for loop to iterate through the linked lists and store information in the hash table
      for (int i = 0; i < size; i++) 
      {
         if (chains[i] != null) 
         {
            // Store the first key in the chain
            Table[i][0] = chains[i].get(0);  
            // Store the size of the linked list as the number of probes
            Table[i][1] = chains[i].size();
         }
      }
      // Call displayHashTable() method to display hash table content
      displayHashTable();
      
      // Calculate and display the percentage of keys that are successfully hashed
      double percentageHashed = (double) hashedCount / keys.length * 100.0;
      System.out.println("Percentage of keys hashed: " + percentageHashed + "%");
   }
   
   // Method displayHashTable to display hash table content
   public static void displayHashTable() 
   {
      // Display output message
      System.out.println("Index   Key    probes");
      System.out.println("------------------------");
      
      // Use for loop to traverse the hash table
      for (int i = 0; i < size; i++) 
      {
         // Display content
         System.out.printf("  %-6d%-9d%d\n", i, Table[i][0], Table[i][1]);
      }
      System.out.println("------------------------");
      System.out.println();
      // Call sumProbes() method to get total number of probes and display it
      System.out.println("Sum of probe values = " + sumProbes(Table) + " probes.");
   }
   
   // Method sumProbes to calculate and return the sum of all probes in the table 
   public static int sumProbes(int Table[][]) 
   {
      // Declare and intialize variable sum to 0
      int sum = 0;
      // Use for loop to traverse the array
      for (int i = 0; i < size; i++) 
      {
         // Update variable sum
         sum = sum + Table[i][1];
      }
      // Return to where it is called;
      return sum;
   }
   
   // Method clearTable to reset the hash table by setting all elements to 0
   public static void clearTable() 
   {
      // Use for loop to iterate through each row of the table
      for (int i = 0; i < size; i++) 
      {
         // Set the key at index i to 0
         Table[i][0] = 0;
         // Set the probes at index i to 0
         Table[i][1] = 0;
      }
   }
   
   // Method customHashFunction to provide a custom hash value for a given key
   public static int customHashFunction(int key)
   { 
      // Use modular arithmetic as a starting point   
      int hash = key % size;  
      return hash;  
   }
                
   // Method printMenu to display the main menu
   public static void printMenu()
   {
      System.out.println("\n-----MAIN MENU--------------------------------------");
      System.out.println("1. Run HF1 (Division method with Linear Probing)");
      System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
      System.out.println("3. Run HF3 (Division method with Double Hashing)");
      System.out.println("4. Run HF4 (Student Designed HF)");
      System.out.println("5. Exit program");
      System.out.println(); // Display blank line for spacing
      System.out.print("Enter option number: ");
   }
}
   


