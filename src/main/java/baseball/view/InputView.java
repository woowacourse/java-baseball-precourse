package baseball.view;

import baseball.constant.BallConstant;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.constant.BallConstant.BALL_SIZE;

public class InputView {

    private static final String ERROR_WRONG_INPUT = "잘못된 값을 입력하였습니다.";

    public static Balls inputNumber(InputStrategy inputStrategy) {
        String input = inputStrategy.getInput();
        validateInput(input);
        return convertBalls(input);
    }

    private static Balls convertBalls(String input) {
        int[] ballNumbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        int firstBall = ballNumbers[0];
        int secondBall = ballNumbers[1];
        int thirdBall = ballNumbers[2];
        return new Balls(firstBall, secondBall, thirdBall);
    }

    private static void validateInput(String input) {
        int number;
        // 숫자로 변환하지 못한 것도 예외이다
        try {
            number = Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }
        if (number < 100 || number > 999) {
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
        for (int i = 0; i < BALL_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }
        return new Balls(set);
    }
}
