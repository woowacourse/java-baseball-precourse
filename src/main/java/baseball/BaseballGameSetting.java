package baseball;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseballGameSetting {
	public static final int START_NUMBER = 1; // 1 <= START_NUMBER <= 9
	public static final int END_NUMBER = 9; // START_NUMBER <= END_NUMBER <= 9
	public static final int ANSWER_LENGTH = 3; // 1 <= ANSWER_LENGTH <= END_NUMBER - START_NUMBER + 1
	public static final String RESTART_OPTION = "1";
	public static final String FINISH_OPTION = "2";
	public static ArrayList<String> START_OPTIONS = new ArrayList<>(Arrays.asList(RESTART_OPTION, FINISH_OPTION));
	public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String END_MESSAGE = ANSWER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}
