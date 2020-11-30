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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            // [0, numberList.size()] 사이의 무작위 값을 생성하여 이를 추출용 인덱스로 이용
            final int indexForAnswer = RandomUtils.nextInt(0, numberList.size());
            // numberList 의 추출 인덱스에 있는 값을 뽑아 answerArray 의 현재 인덱스에 대입
            answerArray[index] = numberList.remove(indexForAnswer);
        }

        return answerArray;
    }

    // baseballResult의 값에 알맞는 게임 결과를 문자열로 생성하는 메소드
    public static String generateResultString(BaseballResult baseballResult) {
        if (baseballResult.getStrike() == 0 && baseballResult.getBall() == 0) {
            return MESSAGE_RESULT_NOTHING;
        }

        String resultString = "";

        if (baseballResult.getBall() > 0) {
            resultString += baseballResult.getBall() + MESSAGE_RESULT_BALL;
        }

        if (baseballResult.getStrike() > 0) {
            if (resultString.length() > 0) {
                resultString += ' ';
            }
            resultString += baseballResult.getStrike() + MESSAGE_RESULT_STRIKE;
        }

        return resultString;
    }

    // 입력받은 배열의 크기가 GAME_MAX_BASEBALL_PITCH 값과 같은지 확인하는 메소드
    public static void validateSizeOfArray(int[] numberArray) {
        if (numberArray.length != GAME_MAX_BASEBALL_PITCH) {
            throw new IllegalArgumentException(
                ErrorMessages.ARRAY_INVALID_LENGTH.getMessage()
            );
        }
    }

    // 입력받은 배열 내에 중복된 값이 있는지 확인하는 메소드
    public static void validateDuplicateItemsInArray(int[] numberArray) {
        final Set<Integer> baseballNumberSet = new HashSet<>();

        for (int number : numberArray) {
            baseballNumberSet.add(number);
        }

        // 중복된 수가 입력받은 배열에 있을 경우, 배열과 셋의 길이가 다른 것을 이용
        if (baseballNumberSet.size() != numberArray.length) {
            throw new IllegalArgumentException(
                ErrorMessages.ARRAY_ITEM_DUPLICATED.getMessage()
            );
        }
    }

    // 입력받은 배열 내에 허용된 범위를 넘어가는 값이 있는지 확인하는 메소드
    public static void validateItemRangeInArray(int[] numberArray) {
        for (int number : numberArray) {
            if (number > GAME_MAX_BASEBALL_NUMBER || number < GAME_MIN_BASEBALL_NUMBER) {
                throw new IllegalArgumentException(
                    ErrorMessages.ARRAY_ITEM_OUT_OF_RANGE.getMessage()
                );
            }
        }
    }

    // 사용자의 정답 추측 입력이 올바른 형식인지 확인하는 메소드
    public static void validateGuessString(String userGuessString) {
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
    public static void validateGameExitString(String gameExitString) {
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
