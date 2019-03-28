package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	/**
	 * 컴퓨터가 선택한 '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'를 리스트에 담는 함수
	 * 
	 * @return 	: '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'로 이루어진 리스트 반환.
	 */
	public List<Integer> question() {
		List<Integer> questionNums = new ArrayList<Integer>();
		
		for (int i=0; i<3; i++) {
			/* 
			 * 다른 자리의 수와 '중복되지 않는 1~9사이의 수'를 추출 - 함수: noOverlap
			 * 수를 '리스트에 할당'
			 */
			int num = noOverlap(questionNums);
			questionNums.add(num);
			System.out.print(num+","); /* 확인용 출력  */
		}
		System.out.println(); /* 확인용 출력  */
		return questionNums;
	}
	
	/**
	 * 다른 자리의 수와 '중복되지 않는 1~9사이의 수'를 추출하는 함수 (1개의 숫자)
	 * 
	 * @param	: 컴퓨터가 선택한 수가 담긴 리스트. 중복되는 값이 있는 지 확인 할 때 사용됨. 
	 * @return 	: 중복되지 않는 1~9사이의 수
	 */
	private int noOverlap(List<Integer> questionNums) {
		Random rd = new Random();
		int num = 0;
		
		while (true) {
			num = rd.nextInt(9)+1;

			/* 랜덤값이 리스트에 포함(기존의 수와 중복)되지 않으면  while문 종료.*/
			if (!questionNums.contains(num)) {
				break;
			}
		}
		return num;
	}
	
	/**
	 * 유저가 입력한 '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'를 리스트에 담는 함수 
	 * 
	 * @return 	: '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'로 이루어진 리스트
	 */
	public List<Integer> user() {
		List<Integer> userNums = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		String nums = sc.nextLine();
		
		/* 리스트에 각 자리수 추가 */
		for (int i=0; i<nums.length(); i++) {
			int num = nums.charAt(i)-48;
			userNums.add(num);
			System.out.print(num+","); /* 확인용 출력  */
		}
		System.out.println(); /* 확인용 출력  */
		return userNums;
	}
	
	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		game.question(); /* 확인용 실행  */
		game.user(); /* 확인용 실행  */
	}
}
