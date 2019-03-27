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
		int[] answer = new int[3];
		
		for(int i = 1; i < 10; i++) {
			nums.add(i);
		}
		
		int count = -1;
		for(int i = nums.size(); i > 6; i--) {
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
		
		for(int i = 0; i < 3; i++) {
			playerNums[i] = inputStr.charAt(i) - '0';
		}
		return playerNums;
	}
	
	/* 해당 정수가 해당 int[]에 들어있는지 알려주는 메서드
	 * ex) isInArray(3, {4, 3, 2}) --> return true
	 * 	   isInArray(1, {2, 5, 6}) --> return false */
	public static boolean isInArray(int num, int[] numArray) {
		for(int i : numArray) {
			if(num == i) {
				return true;
			}	
		}
		return false;
	}
	
	/* 정답과 플레이어가 입력한 값을 비교하고
	 * 스트라이크와 볼의 개수를 Array에 저장하는 메서드
	 * ex) countStrikeBall({4, 6, 2}, {4, 3, 2})
	 *     --> return {2, 1} */
	public static int[] countStrikeBall(int[] answer, int[] playerNums) {
		int strike = 0;
		int ball = 0;
		
		for(int i = 0; i < 3; i++) {
			if(playerNums[i] == answer[i]) {
				strike++;
			} else if(isInArray(playerNums[i], answer)) {
				ball++;
			}
		}
		int[] strikeBallCount = {strike, ball};
		return strikeBallCount;
	}
	
	/* countStrikeBall()에서 얻은 Array를 바탕으로 결과를 출력한다.
	 * 정답을 맞췄을 경우 true, 정답이 아닐경우 false을 리턴한다.
	 * ex) printCount({1, 2})
	 *     출력문: 1 스트라이크 2볼
	 *     --> return false */
	public static boolean printCount(int[] strikeBallCount) {
		int strike = strikeBallCount[0];
		int ball = strikeBallCount[1];
		
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;	
		}
		
		String count = "";
		count += strike != 0 ? (strike + " 스트라이크 ") : "";
		count += ball != 0 ? (ball + "볼") : ""; 
		System.out.println((count.equals("")) ? "낫싱" : count);
		return false;
	}
	
	/* 게임을 실행하는 메서드 */
	public static void playGame() {
		int[] answer = createProblem();
		boolean checkAnswer = false;
		
		while(!checkAnswer) {
			checkAnswer = printCount(countStrikeBall(answer, inputNums()));
		}
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		while(true) {
			int checkEnd = scan.nextInt();
			if(checkEnd == 1) {
				playGame();
			} else if(checkEnd == 2) {
				System.out.println("게임을 종료합니다.");
				return;
			} else {
				System.out.println("잘못 입력하셨습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			}
		}
	}
	
	/* 게임이 실행되는 공간 */
	public static void main(String[] args) {
		playGame();
	}
}