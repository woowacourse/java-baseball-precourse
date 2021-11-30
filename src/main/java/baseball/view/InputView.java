package baseball.view;

import baseball.vo.UserBall;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private static final String MESSAGE_TO_ASK_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final int VALID_LENGTH_OF_USER_INPUT = 3;
    private static final String VALID_NUMBER_PATTERN = "^[1-9]{3}$";

    public static UserBall getUserBallByUserInput() {
        System.out.print(MESSAGE_TO_ASK_USER_INPUT);
        return validateUserInput(Console.readLine());
    }

    private static UserBall validateUserInput(String userInput) {
        validateLength(userInput);
        validateOnlyNumbers(userInput);
        validateDuplicate(userInput);

        return getUserBallByUserInput(userInput);
    }

    private static void validateLength(String userInput) {
        if (userInput.length() != VALID_LENGTH_OF_USER_INPUT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOnlyNumbers(String userInput) {
        if (!userInput.matches(VALID_NUMBER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(String userInput) {
        Set<Character> characterSet = new HashSet<>();
        for (Character character : userInput.toCharArray()) {
            characterSet.add(character);
        }

        if (characterSet.size() != VALID_LENGTH_OF_USER_INPUT) {
            throw new IllegalArgumentException();
        }
    }

    private static UserBall getUserBallByUserInput(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (Character character : userInput.toCharArray()) {
            userInputList.add(Integer.parseInt(String.valueOf(character)));
        }

        return new UserBall(userInputList);
    }

}
