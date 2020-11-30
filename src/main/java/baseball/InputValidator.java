package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int BASEBALL_NUMBER_LENGTH = 3;

    private static final Set<String> validInputSet = new HashSet<>(Arrays.asList("1", "2"));

    /* 입려값 숫자인지 검사 메소드 */
    private static boolean isInt(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    /*
    player 3자리수 입력 유효성 검사 메소드
    - 숫자, 3자리수, 1~9범위, 중복 체크
    */
    public static String isValid3Digits(String playerInput) {
        if (isInt(playerInput)) {
            if (playerInput.length() != BASEBALL_NUMBER_LENGTH || playerInput.contains("0")) {
                throw new IllegalArgumentException();
            }
        }
        final Set<String> inputNumbers = new HashSet<>();
        for (String data : playerInput.split("")) {
            inputNumbers.add(data);
        }
        if (inputNumbers.size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        return playerInput;
    }

    /* player 종료여부 입력 유효성 검사 메소드 */
    public static String isValid1Digit(String playerInput) {
        if (isInt(playerInput)) {
            if (!validInputSet.contains(playerInput)) {
                throw new IllegalArgumentException();
            }
        }
        return playerInput;
    }
}
