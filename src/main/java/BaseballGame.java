/*
 * BaseballGame
 * 
 * 2019.03.25
 * 
 * 이 프로그램은 누구든 수정가능합니다.
 */

import java.util.ArrayList;
import java.util.Random;
/**
 * 숫자 야구 게임!
 *
 * @version 1.00 2019.03.25
 * @author 김형선
 */

public class BaseballGame {
	/* 숫자 야구 게임 */
	static Random random = new Random();

	/* 문제 생성  메서드
	 * 첫 번째 for문은 1~9 정수를 포함하는 ArrayList를 생성한다.
	 * 두 번쨰 for문은 1~9 정수 중 중복되지 않게 3개 수를 뽑는다.
	 * int[3] Array를 리턴한다.
	 * ex) return {6, 3, 9} */
	public static int[] createProblem() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1; i<10; i++) {
			nums.add(i);
		}
		int[] answer = new int[3];
		int count = -1;
		for(int i=9; i>6; i--) {
			count++;
			int RanIndex = random.nextInt(i);
			answer[count] = nums.remove(RanIndex);
		}
		return answer;	
	}
	/* 테스트 코드 */
	public static void main(String[] args) {
		int[] answer = createProblem();
		for (int i : answer) {
			System.out.println(i);
		}
	}
}