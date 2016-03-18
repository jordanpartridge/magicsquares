import logic.MagicSquare;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UiMagicSquare {
  /** main method for application execution.
   * @param args command line args
   * @throws IOException since scanner is used there is a risk of IOException
   */
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    String intergerValue = scanner.nextLine () ;
    Scanner scanLine = new Scanner ( intergerValue );
    int[] intArray = new int[500];
  //add each element to intArray of course converting Strings to int
    scanLine.useDelimiter ( "[^A-Za-z0-9_]+" ) ;
    int elementCount = 0;
    while (scanLine.hasNext ()) {	  
      try {
        intArray[elementCount] = Integer.parseInt ( scanLine.next () ) ;
      }
      catch (NumberFormatException invalidInput) {
        System.out.println("invalid input, input should be Integers");
        break;
      }
      elementCount++ ;
    }
    MagicSquare magic = new MagicSquare(intArray, elementCount);

    scanLine.close();
    scanner.close();
  }
}