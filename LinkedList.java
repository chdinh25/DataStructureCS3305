/*
This class define a linked list that stores integer values.
*/
// Define LinkedList class
public class LinkedList
{
   public Node head, tail;
     
   //constructor method to create a list of object with head, tail, and size. 
   public LinkedList()
   {
      head = null;
      tail = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      Node newNode = new Node(data);
      if (tail == null)
      { 
         head = tail = new Node(data); //empty list
      }
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   // Method #1: Add a first node to teh list
   // This method using data from user as a parameter
   public void addFirstNode(int data)
   {
      // Create a new node with the data that passed as an arguement
      Node newNode = new Node(data);
      
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
      
   //Method #2: Add node at a specific index to the list
   // This method use user input's index and data as parameters
   public void addAtIndex(int index, int data)
   {
      // If the index is 1    
      if (index == 1)
      {
         // Call addFirstNode method to add the node at the beginning
         addFirstNode(data);
      }
      else
      {
         // Create a new node with the data that passed as an arguement
         Node newNode = new Node(data);
         // Declare a node current and set it as a head pointer
         Node current = head;
         
         // Use for loop to traverse the list to the given index - 1
         for (int i = 1; i < index -1; i++)
         {
            // Traverse to the node before the given index
            current = current.next;
         }
         // Link the new node to the next node
         newNode.next= current.next;
         // Set the current node to the next pointer
         current.next = newNode;
      }   
   }
      
   // Method #3: Remove first node from the list
   public void removeFirstNode()
   {
      // If the list is not empty
      if (head != null)
      {
         // Set the head pointer to the next node
         head = head.next;
      }
      else
      {
         // Display the message for empty list
         System.out.println("List is Empty");
         // Display a blank line for spacing
         System.out.println();
      }
   }
      
   // Method #4: Remove last node from the list
   public void removeLastNode()
   {
      // If list is empty, display an error message
      if (head == null)
      {
         // Display the message for empty list
         System.out.println("List is Empty");
         // Display a blank line for spacing
         System.out.println();
      }
      // iIf the list have one node, 
      else if (head == tail)
      {
         // Set head and tail to null
         head = tail = null;
      }
      else
      {
         // Declare node current and set it to head pointer
         Node current = head;
         // Use while loop to traverse to list to the node before the the last node
         while (current.next != tail)
         {
            // Traverse the list to the node before the last node
            current = current.next;
         }
         // Remove the link to the last node
         current.next = null;
         // Update the tail pointer by setting it to the new last node
         tail = current;
      }
   }
    
   // Method #5: Remove node at a specific index from the list
   public void removeAtIndex(int index)
   {
      // Display error message if the list is empty
      if (head == null)
      {
         // Display the message for empty list
         System.out.println("List is Empty");
         // Display a blank line for spacing
         System.out.println();
         return;
      }
      // If index is 1
      if (index == 1)
      {
         // Call removeFirstNode method to remove the first node from the list
         removeFirstNode();
      }
      // If index equal to the last node's index
      else if (index == countNodes())
      {
         // Call removeLastNode method to remove the last node from the list
         removeLastNode();
      }
      else
      {
         // Declare a node current and set it to the head pointer
         Node current = head;
         // Use for loop to traverse the list to the given index - 1
         for (int i = 1; i < index - 1; i++)
         {
            // Traverse to the node before the given index
            current = current.next;
         }
         // Remove the link to the node at the specified index
         current.next = current.next.next;
      }
   }
          
   // Method #6: Method to count the numbers of nodes in the list.
   // This method return the listSize of the list
   public int countNodes()
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
   
   // Method #7: Method print the list in reverse order using recursive method.
   // This method use the head pointer of the list as a parameter
   public void printInReverse(Node current)
   {
      // Base case: the list is empty
      if (current == null)
      {
         // Stop the recursion as the current is null
         return;
      }
      // If the list is not empty
      else
      {
         // Print the rest of the list recursively
         printInReverse(current.next);
         // Display the current node's data
         System.out.print(current.data + " ");
      }
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = head;
      while (temp != null)
      {
         System.out.print(temp.data + " ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

