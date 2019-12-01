package main.java;

public class Matching {
	public int strike(int[] com_arr, int[] user_arr) {
		
		int strike = 0;
		
		for (int i=0; i<3; i++) {
			if (user_arr[i] == com_arr[i]) {
				strike += 1;
			}
		}
		
		return strike;
	}
	
	public int ball(int[] com_arr, int[] user_arr) {
		int ball = 0;
		int[] com_arr_tmp = com_arr.clone();
		int strike = strike(com_arr, user_arr);
		
		for (int i=0; i<3; i++) {
			if (user_arr[0] == com_arr_tmp[i]) {
				ball += 1;
				com_arr_tmp[i] = 0;
				continue;
			}
			if (user_arr[1] == com_arr_tmp[i]) {
				ball += 1;
				com_arr_tmp[i] = 0;
				continue;
			}
			if (user_arr[2] == com_arr_tmp[i]) {
				ball += 1;
				com_arr_tmp[i] = 0;
				continue;
			}
		}
		
		return ball-strike;
	}
}
