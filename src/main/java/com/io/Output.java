package com.io;

public class Output {
	private static final String REQUIRE_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String REQUIRE_RESTART_NUMBER_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String INPUT_NUMBER_SIZE_EXCEPTION_MESSAGE = "세자리 숫자를 입력해주세요.";
	public static final String INPUT_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자가 존재해요.";
	public static final String INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE = "1 ~ 9까지 숫자만 입력해주세요.";
	public static final String OPTION_NUMBER_NULL_EXCEPTION_MESSAGE = "입력 값은 NULL이 될 수 없어요.";
	public static final String OPTION_NUMBER_SIZE_EXCEPTION_MESSAGE = "입력은 1 또는 2만 가능합니다.";
	public static final String CORRECT_ANSWER_AND_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String PLAY_GAME_EXIT_MESSAGE = "게임 종료";
	public static final String RESULT_NOTHING_MESSAGE = "낫싱";
	public static final String RESULT_STRIKE_MESSAGE = "스트라이크";
	public static final String RESULT_BALL_MESSAGE = "볼";

	public static void printRequestNumberInput() {
		System.out.println(REQUIRE_NUMBER_INPUT_MESSAGE);
	}

	public static void printRequestRestartNumberInput() {
		System.out.println(REQUIRE_RESTART_NUMBER_INPUT_MESSAGE);
	}

	public static void printBaseballGameResult(String result) {
		System.out.println(result);

	}

	public static void printExceptionMessage(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

}
