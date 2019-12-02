public class Constant {
	/** 사용자, 컴퓨터가 갖는 숫자 배열의 길이. */
	static final int NUM_SIZE = 3;
	/** 사용자, 컴퓨터가 갖는 숫자 배열의 길이. */
	static final int CHECKLIST_SIZE = 10;
	/** 컴퓨터가 할당받는 랜덤 숫자의 범위 */
	static final int RAN_NUM_RANGE = 9;
	/** 아스키 값 1. 사용자가 입력한 수의 유효성 검사에 사용한다. */
	static final int ASCII_ONE = 49;
	/** 아스키 값 9. 사용자가 입력한 수의 유효성 검사에 사용한다. */
	static final int ASCII_NINE = 57;
	/** 사용자가 입력한 String을 int로 바꿀 때 사용한다. */
	static final char CHAR_ZERO = '0';
	
	/** 사용자가 입력한 수의 형식이 잘못되었을 때 출력하는 문자열들. */
	static final String STR_ZERO_EXCEPT = "0을 제외한 숫자만 입력해주세요.";
	static final String STR_LENGTH_THREE = "3자리의 수를 입력해주세요.";
	static final String STR_EACH_DIFF_NUM = "서로 다른 수로 이루어진 3자리 수를 입력해주세요.";
	/** 사용자가 입력한 수의 형식이 올바를 때 반환하는 빈 문자열 */
	static final String STR_EMPTY = "";
	/** 게임을 할 때 사용자에게 수를 입력받기 위해 출력하는 문자열 */
	static final String STR_INPUT = "숫자를 입력해주세요: ";
	/** 사용자가 입력한 수와 컴퓨터의 수를 비교한 결과 문자열들. */
	static final String STR_STRIKE = " 스트라이크 ";
	static final String STR_BALL = " 볼";
	static final String STR_NOTHING = "낫싱";
	/** 게임 종료 문구 */
	static final String STR_END_GAME = "\r\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	static final String STR_QUESTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	/** 게임 종료 시 입력받는 수의 형식이 잘못되었음을 알리는 문자열 */
	static final String STR_VALIDATION = "1 또는 2를 입력하세요.";
}
