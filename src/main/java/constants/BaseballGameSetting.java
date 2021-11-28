package constants;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseballGameSetting {
	public static final int START_NUMBER = 1; // 1 <= START_NUMBER <= 9
	public static final int END_NUMBER = 9; // START_NUMBER <= END_NUMBER <= 9
	public static final int ANSWER_LENGTH = 3; // 1 <= ANSWER_LENGTH <= END_NUMBER - START_NUMBER + 1
	public static final String RESTART_OPTION = "1";
	public static final String FINISH_OPTION = "2";
	public static ArrayList<String> START_OPTIONS = new ArrayList<>(Arrays.asList(RESTART_OPTION, FINISH_OPTION));
}
