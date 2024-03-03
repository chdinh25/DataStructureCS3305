// Import the neccesary Java utility package
import java.util.Scanner;
import java.util.ArrayList;

// Define class MyTestBST
public class MyTestBST 
{
    // Main method
    public static void main(String[] args) 
    {
        // Declare a scanner object to read user input
        Scanner in = new Scanner(System.in);
        // Declare a variable to hold the BST
        BST<?> tree = null;
        // Declare variable dataType to hold data type from user in option 0
        String dataType = "";
        // Declare variable option and set it to -1
        int option = -1;
        
        // Use while loop to check if user input correct option and execute corresponding option
        while (option != 10) 
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
                System.out.print("Please enter the tree data type (integer or string): ");
                // Read user input and store it in variable dataType
                dataType = in.nextLine();
                
                // Use if statement to check if user enter 'integer'
                if ("integer".equalsIgnoreCase(dataType)) 
                {
                    // Set tree type to integer
                    tree = new BST<Integer>();
                } 
                // If user enter 'string'
                else if ("string".equalsIgnoreCase(dataType)) 
                {
                    // Set tree type to string
                    tree = new BST<String>();
                } 
                // If user input is neither integer or string
                else 
                {
                    // Display error message
                    System.out.println("Invalid data type. Please enter 'integer' or 'string'.");
                }
                // Display tree type message
                System.out.println("Tree data type set to: " + dataType);
            } 
            
            // If statement to force the user to start with option 0 to select the tree data type
            else if (tree == null) 
            {
                // Display error message
                System.out.println("Error. Please set the tree data type first (Option 0).");
            } 
            
            // Option 1: Read user input and store it to tree
            else if (option == 1) 
            {
                // Prompt user to input data 
                System.out.print("Please enter data element to insert: ");
                
                // Use if else stament to check datatype to execute the coressponding tree
                // If data type is integer
                if ("integer".equalsIgnoreCase(dataType)) 
                {
                    // Declare variable element type integer, read and store user input to it
                    int element = in.nextInt();
                    in.nextLine(); // Consume the newline character
                    // Display testing message for the tree content before inserting
                    System.out.println("Testing method Insert Data Element (Option 1)");
                    System.out.print("BST before inserting " + element + " (Inorder):  ");
                    // Call inorder() method to display the tree content inorder order
                    tree.inorder();
                    System.out.println(); // Display blank line for spacing
                    
                    // Call insert() method to add the element to the tree
                    ((BST<Integer>) tree).insert(element); 
                    
                    // Display the tree content after inserting
                    System.out.print("BST after inserting " + element + " (Inorder):   ");
                    // Call inorder() method to display the tree content inorder order
                    tree.inorder();            
                }
                // If data type is string 
                else if ("string".equalsIgnoreCase(dataType)) 
                {
                    // Declare variable element type string, read and store user input to it
                    String element = in.nextLine();
                    // Display testing message for the tree content before inserting
                    System.out.println("Testing method Insert Data Element (Option 1)");
                    System.out.print("BST before inserting " + element + " (Inorder):  ");
                    // Call inorder() method to display the tree content inorder order
                    tree.inorder();
                    System.out.println(); // Display blank line for spacing
                    
                    // Call insert() method to add the element to the tree
                    ((BST<String>) tree).insert(element);
                    
                    // Display the tree content after inserting
                    System.out.print("BST after inserting " + element + " (Inorder):   ");
                    // Call inorder() method to display the tree content inorder order
                    tree.inorder();
                }
                System.out.println(); // Display blank line for spacing
            }
            
            // Option 2: Read the user input and delete that input from the tree
            else if (option == 2) 
            {
                // Prompt user to input the element need to be removed
                System.out.print("Please enter data element to delete: ");
                // Declare variable element type string, read and store user input to it
                String element = in.nextLine();
                // Display testing message for the tree content before deleting
                System.out.println("Testing method Delete Data Element (Option 2)");
                System.out.print("BST before deleting " + element + " (Inorder):  ");
                // Call inorder() method to display the tree content inorder order
                tree.inorder();
                System.out.println(); // Display blank line for spacing
                
                // If data type is string 
                if ("string".equalsIgnoreCase(dataType)) 
                {
                    // Call delete() method to delete the eleemnt from the tree
                    ((BST<String>) tree).delete(element);
                } 
                // If data type is integer
                else if ("integer".equalsIgnoreCase(dataType)) 
                {
                    try 
                    {
                        // Attempt to parse the input element as an integer
                        int intElement = Integer.parseInt(element);
                        // Call delete() method to delete the eleemnt from the tree
                        ((BST<Integer>) tree).delete(intElement);
                    } 
                    catch (NumberFormatException e) 
                    {
                        // Display error message
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }
                }
                // DIsplay message for tree content after deleting
                System.out.print("BST after deleting " + element + " (Inorder):   ");
                // Call inorder() method to display the tree content inorder order
                tree.inorder();
                System.out.println(); // Display blank line for spacing
            } 
            
