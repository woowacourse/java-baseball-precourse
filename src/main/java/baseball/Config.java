package baseball;

public class Config {
	private final int BEGIN_NUM = 1;
	private final int END_NUM = 9;
	private final int NUM_LENGTH = 3;
	private final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
	private final String End_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private final String BALL = "볼";
	private final String STRIKE = "스트라이크";
	private final String NOTHING = "낫싱";

	public int getBeginNum() {
		return BEGIN_NUM;
	}

	public int getEndNum() {
		return END_NUM;
	}

	public int getNumLength() {
		return NUM_LENGTH;
	}

	public String getEnterNumber() {
		return ENTER_NUMBER;
	}

	public String getEnd_GAME() {
		return End_GAME;
	}

	public String getAskRestart() {
		return ASK_RESTART;
	}

	public String getBALL() {
		return BALL;
	}

	public String getSTRIKE() {
		return STRIKE;
	}

	public String getNOTHING() {
		return NOTHING;
	}
}
