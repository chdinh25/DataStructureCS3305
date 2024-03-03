// Define Stack class
public class Stack<E>
{
   // Declare private variables for top node and size of the stack
   private Node<E> top;
   private int size;
   
   // Create a constructor for the Stack class
   public Stack()
   {
      // Initialize the variable top to null
      top = null;
      // Initialize the variable size to 0
      size = 0;
   }
   
   // Define a private nested class for nodes within the stack
   private static class Node<E>
   {
      // Data stored in the node
      E data;
      // Declare the next node
      Node<E> next;
      // Constructor for the Node class
      Node(E data)
      {
         // Set the data parameter to the data node        
         this.data = data;
         //Initialize the next node to null
         this.next = null;
      }
   }
   
   // Method to push an element to the stack
   // This method use user input as a parameter
   public void push(E e)
   {
      // Declare a new node with the element
      Node<E> newNode = new Node(e);
      // Set the next reference of the new node to the current top node
      newNode.next = top;
      // Set the top reference to point to the new node
      top = newNode;
   }
   
   // Method to pop an element from the stack and return it
   public E pop()
   {
      // Check if the stack is not empty
      if (size() == 0)
      {
         // Display empty message
         System.out.println("The stack is empty.");
      }
      // Get the data from the current top node
      E data = top.data;
      // Set the top node to the next node
      top = top.next;
      // Return the popped data
      return data;
   }
   
   // Method to get the top element without removing it
   public E top()
   {
      // Check if the stack is not empty
      if (size() == 0)
      {
         // Display empty message
         System.out.println("The stack is empty.");
      }
      // Return the top element to where it is called
      return top.data;
   }
   
   // Method to get the size of the stack
   public int size()
   {
      // Declare and initialize a count variable
      int count = 0;
      // Initialize a current node to the top
      Node<E> current = top;
      // Use while loop to traverse through the stack
      while (current != null) 
      {
         // Increment the count for each node
         count++;
         // Move to the next node
         current = current.next;
      }
      // Return count as the size of the stack
      return count;
   }
   
   // Method to check if the stack is empty
   public boolean isEmpty()
   {
      // The stack is empty if its size is 0
      return size == 0;
   }
   
   // Method to print stack content
   public void printStack()
   {
      // Initialize a current node to the top
      Node<E> current = top;
      // Use while loop to traverse through the stack
      while (current != null)
      {
         // Display the data in the current node
         System.out.print(current.data + " ");
         // Move to the next node
         current = current.next;
      }
      // Display a blank line for spacing
      System.out.println();
   }
}
      
   
   
