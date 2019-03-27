/*
 * BaseballGame
 * 
 * 2019.03.27
 * 
 * 이 프로그램은 누구든 수정가능합니다.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * 숫자 야구 게임!
 *
 * @version 1.00 2019.03.27
 * @author 김형선
 */

public class BaseballGame {
	/* 숫자 야구 게임 */
	static Random random = new Random();
	static Scanner scan = new Scanner(System.in);

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
		for(int i=nums.size(); i>6; i--) {
			count++;
			int RanIndex = random.nextInt(i);
			answer[count] = nums.remove(RanIndex);
		}
		return answer;
	}
	
	/* 사용자에게 3자리 수를 입력받아 int[]로 반환하는 메서드
	 * ex) 입력값 : 315-> return {3, 1, 5} */
	public static int[] inputNums() {
		int[] playerNums = new int[3];
		System.out.println("숫자를 입력해 주세요 :");
		String inputStr = scan.next();
		for(int i=0; i<3; i++) {
			playerNums[i] = inputStr.charAt(i) - '0';
		}
		return playerNums;
	}
	
	/* 테스트 코드 */
	public static void main(String[] args) {
		int[] answer = createProblem();
		for (int i : answer) {
			System.out.println(i);
		}
		int[] input = inputNums();
		for (int j : input) {
			System.out.println(j);
		}
	}
}