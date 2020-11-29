package baseball;

import java.util.Arrays;
import java.util.Scanner;
import utils.ValidatorUtils;

public class BaseballGame {

    public static final int THREE_DIGIT = 3;

    private final Scanner scanner;
    private final int[] computerNumbers;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";

    private int[] userNumbers = new int[THREE_DIGIT];
    private boolean isPlaying = true;


    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
        this.computerNumbers = new Computer().getComputerNumbers();
        gameStart();
    }

    public boolean restartOrExit() {
        String response;
        while (true) {
            System.out.println("게임을 다시 하시겠습니까? 어플리케이션을 종료할까요?");
            System.out.println("1 : 게임 재시작, 2 :  종료");
            response = scanner.nextLine().trim();
            try {
                ValidatorUtils.checkResponse(response);
                break;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
        if (response.equals("1")) {
            return false;
        }
        if (response.equals("2")) {
            return true;
        }
        return false;
    }


    private void gameStart() {
        while (isPlaying) {
            System.out.println("답 : " + Arrays.toString(computerNumbers));
            getUserNumbers();
            showHints();
        }
    }

    private void getUserNumbers() {
        String numbers;
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            numbers = scanner.nextLine().trim();
            try {
                ValidatorUtils.checkNumbers(numbers);
                break;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
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


}
