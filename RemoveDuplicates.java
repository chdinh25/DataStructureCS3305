// Import the neccesary Java utility package
import java.util.Scanner;
// Define class RemoveDuplicates 
public class RemoveDuplicates 
{
    // Declare and initialize a binary search tree (BST)
    private static BST<String> bst = new BST<>();
    // Flag to track whether input has been read
    private static boolean inputRead = false;
    // Main method
    public static void main(String[] args) 
    {
        // Create a Scanner object to read input
        Scanner input = new Scanner(System.in);
        // Variable to store user's menu choice
        int choice = 0;
        // Variable to store user's menu choice
        String text ="";
        
        // Use while loop to check if user input correct option and execute corresponding option
        while (choice != 3) 
        {
            // Call printMenu method to display the option menu
            printMenu();
            // Read the user input and store it in variable option
            choice = input.nextInt();
            input.nextLine(); // Consume newline character
            
            // Option 1: Read user input
            if (choice == 1)
            {
                // Prompt user to input a text
                System.out.print("Please enter input text: ");
                // Read the input text and store it in variable text
                text = input.nextLine();
                // Split the text into words and store in it array words
                String[] words = text.split(" ");
                // Use enhance for loop to traverse the array
                for (String word : words) 
                {
                    if (!word.isEmpty()) 
                    {
                        // Call insert() method to add word to the BST
                        bst.insert(word);
                    }
                }
                // Set inputRead to true, indicate that input is read
                inputRead = true;
            }
            
            // Option 2: Remove duplicates and display the output 
            else if (choice == 2)
            {
                // Use if statement to check if user input is read
                if (inputRead) 
                {   // Display the original text
                    System.out.println("Original Text:");
                    System.out.println(text);
                    // Display the tree content after remove duplicates
                    System.out.println("\nProcessed Text:");
                    // Call printInorderNoDuplicates() method to process the text
                    printInorderNoDuplicates(bst.getRoot());
                    System.out.println(); // Display a blank line for spacing
                } 
                else 
                {
                    // DIsplay message to ask user for choosing option 1 first
                    System.out.println("Please read input string first (Option 1).");
                }
            }
            
            // Option 3: Exit the program
            else if (choice == 3)
            {
                // Display exiting message
                System.out.println("Exiting program.");
            }
            
            // If the option is not from 1 to 3
            else 
            {
                // Display invalid message
                System.out.println("Invalid option. Please try again.");   
            }
            System.out.println(); // Display a blank line for spacing
        }
    }
    
    // Method printMenu to display the main menu
    public static void printMenu() {
        System.out.println("-----------------MAIN MENU---------------");
        System.out.println("1. Read input string");
        System.out.println("2. Remove duplicates and display outputs");
        System.out.println("3. Exit program");
        System.out.println(); // Display a blank line for spacing
        System.out.print("Enter option number: ");
    }
    
    // Method to print non-duplicate words in the BST in an inorder traversal.
    // This method use tree root as a parameter
    private static void printInorderNoDuplicates(BST.TreeNode<String> root) 
    {
        // If tree is empty
        if (root == null) return;
        
        // Traverse the left subtree
        printInorderNoDuplicates(root.left);
        
        // Check if the current node is not a duplicate of its left and right children
        if (!isDuplicate(root, root.left) && !isDuplicate(root, root.right)) 
        {
            // Print the non-duplicate word
            System.out.print(root.element + " ");
        }
        
        // Print the non-duplicate word
        printInorderNoDuplicates(root.right);
    }
    
    // Method to check if two tree nodes have the same element (word)
    private static boolean isDuplicate(BST.TreeNode<String> current, BST.TreeNode<String> other) 
    {
        // If the other node is null, it's not a duplicate
        if (other == null) return false;
        // If the other node is null, it's not a duplicate
        return current.element.equals(other.element);
    }
}
