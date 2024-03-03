// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;
import java.util.*;

// Define ReachabilityMatrix class
public class ReachabilityMatrix 
{
   // Declare an array to hold the matrix and varaiable numberOfNodes to hold number of node of the matrix
   public static int[][] adjacencyMatrix;
   public static int numberOfNodes;
   
   // Main method
   public static void main(String[] args) 
   {
      // Declare a scanner object to read user input
      Scanner in = new Scanner(System.in);     
      // Declare variable option and set it to 0
      int option = 0;
      // Declare variable option1 and initialize a flag for option 1
      boolean option1 = false;
      
      // Use while loop to check if user input correct option and execute corresponding option
      while (option != 3) 
      {
         // Call printMenu method to display the option menu
         printMenu();
         // Read the user input and store it in variable option            
         option = in.nextInt();
                  
         // Option 1: Read input data from user
         if (option == 1)
         {
            while (true) 
            {
               // Prompt the user to enter the number of nodes
               System.out.print("Please enter the number of nodes in the graph (no more than 5): ");
               // Read user input and store it in variable numberOfNodes
               numberOfNodes = in.nextInt();

               // Check if the number of nodes is valid
               if (numberOfNodes <= 5) 
               {          
                  // Initialize the adjacency matrix based on the user-provided number of nodes
                  adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
      
                  System.out.println("Please enter the adjacency matrix values (row-by-row):");
                  // Use for loop to read adjacency matrix values from the user for each row
                  for (int i = 0; i < numberOfNodes; i++) 
                  {
                     // Loop to read adjacency matrix values for each column in the current row
                     for (int j = 0; j < numberOfNodes; j++) 
                     {
                        // Prompt the user to enter the value for the current matrix element
                        System.out.print("Enter A1[" + i + "," + j + "]: ");
                        // Read user input and store it in the adjacency matrix
                        adjacencyMatrix[i][j] = in.nextInt();
                     }
                  }
                  // Set a flag to indicate that option 1 has been executed
                  option1 = true; 
                  // Exit the loop if input is valid
                  break;
               }
               else
               {
                  // Display an error message
                  System.out.println("The number of nodes cannot exceed 5. Please try again.");
                  // Return to the main menu
                  break;
               } 
            }          
         }       
         
         // Option 2: Process and display graph content
         else if (option == 2)
         {
            // Use if else statement to check if option 1 is executed
            // If option 1 is not executed
            if (!option1)
            {
               // Display message require user to choose option 1 first
               System.out.println("Please choose option 1 first.");
            }
            // If option 1 is executed
            else
            {  
               // Display the input matrix by calling printMatrix() method             
               System.out.println("Input Matrix:");
               printMatrix(adjacencyMatrix);
               System.out.println(); // Display a blank line for spacing

               // Display the reachability matrix
               System.out.println("Reachability Matrix:");
               int[][] reachabilityMatrix = computeReachability(adjacencyMatrix, numberOfNodes);
               printMatrix(reachabilityMatrix);
               System.out.println(); // Display a blank line for spacing
               
               // Display in-degrees of the graph by calling inDegrees() method
               System.out.println("In-degrees:");
               inDegrees();
               System.out.println(); // Display a blank line for spacing
               
               // Display out-degrees of the graph by calling outDegrees() method
               System.out.println("Out-degrees:");
               outDegrees();
               System.out.println(); // Display a blank line for spacing
               
               // Display the total number of self-loops in the graph
               System.out.println("Total number of self-loops: " + countSelfLoops());
               
               // Display the total number of cycles of length 'numberOfNodes' edges in the graph
               System.out.println("Total number of cycles of length " + numberOfNodes + " edges: " + countCycles(numberOfNodes));
               
               // Display the total number of paths of length 1 edge in the graph
               System.out.println("Total number of paths of length 1 edge: " + countPaths(1));
               
               // Display the total number of paths of length 'numberOfNodes' edges in the graph
               System.out.println("Total number of paths of length " + numberOfNodes + " edges: " + countPaths(numberOfNodes));
      
               // Display the total number of paths of length 1 to 'numberOfNodes' edges in the graph
               System.out.println("Total number of paths of length 1 to " + numberOfNodes + " edges: " + countPaths(1, numberOfNodes));
      
               // Display the total number of cycles of length 1 to 'numberOfNodes' edges in the graph
               System.out.println("Total number of cycles of length 1 to " + numberOfNodes + " edges: " + countCycles(1, numberOfNodes));
               System.out.println("--------------------------------------------------");
            }
         }
         
         // Option 3: Exit the program
         else if (option == 3)
         {
            // Display the exit message
            System.out.println("Exiting program.");
         }            
            
         // If user input is not from 1 to 3
         else 
         {
            // Display invalid option
            System.out.println("Invalid option. Please select a valid option.");
         }
         // Display a blank line for spacing
         System.out.println();
      }        
   }
   
