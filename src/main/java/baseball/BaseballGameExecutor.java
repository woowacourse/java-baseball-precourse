package baseball;

import domain.BaseBall;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGameExecutor {
    private static Scanner scanner;
    private static final int RESTART = 1;
    private static final int END = 2;

    public static void startGame(Scanner inputScanner) {
        scanner = inputScanner;
        BallTypeChecker ballTypeChecker = readyForGame();
        guessNumber(ballTypeChecker);
    }

    private static BallTypeChecker readyForGame() {
        BaseBall randomBaseBall = BaseBall.createRandomBaseBall();
        return BallTypeChecker.ballTypeCheckWith(randomBaseBall);
    }

    private static void guessNumber(BallTypeChecker ballTypeChecker) {
        BaseBall inputBaseball = makeBaseballNumber();
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        baseballResult.printResult();
        if (baseballResult.isAnswer()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            askToRestart();
        } else {
            guessNumber(ballTypeChecker);
        }
    }

    private static BaseBall makeBaseballNumber() {
        try {
            int inputNumber = inputNumber();
            return BaseBall.createBaseBall(inputNumber);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return makeBaseballNumber();
        }
    }

    private static int inputNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            int inputNumber = scanner.nextInt();
            return inputNumber;
        } catch (InputMismatchException e) {
            needIntegerType();
            return inputNumber();
        }
    }

    private static void askToRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int reStart = scanner.nextInt();
            if (reStart == RESTART) {
                startGame(scanner);
            } else if (reStart != END) {
                askToRestart();
            }
        } catch (InputMismatchException e) {
            needIntegerType();
            askToRestart();
        }
    }

    private static void needIntegerType() {
        scanner.nextLine(); //개행문자 버그를 잡기 위해
        System.out.println("숫자 형식을 입력해주세요.");
    }

}