            // Option 3: Search for specific element from user input
            else if (option == 3) 
            {
                // Prompt user to enter input to search
                System.out.print("Please enter data element to search for: ");
                // Declare variable element type string, read and store user input to it
                String element = in.nextLine();
                // Testing method Search for Data Element
                System.out.println("Testing method Search for Data Element (Option 3)");
                if ("string".equalsIgnoreCase(dataType)) 
                {
                    // Declare string varibale found to hold the answer from search() method
                    String found = "";
                    // Use if-else statement to check if the element is found
                    // If yes
                    if (((BST<String>) tree).search(element) == true)
                    {
                        // Set found to true
                        found = "True";
                    }
                    else
                    {
                        // Set found to false
                        found = "False";
                    }
                    // Display the result
                    System.out.println("Search for " + element + "? " + found);
                } 
                else if ("integer".equalsIgnoreCase(dataType)) 
                {
                    try 
                    {
                        // Attempt to parse the input element as an integer
                        int intElement = Integer.parseInt(element);
                        // Declare string varibale found to hold the answer from search() method
                        String found = "";
                        // Use if-else statement to check if the element is found
                        // If yes
                        if (((BST<Integer>) tree).search(intElement) == true)
                        {
                            // Set found to true
                            found = "True";
                        }
                        else
                        {
                            // Set found to false
                            found = "False";
                        }
                        // Display the result
                        System.out.println("Search for " + intElement + "? " + found);
                    } 
                    catch (NumberFormatException e) 
                    {
                        // Display error message
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }
                }
            } 
            
            // Option 4: Display the size of the tree
            else if (option == 4) 
            {
                // Display testing message
                System.out.println("Testing method Tree size (Option 4)");
                // Call getSize() method to get the tree size and display it
                System.out.println("Tree size: " + tree.getSize());
            } 
            
            // Option 5: Find the path from root to a specific element that is input from user
            else if (option == 5) 
            {
                // Prompt user to enter the element 
                System.out.print("Please enter data element to find path: ");
                // Declare a variable pathElement type string, read and store user input to it
                String pathElement = in.nextLine();
                
                // If data type is string 
                if ("string".equalsIgnoreCase(dataType)) 
                {
                    // Declare an arraylist to hold the path
                    ArrayList<BST.TreeNode<String>> path = ((BST<String>) tree).path(pathElement);
                    // Use it statement to check if the arraylist is null
                    if (path != null) 
                    {
                        // Display the message
                        System.out.print("Path from root to " + pathElement + ": ");
                        // Use enhence for lopp to traverse through the arraylist
                        for (BST.TreeNode<String> node : path) 
                        {
                            // Print out the array list content
                            System.out.print(node.element + " ");
                        }
                        System.out.println(); // Display blank line for spacing
                    } 
                    else 
                    {
                        // Display message for not found
                        System.out.println(pathElement + " not found in the tree.");
                    }
                } 
                else if ("integer".equalsIgnoreCase(dataType)) 
                {
                    try 
                    {
                        // Attempt to parse the input element as an integer
                        int intElement = Integer.parseInt(pathElement);
                        // Declare an arraylist to hold the path
                        ArrayList<BST.TreeNode<Integer>> path = ((BST<Integer>) tree).path(intElement);
                        if (path != null) 
                        {
                            // Display the message
                            System.out.print("Path from root to " + intElement + ": ");
                            // Use enhence for lopp to traverse through the arraylist
                            for (BST.TreeNode<Integer> node : path) 
                            {
                                // Print out the array list content
                                System.out.print(node.element + " ");
                            }
                            System.out.println();// Display blank line for spacing
                        } 
                        else 
                        {
                            // Display message for not found
                            System.out.println(intElement + " not found in the tree.");
                        }
                    } 
                    catch (NumberFormatException e) 
                    {
                        // Display error message
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }                
                }
            } 
            
            // Option 6: Check if the tree is empty
            else if (option == 6) 
            {
                // Display the testing message
                System.out.println("Testing method Check if Empty Tree (Option 6)");
                // Declare string variable empty to hold the answer from isEmpty() method
                String empty = "";
                // Use if statement to check if the tree is empty
                // If yes
                if (tree.isEmpty() == true)
                {
                    // Set empty to true
                    empty = "True";
                }
                else
                {
                    // Set empty to false
                    empty = "False";
                }

                // Call isEmpty() method to check if the tree is empty
                System.out.println("Is empty tree? " + empty);
            } 
            
            // Option 7: Display tree content in preorder order
            else if (option == 7) 
            {
                // Display testing method
                System.out.println("Testing method Preorder Traversal (Option 7)");
                System.out.print("Preorder: ");
                // Call preorder() method to display the tree content preorder order
                tree.preorder();
                System.out.println(); // Display blank line for spacing
            } 
            
            // Option 8: Display tree content in inorder order
            else if (option == 8) 
            {
                // Display testing method
                System.out.println("Testing method Inorder Traversal (Option 8)");
                System.out.print("Inorder: ");
                // Call inorder() method to display the tree content inorder order
                tree.inorder();
                System.out.println(); // Display blank line for spacing
            } 
            
            // Option 9: Display tree content in postorder order
            else if (option == 9) 
            {
                // Display testing method
                System.out.println("Testing method Postorder Traversal (Option 9)");
                System.out.print("Postorder: ");
                // Call postorder() method to display the tree content postorder order
                tree.postorder();
                System.out.println(); // Display blank line for spacing
            } 
            
            // Option 10: Exit the program
            else if (option == 10)
            {
                // Display the exit message
                System.out.println("Exiting program.");
            }            
            
            // If user input is not from 0 to 10
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
        System.out.println("----------------MAIN MENU---------------");
        System.out.println("0.  Enter Tree Data Type (integer or string)");
        System.out.println("1.  Insert Data Element");
        System.out.println("2.  Delete Data Element");
        System.out.println("3.  Search for Data Element");
        System.out.println("4.  Print Tree Size");
        System.out.println("5.  Path from Root to Data Element");
        System.out.println("6.  Check if Empty Tree");
        System.out.println("7.  Print Preorder Traversal");
        System.out.println("8.  Print Inorder Traversal");
        System.out.println("9.  Print Postorder Traversal");
        System.out.println("10. Exit program");
        System.out.println(); // Display blank line for spacing
        System.out.print("Enter option number: ");
    }
}
