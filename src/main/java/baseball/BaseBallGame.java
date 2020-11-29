package baseball;

import number.Number;
import number.Numbers;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {

    private static Numbers numbers;
    private static List<Integer> randoms;

    private InputUtils inputUtils;

    private BaseBallGame(Scanner scanner) {
        this.inputUtils = InputUtils.of(scanner);
    }

    public static BaseBallGame of(Scanner scanner) {
        return new BaseBallGame(scanner);
    }

    public void start() {
        while (true) {
            initializeGame();
            int ballCount = numbers.countBall();
            int strikeCount = numbers.countStrike();
            boolean isContinue = true;

            printResult(ballCount, strikeCount);

            if (isFinish(strikeCount)) {
                randoms = null;
                isContinue = isContinueOrNot();
            }
            if (!isContinue) {
                break;
            }
        }
    }

    public boolean isContinueOrNot() {
        int continueOrNot = inputUtils.getContinueOrNot();
        if (continueOrNot == 1) {
            return true;
        }
        return false;
    }

    public static void printResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    private void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void initializeGame() {
        List<Number> gameNumber = new ArrayList<>();
        if(randoms == null) {
            randoms = Number.createRandoms(3);
        }
        List<Integer> inputNumbers = inputUtils.getIntegers();
        gameNumber.add(Number.of(randoms));
        gameNumber.add(Number.of(inputNumbers));
        this.numbers = Numbers.of(gameNumber);
    }

    private boolean isFinish(int strikeCount) {
        if (strikeCount == 3) {
            printFinish();
            return true;
        }
        return false;
    }
}
