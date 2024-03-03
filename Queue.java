// Import the neccesary Java utility package to use LinkedList class
import java.util.*;
import java.util.LinkedList;

// Define a generic class named Queue
public class Queue<E>
{ 
   // Declare a private LinkedList to store elements
   private LinkedList<E> list;
   // Declare private Node instances for the head and tail of the queue
   private Node<E> head, tail;
   
   // Define a private class Node to represent elements in the queue
   private class Node<E> 
   {
      // Data field to store the element
      E data;
      // Node next to reference to the next node in the queue
      Node<E> next;
      
      // Constructor for Node to initialize data and next
      public Node(E data) 
      {
         this.data = data;
         this.next = null;
      }
   }
   
   // Constructor for the Queue class  
   public Queue()
   {
      // Initialize the LinkedList 
      list = new LinkedList<E>();
      // Initialize the head and tail to null
      head = tail = null;
   }
   
   // Method enqueue() to add an element to the queue
   public void enqueue(E e)
   {
      // Create a new node with the data that passed as an arguement
      Node newNode = new Node(e);
      
      // Use if-else statement to check if the list is empty.
      // If the list is emty
      if (head == null)
      {
         // Set head and tail to new node
         head = tail = newNode;
      }
      // If the list is not empty
      else
      {
         // Set the new node sas a new head
         newNode.next = head;
         // Set the head pointer to the new node
         head = newNode;
      }
   }
   
   // Method dequeue() to remove and return an element from the queue
   public E dequeue()
   {
      // If list is empty, display an error message
      if (head == null)
      {
         return null;
      }
      // If the list have one node
      else if (head == tail)
      {
         // Get the value of the head
         E value = head.data;
         // Reset head and tail to null
         head = tail = null;
         // Return the value
         return value;      
      }
      else
      {
         // Declare node current and set it to head pointer
         Node<E> current = head;
         // Use while loop to traverse to list to the node before the the last node
         while (current.next != tail)
         {
            // Traverse the list to the node before the last node
            current = current.next;
         }
         // Get the value of the tail
         E value = tail.data;
         // Remove the link to the last node
         current.next = null;
         // Update the tail pointer by setting it to the new last node
         tail = current;
         // Return the value
         return value;
      }
   }
   
   // Method front() to get the front element of the queue without removing it
   public E front()
   {
      // Check if the queue is not empty
      if (size() == 0)
      {
         // Display empty message
         System.out.println("The queue is empty.");
      }
      // Return the top element to where it is called
      return head.data;
   }
   
   // Method size() to get the number of elements of the queue 
   public int size()
   {
      // Declare variable listSize and intialize it to 0
      int listSize = 0;
      // Declare a node current and set it as a head pointer
      Node current = head;
      // Use while loop to traverse the whole list nodes
      while (current != null)
      {
         // Increment the variable listSize everytime the next node is not null
         listSize++;
         // Move to the next node
         current = current.next;
      }
      // Return to where it's called
      return listSize;      
   }
   
   // Method isEmpty to check if the queue is empty
   public boolean isEmpty()
   {
      // Use if-else statement to check if the size is 0, return true if it is, otherwise return false
      if (size() == 0)
      { 
         return true;
      }
      else 
      {
         return false;
      }
   }
   
   // Method to print out the elements in the queue
   public void printQueue() 
   {
      // Declare a temporary node to traverse the queue
      Node temp;
      // Set head to temp to start traversal from the head of the queue
      temp = head;
      // Use while loop to traverse through the queue until the end (null node) is reached
      while (temp != null)
      {
         // Print the data of each node followed by a space
         System.out.print(temp.data + " ");
         // Move to the next node in the queue
         temp = temp.next;
      }
      // Print a new line for spacing
      System.out.println();
   }
  
}


      
   
   
   