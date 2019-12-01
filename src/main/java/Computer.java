package main.java;

public class Computer {
	
	int[] com_arr = new int[3];			// 3개의 수를 저장할 배열 정의
	
	public int[] make_list() {
	
		for (int i=0; i<3; i++) {
			int random_number = (int) (Math.random() * 9) + 1;			// 1~9 랜덤 넘버를 생성하고 저장하기 3번 반복
			com_arr[i] = random_number;
		}
		
		return com_arr;			// 배열 리턴
	}
}
