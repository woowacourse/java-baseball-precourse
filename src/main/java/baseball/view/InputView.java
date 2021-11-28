package baseball.view;

import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.constant.BallConstant.BALLS_LENGTH;

public class InputView {

    private static final String ERROR_WRONG_INPUT = "잘못된 값을 입력하였습니다.";

    public static Balls inputNumber(InputStrategy inputStrategy) {
        String input = inputStrategy.getInput();
        validateInput(input);
        return convertBalls(input);
    }

    private static Balls convertBalls(String input) {
        return new Balls(Integer.parseInt(input));
    }

    private static void validateInput(String input) {

        String regExp = "[1-9]{3}";
        boolean matches = Pattern.matches(regExp, input);
        if (!matches) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }

        // 중복된 숫자가 있을 경우 예외를 던진다
        HashSet<String> inputSet = new HashSet<>(Arrays.asList(input.split("")));
        if (inputSet.size() < BALLS_LENGTH) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }
    }

    public static int inputChoiceAfterEnd() {
        String inputString = Console.readLine();
        int inputInteger;

        try {
            inputInteger = Integer.parseInt(inputString);
        } catch (Exception exception) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }

        if (inputInteger < 1 || inputInteger > 2) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }

        return inputInteger;
    }

    public static Balls getRandomBalls() {
        Set<Integer> set = new LinkedHashSet<>();
        do {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        } while (set.size() < BALLS_LENGTH); // 중복을 제외한 BallNumber 가 3개이어야 한다

        return new Balls(set);
    }
}
