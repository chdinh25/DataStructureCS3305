// Import the neccesary Java utility package to use Scanner class
import java.util.Scanner;
// Define a class named TestRectangle
public class TestRectangle
{
   // Main method
   public static void main(String[] args)
   {
      // Declare a sanner object to read the user's input
      Scanner in = new Scanner(System.in);     
      
      // Create a default rectangle object
      Rectangle myRectangle = new Rectangle();
      
      // Call printInfo method to display the default rectangle description
      printInfo("myRectangle", myRectangle);
      
      // Prompt the user to enter values for the rectangle width and height,
      // and store it in yourWidth and yourHeight variables respectively  
      System.out.println("Please enter the width of the rectangle: ");
      double yourWidth = in.nextDouble();
      System.out.println("Please enter the height of the rectangle: ");
      double yourHeight = in.nextDouble();

      // Create a rectangle object with values specificed by user
      Rectangle yourRectangle = new Rectangle(yourWidth, yourHeight);
      
      // // Call printInfo method to display the rectangle object description
      printInfo("yourRectangle", yourRectangle);
      
      // Test all class functions and display information about the object
      System.out.println("Testing method getWidth() on object yourRectangle: " + yourRectangle.getWidth()); // Test getWidth() method and display the result
      System.out.println("Testing method getHeight() on object yourRectangle: " + yourRectangle.getHeight()); // Test getHeight() method and display the result
      System.out.println("Testing method getArea() on object yourRectangle: " + yourRectangle.getArea()); // Test getArea() method and display the result
      System.out.println("Testing method getPerimeter() on object yourRectangle: " + yourRectangle.getPerimeter()); // Test getPerimeter() method and display the result
   }
  
   // Method to display rectangle object description that use objectName and rectangle object as parameters
   public static void printInfo(String objectName, Rectangle rectangle)
   {
      System.out.println(objectName); // Display object name
      System.out.println("-------------");
      System.out.printf("Width:     %.2f%n", rectangle.getWidth()); // Display width of the object
      System.out.printf("Height:    %.2f%n", rectangle.getHeight()); // Display height of the object
      System.out.printf("Area:      %.2f%n", rectangle.getArea()); // Display area of the object
      System.out.printf("Perimeter: %.2f%n", rectangle.getPerimeter()); // Display perimeter of the object
      System.out.println();
      // Call printRectangle method to display the information of the object
      rectangle.printRectangle(objectName);
      System.out.println();
   }
}
      
   