   // Method printMatrix() to display matrix content
   // This method use input matrix as parameter
   public static void printMatrix(int[][] matrix) 
   {
      // Use for loop to loop through each row of the matrix
      for (int i = 0; i < numberOfNodes; i++) 
      {
         // Loop through each column of the current row
         for (int j = 0; j < numberOfNodes; j++) 
         {
            // Print the value of the current matrix element followed by a space
            System.out.print(matrix[i][j] + "  ");
         }
         // Move to the next line after printing all elements in the current row
         System.out.println();
      }
   }
   
   // Method computeReachability() to compute the reachability matrix
   // This method use input matrix and number of nodes as parameters
   private static int[][] computeReachability(int[][] matrix, int numEdges) 
   {
      // Create a new matrix to store the reachability information
      int[][] result = new int[numberOfNodes][numberOfNodes];
    
      // Initialize result with the values of the adjacency matrix
      for (int i = 0; i < numberOfNodes; i++) 
      {
         for (int j = 0; j < numberOfNodes; j++) 
         {
            result[i][j] = matrix[i][j];
         }
      }
    
      // Multiply the matrix by itself for the specified number of edges
      for (int edge = 2; edge <= numEdges; edge++) 
      {
         // Calculate the power of the matrix (A^edge)
         result = multiplyMatrices(result, matrix);
        
         // Add the calculated power to the reachability matrix
         result = addMatrices(result, matrix);
      }
      // Return the final reachability matrix
      return result;
   }

