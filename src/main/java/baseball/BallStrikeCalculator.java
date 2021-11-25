package baseball;

import java.util.ArrayList;

public class BallStrikeCalculator {

	public String calculate(String gameInputNumber, String targetNumber) {
		String answer = "";

		// 볼, 스트라이크 개수 변수
		int ball = 0;
		int strike = 0;

		ArrayList<Character> targetNumberList = new ArrayList<>();
		for (char c : targetNumber.toCharArray()) {
			targetNumberList.add(c);
		}

		// targetNumber 에 존재한다면 ball++
		for (int i = 0; i < 3; i++) {
			char c = gameInputNumber.charAt(i);

			if (targetNumberList.contains(c)) {
				ball++;
			}
		}

		// gameInputNumber 의 각 숫자가 targetNumber 위치와 동일하면 ball-- 그리고 strike++
		for (int i = 0; i < 3; i++) {
			char c = gameInputNumber.charAt(i);

			if (targetNumberList.get(i) == c) {
				ball--;
				strike++;
			}
		}

		// 볼, 스트라이크 변수로 메시지 문자열 생성
		answer = makeMassage(ball, strike);
		return answer;
	}

	public String makeMassage(int ball, int strike) {
		String answer = "";

		// 볼, 스트라이크가 하나도 없는 경우
		if (ball == 0 && strike == 0) {
			return "낫싱";
		}

		// 볼, 스트라이크 개수로 메시지 문자열 생성
		StringBuilder sb = new StringBuilder();
		if (ball != 0) {
			sb.append(ball + "볼");
		}
		if (strike != 0) {
			sb.append(" " + strike + "스트라이크");
		}

		answer = sb.toString().trim();
		return answer;
	}
}
