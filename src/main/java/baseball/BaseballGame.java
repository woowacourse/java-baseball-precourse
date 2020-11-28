package baseball;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class BaseballGame {

    private Scanner scanner;
    private final int THREE_DIGIT = 3;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";

    private int[] computerNumbers;
    private int[] userNumbers = new int[THREE_DIGIT];
    private boolean isPlaying = true;


    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
        this.computerNumbers = RandomUtils.getComputerNumbers();
        gameStart();
    }

    private void gameStart() {
        while (isPlaying) {
            System.out.println("답 : " + Arrays.toString(computerNumbers));
            getUserNumbers();
            showHints();
        }
    }

    private void getUserNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String numbers = scanner.nextLine().trim();
        checkValidNumbers(numbers);
        for (int i = 0; i < THREE_DIGIT; i++) {
            userNumbers[i] = numbers.charAt(i) - '0';
        }
    }

    private void showHints() {
        int strike = 0;
        int ball = 0;
        int[] resultState = checkState(strike, ball);
        strike = resultState[0];
        ball = resultState[1];

        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        }
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isPlaying = false;
        }
    }

    private int[] checkState(int strike, int ball) {
        for (int i = 0; i < THREE_DIGIT; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strike += 1;
                continue;
            }
            ball = checkBallState(i, ball);
        }
        int[] resultState = {strike, ball};
        return resultState;
    }

    private int checkBallState(int i, int ball) {
        for (int j = 0; j < THREE_DIGIT; j++) {
            if (computerNumbers[j] == userNumbers[i]) {
                return ball + 1;
            }
        }
        return ball;
    }

    private void checkValidNumbers(String numbers) {
        if (numbers.length() != THREE_DIGIT) {
            throw new IllegalArgumentException("3자리를 넘어갔습니다. 3자리 숫자를 입력해 주세요.");
        }
        for (int i = 0; i < THREE_DIGIT; i++) {
            if (!Character.isDigit(numbers.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해 주세요.");
            }

        }
    }
}
