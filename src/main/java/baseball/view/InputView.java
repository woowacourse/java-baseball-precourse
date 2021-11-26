package baseball.view;

import baseball.model.Balls;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private static final int BALL_SIZE = 3;

    public static Balls inputNumber(InputStrategy inputStrategy) {
        String input = inputStrategy.getInput();
        validateInput(input);
        Balls balls = convertBalls(input);
        return balls;
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
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
