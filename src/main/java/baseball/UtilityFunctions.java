package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_NUMBER;
import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;
import static baseball.Constants.GAME_MIN_BASEBALL_NUMBER;
import static baseball.Constants.MESSAGE_RESULT_BALL;
import static baseball.Constants.MESSAGE_RESULT_NOTHING;
import static baseball.Constants.MESSAGE_RESULT_STRIKE;
import static baseball.Constants.STRING_USER_EXIT;
import static baseball.Constants.STRING_USER_NOT_EXIT;

import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class UtilityFunctions {

    private UtilityFunctions() {
    }

    // GAME_MAX_BASEBALL_PITCH 개의 항목을 지닌 int[] 를 생성하는 메소드
    // 각 항목은 [GAME_MIN_BASEBALL_NUMBER, GAME_MAX_BASEBALL_NUMBER] 사이의 값으로 대입
    public static int[] generateAnswerArray() {
        int[] answerArray = new int[GAME_MAX_BASEBALL_PITCH];

        // GAME_MIN_BASEBALL_NUMBER 부터 GAME_MAX_BASEBALL_NUMBER 까지의 수가
        // 순서대로 들어있는 ArrayList<> 생성
        List<Integer> numberList = new ArrayList<>();
        for (int number = GAME_MIN_BASEBALL_NUMBER; number <= GAME_MAX_BASEBALL_NUMBER; number++) {
            numberList.add(number);
        }

        for (int index = 0; index < answerArray.length; index++) {
            // [0, numberList.size()) 사이의 무작위 값을 생성하여 이를 추출용 인덱스로 이용
            final int indexForAnswer = RandomUtils.nextInt(0, numberList.size() - 1);
            // numberList 의 추출 인덱스에 있는 값을 뽑아 answerArray 의 현재 인덱스에 대입
            answerArray[index] = numberList.remove(indexForAnswer);
        }

        return answerArray;
    }

    // baseballResult의 값에 알맞는 게임 결과를 문자열로 생성하는 메소드
    public static String generateResultString(BaseballResult baseballResult) {
        if (baseballResult.getStrikes() == 0 && baseballResult.getBalls() == 0) {
            return MESSAGE_RESULT_NOTHING;
        }

        String resultString = "";

        if (baseballResult.getBalls() > 0) {
            resultString += baseballResult.getBalls() + MESSAGE_RESULT_BALL;
        }

        if (baseballResult.getStrikes() > 0) {
            if (resultString.length() > 0) {
                resultString += ' ';
            }
            resultString += baseballResult.getStrikes() + MESSAGE_RESULT_STRIKE;
        }

        return resultString;
    }

    // 사용자의 정답 추측 입력이 올바른 형식인지 확인하는 메소드
    private static void validateGuessString(String userGuessString) {
        try {
            Integer.parseInt(userGuessString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ErrorMessages.INPUT_INVALID_STRING.getMessage()
            );
        }
    }

    // 사용자가 입력한 userGuessString 문자열 내의 숫자들을 int[] 에 넣어 생성해주는 메소드
    public static int[] parseGuessString(String userGuessString) {
        validateGuessString(userGuessString);
        int[] userGuessArray = new int[userGuessString.length()];
        for (int index = 0; index < userGuessArray.length; index++) {
            userGuessArray[index] = userGuessString.charAt(index) - '0';
        }
        return userGuessArray;
    }

    // 사용자가 입력한 재시작 답변이 올바른 형식인지 확인하는 메소드
    private static void validateGameExitString(String gameExitString) {
        if (!gameExitString.equals(STRING_USER_EXIT) &&
            !gameExitString.equals(STRING_USER_NOT_EXIT)) {
            throw new IllegalArgumentException(
                ErrorMessages.INPUT_INVALID_STRING.getMessage()
            );
        }
    }

    // 사용자가 입력한 재시작 답변이 프로그램의 종료 요청인지 확인하는 메소드
    public static boolean parseGameExitString(String gameExitString) {
        validateGameExitString(gameExitString);
        return gameExitString.equals(STRING_USER_EXIT);
    }
}
