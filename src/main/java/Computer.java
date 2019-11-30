package main.java;

public class Computer {
	
	int[] com_arr = new int[3];
	
	public int[] make_list() {
	
		for (int i=0; i<3; i++) {
			int random_number = (int) (Math.random() * 9) + 1;
			com_arr[i] = random_number;
		}
		
		return com_arr;
	}
}
