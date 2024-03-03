// Define a generic class named PQ_heap that uses elements of type E, which must be comparable.
public class PQ_Heap<E extends Comparable<E>>
{	
   // Declare a private instance variable "heap" of type Heap, which will store the elements of the priority queue.
   private Heap<E> heap;
	// Constructor for the PQ_heap class. It initializes the "heap" variable by creating a new instance of the Heap class.
   public PQ_Heap() 
   {
      this.heap = new Heap<>();
   }
	
	// Return true if priority queue is empty; otherwise return false
   public boolean is_empty() 
   {
      // Returns true if the size of the heap is 0, indicating that the priority queue is empty. Otherwise, it returns false.
      return heap.getSize() == 0;
   }
	
	// Return true if priority queue is full; otherwise return false
   public boolean is_full() 
   {
      // Return true if the priority queue is full; otherwise return false
      return heap.getSize() >= Heap.CAPACITY;
   }

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public E front() 
   {
      // If the priority queue is empty, it prints an empty message.    
      if (is_empty()) 
      {
         System.out.println("Queue is empty.");
      }
      // Otherwise, call get() method to get element at index 0 and return it without removing it. 
      return heap.list.get(0);
   }

	// Return number of elements in the queue, without removing it
   public int size() 
   {
      // Returns the number of elements currently in the priority queue.
      return heap.getSize();
   }
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public E dequeue() 
   {
      // If the priority queue is empty, it prints an empty message.   
      if (is_empty()) 
      {
         System.out.println("Queue is empty.");
      }
      // Removes and returns the largest value from the priority queue.
      return heap.remove();
   }

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   // This method use value from user input as parameter
   public void enqueue(E value) 
   {
      // If the priority queue is empty, it prints an empty message.   
      if (is_full()) 
      {
         System.out.println("Queue is full.");
      }
      // Call add() method to inserts the given 'value' into the queue.
      heap.add(value);
   }
   
   // Display the priority queue content in a structured format.
   public void display() 
   {
      // Declare and initialize 2 variables, 'level' and 'index' to keep track of the current level and index of elements in the heap.
      int level = 0;
      int index = 0;
      
      // Call getSize() method to get the heap size.
      // Use while loop to traverse the heap, continues as long as the 'index' is less than the current size of the heap.
      while (index < heap.getSize()) 
      {
         // Calculate the number of elements in the current level of the heap using 2^level formula.
         int elementsInLevel = (int) Math.pow(2, level);
         
         // Use for loop iterates through the elements in the current level and ensures that the index is within the heap current size.
         for (int i = 0; i < elementsInLevel && index < heap.getSize(); i++) 
         {
            // Display the index of the current element.
            System.out.print("Index " + index + ":  ");
            // Display the value of the current element in the heap.
            System.out.print(heap.list.get(index) + "  ");
            
            // Calculate the indices of the left and right child element
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            
            // If the left child index is within the heap's size, display the value of the left child.
            if (leftChildIndex < heap.getSize()) 
            {
               System.out.print(heap.list.get(leftChildIndex) + "  ");
            }
            
            // If the right child index is within the heap's size, display the value of the right child.
            if (rightChildIndex < heap.getSize()) 
            {
               System.out.print(heap.list.get(rightChildIndex) + "  ");
            }
            // Move to the next line for the next element.
            System.out.println();
            // Move to the next element in the heap
            index++;
         }
         // Move to the next level in the heap
         level++;
      }
   }    
}
