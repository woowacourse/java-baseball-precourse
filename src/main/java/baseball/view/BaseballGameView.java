package baseball.view;

import baseball.domain.Result;
import baseball.type.HintType;
import baseball.type.NumberRangeType;

public class BaseballGameView {

	private static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String SPACE = " ";

	public static void printRestartOrFinishGameMessage() {
		print(RESTART_MESSAGE);
	}

	public static void printResultOfGame(Result result) {
		print(selectResultMessage(result.getStrike(), result.getBall()));
	}

	private static String selectResultMessage(int strike, int ball) {
		if (strike == NumberRangeType.ANSWER_SIZE.getNumberRange()) {
			return getHintMessage(strike, HintType.STRIKE);
		}
		if (ball == NumberRangeType.ANSWER_SIZE.getNumberRange()) {
			return getHintMessage(ball, HintType.BALL);
		}
		if (strike > NumberRangeType.ZERO.getNumberRange() && ball > NumberRangeType.ZERO.getNumberRange()) {
			return getHintMessage(ball, HintType.BALL) + SPACE + getHintMessage(strike, HintType.STRIKE);
		}
		if (strike == NumberRangeType.ZERO.getNumberRange() && ball > NumberRangeType.ZERO.getNumberRange()) {
			return getHintMessage(ball, HintType.BALL);
		}
		if (strike > NumberRangeType.ZERO.getNumberRange() && ball == NumberRangeType.ZERO.getNumberRange()) {
			return getHintMessage(strike, HintType.STRIKE);
		}
		return HintType.NOTHING.getHint();
	}

	private static String getHintMessage(int count, HintType hint) {
		return count + hint.getHint();
	}

	public static void printInputPlayerNumber() {
		printWithOutNewline(INPUT_PLAYER_NUMBER_MESSAGE);
	}

	public static void printEndGame() {
		print(END_GAME_MESSAGE);
	}

	private static void print(String message) {
		System.out.println(message);
	}

	private static void printWithOutNewline(String message) {
		System.out.print(message);
	}

}
