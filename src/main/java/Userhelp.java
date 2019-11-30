package main.java;

public class Userhelp {
	
	
	public int exception(int number) {
		int error = 0;
		
		if (number < 111 || number > 999) {
			error = 1;
		}
		if (Integer.toString(number).indexOf("0") != -1) {
			error = 2;
		}
		
		return error;
	}
	
	public int[] num_to_arr(int num) {
		
		int[] user_arr = new int[3];
		int div_num = 100;
	
		for (int i=0; i<3; i++) {
			user_arr[i] = num / div_num;
			num -= user_arr[i]*div_num;
			div_num /= 10;
		}
		return user_arr;
	}
}