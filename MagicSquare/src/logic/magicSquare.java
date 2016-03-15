package logic;
/* file: magicSquare.java
 * Description: Serves as the main execution class for project 1 in SER216
 * @author Jordan Partridge
 * 
 * 
 * 
 */

import java.util.HashSet;
import java.util.Set; 
public class magicSquare {
	private int[] numbers;
	private final int N; 
	private final int SIZE;
	public magicSquare(String[] values){
		this.setNumbers(this.convertInt(values));
		this.N = (int) Math.sqrt(values.length);
		this.SIZE = values.length;
	}
	
	
	/*
	 * Returns True if no duplicates are found used as a factor to determine if values represent
	 * a valid magic square
	 */
	public  boolean validateDupicates(){
		 Set<Integer> set = new HashSet<Integer>();
		  for (int i : this.getNumbers())
		  {
		    if (set.contains(i)) return false;
		    set.add(i);
		  }
		  return true;
	}
	public boolean validateN(){
		boolean ret = false;
		if(SIZE % N == 0) ret = true;
		return ret;
	}
	public  int[] convertInt(String[] value){
	  int ret[] = new int[value.length];
	  for(int i = 0; i < value.length; i++){
		  ret[i] = Integer.parseInt(value[i]);
	  }
	  
	  return ret;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}
