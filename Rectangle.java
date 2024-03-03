// Define Rectangle class
public class Rectangle
{
   // Declare 2 private data fields named width and height
   // to store the rectangle width and height respectively 
   private double width;
   private double height;
   
   // Non-argument contructor creates a default rectangle with 
   // a default value of 1.00 unit wide and 1.00 unit high
   public Rectangle()
   {
      // Initialize width and height with default values
      width = 1.00;
      height = 1.00;
   }
   
   // Contructor creates a rectangle with specific width and height passed form the test program
   public Rectangle(double width, double height) 
   {
   
      // Set the object width and height to the provided values
      this.width = width;
      this.height = height;
   }
   
   // Getter method for reading the width value
   public double getWidth()
   {
      return width;
   }
   
   // Getter method for reading the height value
   public double getHeight()
   {
      return height;
   }
   
   // Method to calculate and return the return the area of the rectangle
   public double getArea()
   {
      return width * height;
   }
   
   // Method to calculate and return the return the perimeter of the rectangle
   public double getPerimeter()
   {
      return (width + height) * 2;
   }
   
   // Method to display the description of a rectangle object that use the object name as a parameter
   public void printRectangle(String objectName)
   {
      // Display the output
      System.out.printf("Rectangle %s is %.2f units wide and %.2f units high.%n", objectName, width, height);
   }
}