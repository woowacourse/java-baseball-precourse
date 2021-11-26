package baseball;

public class Message {
	static final String BALL = "볼 ";
	static final String STRIKE = "스트라이크";
	static final String NOTHING = "낫싱";

	static final String REQUEST_ENTER_NUMBER = "숫자를 입력해주세요 : ";
	static final String GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	static final String REQUEST_RESTART_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	static final String EXIT_GAME = "감사합니다! 게임을 종료합니다.";

	static final String ERROR_INPUT_LENGTH = "올바른 길이의 숫자를 입력해주세요. 올바른 길이는 " + Rules.NUMBER_LENGTH + "입니다.";
	static final String ERROR_INPUT_TYPE = "1~9까지의 정수를 입력해주세요";
	static final String ERROR_INPUT_DUPLICATE = "중복되지 않은 값으로 입력해주세요";
	static final String ERROR_REQUEST_INPUT = "재시작을 위해서 1 혹은 2를 입력해주세요";
}
