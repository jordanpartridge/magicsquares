package logic;

public class MagicSquare {
   
   
  private static int[][] magicSquare ;
  private static int[] intArray;
  private static int N;
  private static int k;
    
  /**
 * @param input.
 * @param elementCount.
 */
  public MagicSquare(int[] input, int elementCount) {
    /*
    * adds value to the matrix at the given position, row,col
    */
    if (elementCount < 1) {
      System.out.println("false");
    } else {
      intArray = input;
      N = (int) Math.sqrt(elementCount);
      magicSquare = createMatrix(intArray);

      if (verfiyInput(N) && elementCount == N * N) {
        if (isMagic())  {
          System.out.println("true");

        } else {
          System.out.println("false") ;
        }
      } else {
        System.out.println("Invaild parameter in input string") ;    
      }
    }
  }
    
  /**
   * createMatrix puts input from original int array into a 2d array for easier processing.
   * @param input - int array of inputed values
   * @return ret 2d array matrix of inputed values
   */
  public static int[][] createMatrix(int[] input) {
    int[][] ret = new int[N][N];

    for (int i = 0; i < N ; i++) {
      for (int j = 0; j < N; j++) {
        ret[i][j] = input[k] ;
        k++ ;
      }
    }
    return ret;
  }
  /**
    * Verify the input data.
    * @param nowRow make sure the input forms a square
    * @return ret
    */
  public boolean verfiyInput(int nowRow) {
    boolean ret = true;
    for (int i = 0; i < nowRow ; i++) {
      for (int j = 0; j < nowRow; j++) {
        if (magicSquare[i][j] > nowRow * nowRow || magicSquare[i][j] < 1) {
          ret = false;
        }
      }
    }
    return ret ;
  }
    
  /**
     * This method will check for Duplicates.
     */
    
  public static boolean checkForDuplicates() {
    int numcheck = 1;
    boolean found = false;
    while (numcheck < magicSquare.length * magicSquare.length) {
      for (int i = 0; i < magicSquare.length;i++) {
        for (int j = 0; j < magicSquare.length; j++) {
          if (magicSquare[i][j] == numcheck) {
            found = true;
          }
        }
      }
      if (!found) {
        return false; 
      }
      found = false;
      numcheck++;
    }
    return true;
  }
    
  /** isMagic will return true if the input represents a valid magicSquare.
    * @return ret
    */
  public boolean isMagic() {
    int initialSum = 0 ;
    boolean ret = false;
    for (int c = 0; c < N; c++) {
      initialSum += magicSquare[0][c] ;
    }
    if (verifyRowAndColumn(initialSum) == true 
        && diagonalLeft(initialSum) == true
        && diagonalRight(initialSum) == true
        && checkForDuplicates() == true) {
      ret = true ;
    } else {
      ret = false;
    }
    return ret;
  }
    
  /**
    * This method will check Left diagonal.
    * @param testNumber - the number that will be compared to the Diagonal sums
    * @return boolean ret
    */
    
  public static boolean diagonalLeft(int testNumber) {
    int sum = 0 ;
    boolean ret = false;
    for (int d = 0; d < N; d++) {
      sum = sum + magicSquare[d][(magicSquare.length - 1) - d] ;
    }
    ret =  (sum == testNumber) ;
    return ret;
  }
  
  /**
    * This method will check diagonal Right
    * @param testNumber the initial figure to compare all rows and column sums to.
    * @return boolean result of whether or not the testNumber is equal to the sum.
    */
  public static boolean diagonalRight(int testNumber) {
    int sum = 0 ;
    for (int d = 0; d < N; d++) {
      sum = sum + magicSquare[d][d] ;
    }
    return (sum == testNumber) ;
  }
    
  
    
  
  /**  verifyRowAndColumns test to ensure all rows and columns have the same sum.
   * @param  testNumber - the number that is tested against all rows and columns
   *     the intial row or column.
   * @return boolean ret
   */ 
  public static boolean verifyRowAndColumn(int testNumber) {
    int rowsum = 0;
    int colsum = 0;
    boolean ret = true;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < magicSquare[0].length; j++) {
        rowsum = rowsum + magicSquare[i][j];
        colsum = colsum + magicSquare[j][i];
      }
      if (rowsum != testNumber || colsum != testNumber) {
        ret = false; 
      }
      rowsum = 0; 
      colsum = 0; 
    }
    return ret; 
  }
    
  
}
