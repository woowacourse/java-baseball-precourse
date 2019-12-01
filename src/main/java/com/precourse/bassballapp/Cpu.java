package com.precourse.bassballapp;

public class Cpu {
	static int[] answerArr;
	
	static int getRandomNum() {		//1~9사이 정수 랜덤생성
		return (int) (Math.random() * 9) + 1;
	}
	
	static int[] makeAnswer() {
		int[] result = new int[3];
		
		result[0] = getRandomNum();
		
		int tmpVal1 = getRandomNum();
		while(tmpVal1 == result[0]) {
			tmpVal1 = getRandomNum();
		}
		result[1] = tmpVal1;
		
		int tmpVal2 = getRandomNum();
		while(tmpVal2 == result[0] || tmpVal2 == result[1] ) {
			tmpVal2 = getRandomNum();
		}
		result[2] = tmpVal2;
		
		return result;
	}
}
