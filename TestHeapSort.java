public class TestHeapSort { 
   /** A test method */
   public static void main(String[] args) {
    
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
      
      // Add 2 lists to test TestHeapSort class
      // List 2 content all characters
      Character[] list2 = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};
      // List 3 contents String
      String[] list3 = {"Class", "Study", "Data", "Computing", "hard", "Structures,", "to pass."};

      // Sort and print list
      System.out.print("\n\nOriginal List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   
      HeapSort.heapSort(list);  //sort the list
      System.out.print("\n\nSorted List:\t");  //print sorted list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   
         
      // Sort and print list2
      System.out.print("\n\nOriginal List2:\t"); //print original list
      // Use for loop to travers the heap and display heap content before soring
      for (int i = 0; i < list2.length; i++)
      {
         System.out.print(list2[i] + " ");
      }
      // Call heapSort() method to sort the list and pass list2 as parameter
      HeapSort.heapSort(list2); 
      System.out.print("\n\nSorted List2:\t   "); //print sorted list
      // Use for loop to travers the heap and display heap content after sorting
      for (int i = 0; i < list2.length; i++)
      {
         System.out.print(list2[i] + " ");
      }

      // Sort and print list3
      System.out.print("\n\nOriginal List3:\t"); //print original list
      // Use for loop to travers the heap and display heap content before sorting
      for (int i = 0; i < list3.length; i++)
      {
         System.out.print(list3[i] + " ");
      }
      // Call heapSort() method to sort the list and pass list3 as parameter
      HeapSort.heapSort(list3);
      System.out.print("\n\nSorted List3:\t   "); //print sorted list     
      // Use for loop to travers the heap and display heap content after sorting
      for (int i = 0; i < list3.length; i++)
      {
         System.out.print(list3[i] + " ");
      }         
   }
}
