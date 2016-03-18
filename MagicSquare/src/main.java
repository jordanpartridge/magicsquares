import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import logic.*;

public class main {
	public static void main(String args[]) throws IOException{
	    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter numbers for magic square:");
		// has to captures values as Strings initially 
		String[] values = stdin.readLine().split("\\s+");
		magicSquare squares = new magicSquare(values);
		System.out.println("TESTING: DUPICATES " + squares.validateDupicates());
		System.out.println("TESTING: validateN " + squares.validateN());
		
	}

}
