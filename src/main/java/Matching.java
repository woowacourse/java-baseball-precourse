package main.java;

public class Matching {
	public int strike(int[] com_arr, int[] user_arr) {
		
		int strike = 0;			// 스트라이크 기본 값 0으로 셋팅
		
		for (int i=0; i<3; i++) {
			if (user_arr[i] == com_arr[i]) {			// 유저와 컴퓨터의 같은 배열 위치에 같은 값이 있으면
				strike += 1;			// 스트라이크 값에 1 더하기
			}
		}
		
		return strike;			// 스트라이크 값 리턴
	}
	
	public int ball(int[] com_arr, int[] user_arr) {
		int ball = 0;			// 볼 기본 값 0으로 셋팅
		int[] com_arr_tmp = com_arr.clone();			// 컴퓨터 배열을 클론하여 값이 바뀌어도 영향이 가지 않게 함
		int strike = strike(com_arr, user_arr);			// 스트라이크 값 받기
		
		for (int i=0; i<3; i++) {
			if (user_arr[0] == com_arr_tmp[i]) {			// 유저의 첫번째 값과 같은 값이 있으면
				ball += 1;			// 볼 값에 1을 더하고
				com_arr_tmp[i] = 0;			// 컴퓨터 배열에서 해당 값을 0으로 바꾸기 (중복 카운트 방지)
				continue;
			}
			if (user_arr[1] == com_arr_tmp[i]) {			// 유저의 두번째 값도 마찬가지
				ball += 1;
				com_arr_tmp[i] = 0;
				continue;
			}
			if (user_arr[2] == com_arr_tmp[i]) {			// 유저의 세번째 값도 마찬가지
				ball += 1;
				com_arr_tmp[i] = 0;
				continue;
			}
		}
		
		return ball-strike;			// 볼 값에서 스트라이크 값을 빼고 리턴 (볼은 스트라이크도 포함하기 때문)
	}
}
