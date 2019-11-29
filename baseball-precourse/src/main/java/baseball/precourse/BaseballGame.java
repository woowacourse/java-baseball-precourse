package baseball.precourse;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> answer;
	static Random rand = new Random();
	static int strike = 0, ball = 0;
	static int[] userNum = new int[3];

	public static void main(String args[]) {
		GameStart();
	}

	// 게임 실행 함수
	public static void GameStart() {

		AnswerNumber();
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			int user = sc.nextInt();
			sc.nextLine();
			classification(user);
		}

	}

	// 유저 입력 데이터 한 개씩 userNum에 적용
	public static void classification(int user) {
		int cnt = 2;
		while (cnt >= 0) {
			userNum[cnt--] = user % 10;
			user /= 10;
		}
		judgement();
	}

	// 스트라이크, 볼 계산 함수
	public static void judgement() {
		strike = ball = 0;
		for (int i = 0; i < 3; i++) {
			if (answer.contains(userNum[i])) {
				CheckResult(i);
			}
		}
		Result();
	}

	// 실제로,인덱스 동일 여부 에따라 스트라이크 볼 더해주는 함수
	public static void CheckResult(int userIndex) {

		if (answer.get(userIndex) == userNum[userIndex])
			strike++;
		else
			ball++;

	}

	// 스트라이크 볼에 따른 결과 출력
	public static void Result() {

		if (strike == 3) {
			AllStrike();
			return;
		}
		
		if (ball != 0)
			System.out.printf("%d볼  ", ball);
		if (strike != 0)
			System.out.printf("%d 스트라이크", strike);
		if(strike== 0&& ball==0)
			System.out.print("낫싱");

		System.out.println();

	}

	// 정답 시에 게임 종료,재시작 여부 수행
	public static void AllStrike() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요");
		int user = sc.nextInt();

		if (user == 1)
			GameStart();
		else
			System.exit(0);

	}

	// 정답(컴퓨터) 숫자 설정 및 중복 검사 메소드
	public static void AnswerNumber() {
		answer = new ArrayList<Integer>();
		int n;
		while (answer.size() < 3) {
			 n= rand.nextInt(9) + 1;
			if (!answer.contains(n)) {
				answer.add(n);
			}
		}

	}
}
