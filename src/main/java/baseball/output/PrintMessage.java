package baseball.output;

public enum PrintMessage{
	REQUEST_BASEBALL_NUMBER_INPUT_MESSAGE("숫자를 입력해주세요 : "),
	REQUEST_RESTART_NUMBER_INPUT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	USER_BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE("세자리 숫자를 입력해주세요."),
	USER_BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE("중복된 숫자가 존재해요."),
	USER_BASEBALL_NUMBER_FORMAT_EXCEPTION_MESSAGE("1 ~ 9까지 숫자만 입력해주세요."),
	RESTART_NUMBER_NULL_EXCEPTION_MESSAGE("재시작 입력 값은 NULL이 될 수 없어요."),
	RESTART_NUMBER_FORMAT_EXCEPTION_MESSAGE("재시작 입력 값은 1 또는 2만 가능해요."),
	CORRECT_ANSWER_AND_EXIT_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	PLAY_GAME_EXIT_MESSAGE("게임 종료"),
	RESULT_NOTHING_MESSAGE("낫싱"),
	RESULT_STRIKE_MESSAGE("스트라이크"),
	RESULT_BALL_MESSAGE("볼");

	private final String message;

	PrintMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
