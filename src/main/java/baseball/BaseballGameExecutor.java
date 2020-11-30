package baseball;

import domain.BaseBall;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGameExecutor {
    private static final int RESTART_NUM = 1;
    private static final int END_NUM = 2;
    private static Scanner scanner;
    private static BaseballRepository baseballRepository;

    public static void startGame(Scanner inputScanner, BaseballRepository inputBaseballRepository) {
        scanner = inputScanner;
        baseballRepository = inputBaseballRepository;
        BallTypeChecker ballTypeChecker = readyForGame();
        guessNumber(ballTypeChecker);
    }

    private static BallTypeChecker readyForGame() {
        BaseBall randomBaseBall = baseballRepository.createRandomBaseBall();
        return BallTypeChecker.ballTypeCheckWith(randomBaseBall);
    }

    private static void guessNumber(BallTypeChecker ballTypeChecker) {
        BaseBall inputBaseball = inputBaseballNumber();
        BaseballResult baseballResult = ballTypeChecker.startChecking(inputBaseball);
        Printer.result(baseballResult);
        if (baseballResult.isAnswer()) {
            Printer.isCorrect();
            askToRestart();
        } else {
            guessNumber(ballTypeChecker);
        }
    }

    private static BaseBall inputBaseballNumber() {
        try {
            int inputNumber = inputNumber();
            return baseballRepository.createInputBaseBall(inputNumber);
        } catch (IllegalStateException e) {
            Printer.printMessage(e.getMessage());
            return inputBaseballNumber();
        }
    }

    private static int inputNumber() {
        try {
            Printer.inputNumber();
            int inputNumber = scanner.nextInt();
            return inputNumber;
        } catch (InputMismatchException e) {
            scanner.nextLine(); //개행문자 버그를 잡기 위해
            Printer.onlyNumber();
            return inputNumber();
        }
    }

    private static void askToRestart() {
        Printer.askRestart();
        try {
            int reStart = scanner.nextInt();
            if (reStart == RESTART_NUM) {
                startGame(scanner, baseballRepository);
            } else if (reStart != END_NUM) {
                askToRestart();
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); //개행문자 버그를 잡기 위해
            Printer.onlyNumber();
            askToRestart();
        }
    }

}