   // Method to add two matrices
   private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) 
   {
      // Get the number of rows and columns of the matrices
      int rows = matrix1.length;
      int cols = matrix1[0].length;
      
      // Create a new matrix to store the result of the addition
      int[][] result = new int[rows][cols];
      
      // Perform element-wise addition of the two matrices
      for (int i = 0; i < rows; i++) 
      {
         for (int j = 0; j < cols; j++) 
         {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
         }
      }
      // Return the result matrix
      return result;
   }

   // Method to multifly 2 matrices
   public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) 
   {
      // Get the number of rows and columns of the input matrices
      int rows1 = matrix1.length;
      int cols1 = matrix1[0].length;
      int cols2 = matrix2[0].length;
      
      // Create a new matrix to store the result of the multiplication
      int[][] result = new int[rows1][cols2];
      
      // Use nest loop to calculate matrix multiplication
      for (int i = 0; i < rows1; i++) 
      {
         for (int j = 0; j < cols2; j++) 
         {
            for (int k = 0; k < cols1; k++) 
            {
               result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
         }
      }
      // Return the result matrix
      return result;
   }
      
   // Method inDerees() to compute and print the in-degrees for each node in the graph
   private static void inDegrees() 
   {
      // Loop through each node in the graph
      for (int i = 0; i < numberOfNodes; i++) 
      {
         // Declare and initialize in-degree count for the current node
         int inDegree = 0;
         // Loop through each node to calculate in-degrees
         for (int j = 0; j < numberOfNodes; j++) 
         {
            // Increment in-degree for the current node based on the adjacency matrix
            inDegree += adjacencyMatrix[j][i];
         }
         // Print the calculated in-degree for the current node
         System.out.println("Node " + (i + 1) + " in-degree is " + inDegree);
      }
   }
   
   // Method outDerees() to compute and print the out-degrees for each node in the graph
   private static void outDegrees() 
   {
      // Loop through each node in the graph
      for (int i = 0; i < numberOfNodes; i++) 
      {
         // Declare and initialize out-degree count for the current node
         int outDegree = 0;
         // Loop through each node to calculate out-degrees
         for (int j = 0; j < numberOfNodes; j++) 
         {
            // Increment out-degree for the current node based on the adjacency matrix
            outDegree += adjacencyMatrix[i][j];
         }
         // Print the calculated out-degree for the current node
         System.out.println("Node " + (i + 1) + " out-degree is " + outDegree);
      }
   }
   
   // Method countSelfLoops() to counts and returns the total number of self-loops in the graph
   private static int countSelfLoops() 
   {
      // Declare and initialize a counter for self-loops
      int count = 0;
      // Loop through each node in the graph
      for (int i = 0; i < numberOfNodes; i++) 
      {
         // Check if the node has a self-loop (an edge connecting it to itself)
         if (adjacencyMatrix[i][i] == 1) 
         {
            // Increment the counter if a self-loop is found
            count++;
         }
      }
      // Return the total count of self-loops in the graph
      return count;
   }
   
   // Method countCycles() to counts and returns the total number of cycles of a specified length in the graph
   // This method use the length of cycles to be counted as parameter
   private static int countCycles(int length) 
   {
      // Declare and initialize a counter for self-loops
      int count = 0;
      // Loop through each node in the graph to count cycles using a recursive utility function
      for (int i = 0; i < numberOfNodes; i++) 
      {
         // Incremented by the value returned from the countCyclesUtil function
         count += countCyclesUtil(i, i, length - 1);
      }
      // Return the total count of cycles of the specified length in the graph
      return count;
   }
   
   // Method countCyclesUtil() to recursive utility function to count cycles of a specified length in the graph
   // This method use the starting node of the cycle, the current node being explored in the recursion,
   // and the remaining length to complete the cycle as parameters  
   private static int countCyclesUtil(int start, int current, int length) 
   {
      // Base case: If the specified length is reached
      if (length == 0) 
      {
         // Check if there is an edge to the starting node
         if (adjacencyMatrix[current][start] == 1) 
         {
            return 1;
         } 
         else 
         {
            return 0;
         }
      }
      // Declare and initialize a counter for cycles
      int count = 0;
      // Loop through each node in the graph
      for (int i = 0; i < numberOfNodes; i++) 
      {
         // Check if there is an edge from the current node to another node
         if (adjacencyMatrix[current][i] == 1) 
         {
            // Recursively explore cycles with reduced length
            count += countCyclesUtil(start, i, length - 1);
         }
      }
      // Return the count of cycles starting from the given node
      return count;
   }

   // Method countPaths() to counts and returns the total number of paths of a specified length in the graph
   // This method use the length of cycles to be counted as parameter
   private static int countPaths(int length) 
   {
      // Delare and initialize a counter for paths
      int count = 0;
      // Loop through each pair of nodes in the graph
      for (int i = 0; i < numberOfNodes; i++)
      {         
         for (int j = 0; j < numberOfNodes; j++) 
         {
            // Count paths between the current pair of nodes
            count += countPathsUtil(i, j, length);
         }
      }
      // Return the total count of paths of the specified length in the graph
      return count;
   }
   
   // Method countPathsUtil() to recursive utility function to count paths of a specified length in the graph
   // This method use the starting node of the cycle, the current node being explored in the recursion,
   // and the remaining length to complete the cycle as parameters
   private static int countPathsUtil(int start, int current, int length) 
   {
      // Delare and initialize a counter for paths
      int count = 0;
      // Base case: If the specified length is reached
      if (length == 0) 
      {
         // Check if the path ends at the starting node
         if (start == current) 
         {
            count = 1;
         } 
         else 
         {
            count = 0;
         }
      } 
      // Recursive case: Explore paths with reduced length
      else 
      {
         // Loop through each node in the graph
         for (int i = 0; i < numberOfNodes; i++) 
         {
            // Check if there is an edge from the current node to another node
            if (adjacencyMatrix[current][i] == 1) 
            {
               // Recursively explore paths with reduced length
               count += countPathsUtil(start, i, length - 1);
            }
         }
      }
      // Return the count of paths between the given nodes
      return count;
   }

   // Method countPaths() to counts and returns the total number of paths of lengths within a specified range
   // This method use the minimum and maximum length of paths to be counted as parameters
   private static int countPaths(int minLength, int maxLength) 
   {
      // Delare and initialize a counter for paths
      int count = 0;
      // Loop through each length within the specified range
      for (int i = minLength; i <= maxLength; i++) 
      {
         // Count paths of the current length and add to the total count
         count += countPaths(i);
      }
      // Return the total count of paths within the specified length range
      return count;
   }
   
   // Method countCycles() to counts and returns the total number of cycles of lengths within a specified range
   // This method use the minimum and maximum length of cycles to be counted as parameters
   private static int countCycles(int minLength, int maxLength) 
   {
      // Delare and initialize a counter for cycles
      int count = 0;
      // Loop through each length within the specified range
      for (int length = minLength; length <= maxLength; length++) 
      {
         // Count cycles of the current length and add to the total count
         count += countCycles(length);
      }
      // Return the total count of cycles within the specified length range
      return count;
   }
   
   // Method printMenu() to display the main menu
   public static void printMenu()
   {
      System.out.println("------MAIN MENU------");
      System.out.println("1. Enter graph data");
      System.out.println("2. Print outputs");
      System.out.println("3. Exit program");
      System.out.println(); // Display a blank line for spacing
      System.out.print("Enter option number: ");
   }
}



