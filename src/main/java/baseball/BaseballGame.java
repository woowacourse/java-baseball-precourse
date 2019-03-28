package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {
	/**
	 * 컴퓨터가 선택한 '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'를 리스트에 담는 함수
	 * 
	 * @return 	: '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'로 이루어진 리스트 반환.
	 */
	public List<Integer> question() {
		List<Integer> questionNums = new ArrayList<Integer>();
		Random rd = new Random();
		
		for (int i=0; i<3; i++) {
			int num = rd.nextInt(9)+1;
			questionNums.add(num);
			System.out.println(num+","); /* 확인용 출력  */
		}
		System.out.println(); /* 확인용 출력  */
		return questionNums;
	}
	
	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		game.question(); /* 확인용 실행  */
	}
}
