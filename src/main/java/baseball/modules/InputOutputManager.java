package baseball.modules;

import java.util.Scanner;

/**
 * Manage inputs and outputs used in the game.
 * 
 * @author Kim Hanseul
 */
public class InputOutputManager {
    private static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WRONG_VALUE_MESSAGE = "잘못된 값입니다.";
    private static final String WIN_PRAISE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n";
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String BALL_FORMAT = "%d볼 ";

    private Scanner scanner;
    private int numberSize;
    
    public InputOutputManager(final Scanner scanner, final int numberSize) {
        if (ExceptionChecker.isNull(scanner)) {
            throw new IllegalArgumentException();
        }

        if (numberSize <= 0) {
            throw new IllegalArgumentException();
        }

        this.scanner = scanner;
        this.numberSize = numberSize;
    }

    /** Ask user for a number to use in the game and return it. */
    public int[] askUserInputNumber() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        String inputNumber = scanner.nextLine();
        try {
            return ParseHandler.stringToIntArray(inputNumber, numberSize);
        } catch(Exception e) {
            System.out.println(WRONG_VALUE_MESSAGE);
            return askUserInputNumber();
        }
    }

    /** Print the result of a round, count of strike and ball. */
    public void printRoundResult(final int strike, final int ball) {
        if (strike < 0 || ball < 0) {
            throw new IllegalArgumentException();
        }

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            return;
        }

        if (ball != 0) {
            System.out.printf(BALL_FORMAT, ball);
        }

        if (strike != 0) {
            System.out.printf(STRIKE_FORMAT, strike);
        }

        System.out.println();
    }

    public void printWinMessage() {
        System.out.printf(WIN_PRAISE_FORMAT, numberSize);
    }

    /** Ask user if want to restart, and return 1 or 2. */
    public int askRestartGame() {
        System.out.println(ASK_RESTART_MESSAGE);
        String answer = scanner.nextLine();
        try {
            return ParseHandler.stringToOneOrTwo(answer);
        } catch(Exception e) {
            return askRestartGame();
        }
    }
}
