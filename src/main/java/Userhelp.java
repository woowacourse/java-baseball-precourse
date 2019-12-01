package main.java;

public class Userhelp {
	
	
	public int exception(int number) {			// 예외(에러)처리
		int error = 0;			// 에러 기본값 0 (에러 없음)
		
		if (number < 111 || number > 999) {			// 1에서 9까지의 세자리 수가 아닌 경우
			error = 1;
		}
		if (Integer.toString(number).indexOf("0") != -1) {			// 숫자에 0이 포함된 경우
			error = 2;
		}
		
		return error;			// 에러값 리턴
	}
	
	public int[] num_to_arr(int num) {			// 숫자를 array 형태로 변환
		
		int[] user_arr = new int[3];			// 새로운 array 생성
		int div_num = 100;			// 나누는 값 100으로 기본 설정
	
		for (int i=0; i<3; i++) {
			user_arr[i] = num / div_num;			// 숫자를 div_num으로 나눈 몫 저장
			num -= user_arr[i]*div_num;			// 숫자에서 위의 값 제거
			div_num /= 10;			// div_num 10으로 나눠 자릿수 옮기기
		}
		return user_arr;			// array 리턴
	}
}