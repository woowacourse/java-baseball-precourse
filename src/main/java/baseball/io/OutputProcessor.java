package baseball.io;

import baseball.Results;

public class OutputProcessor {
	private OutputProcessor() {}

	public static void printResult(Results results) {
		System.out.println(results);
	}

	public static void printCorrect() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
