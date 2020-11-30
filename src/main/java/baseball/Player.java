package baseball;

import utils.NumberHandleUtils;
import java.util.Scanner;

public class Player {
    // CONSTANTS FOR GAME PLAY
    private static final String GUESS_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GUESS_INPUT_ERROR_MESSAGE = "1 에서 9 사이의 서로 다른 숫자로 이루어진 3자리 정수만 입력 가능합니다";

    // CONSTANTS FOR AFTER GAME
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REPLAY_OR_QUIT_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE = "1 혹은 2만 입력 가능합니다";
    private static final String QUIT_MESSAGE = "GG";

    private int tryToGuessNum(Scanner scanner) throws IllegalArgumentException {
        System.out.print(GUESS_INPUT_MESSAGE);
        // input is not an integer
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int guessInput = scanner.nextInt();

        // input has 3 digits and valid number
        if (100 <= guessInput && guessInput < 1000 && NumberHandleUtils.isValidNum(guessInput)) {
            return guessInput;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int getPlayerNum(Scanner scanner) {
        boolean isValidGuess = false;
        int playerNum = 123; // initialize with meaningless number (123) to compile without an error
        while (!isValidGuess) {
            try {
                playerNum = tryToGuessNum(scanner);
                isValidGuess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(GUESS_INPUT_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }
        return playerNum;
    }

    public void playGame(Scanner scanner, Computer computer) {
        StrikeAndBall thisTurnResult;
        do {
            int playerNum = getPlayerNum(scanner);
            thisTurnResult = computer.getStrikeAndBall(playerNum, computer.answer);
            computer.giveHint(thisTurnResult);
        } while (!computer.isThreeStrikes(thisTurnResult));
    }

    private void decideReplayOrQuit(Scanner scanner) throws IllegalArgumentException {
        System.out.println(REPLAY_OR_QUIT_INPUT_MESSAGE);
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int replayOrQuitInput = scanner.nextInt();

        if (replayOrQuitInput == 1) {
            Application.main(null);
        } else if (replayOrQuitInput == 2) {
            System.out.println(QUIT_MESSAGE);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void replayOrQuit(Scanner scanner) {
        System.out.println(WIN_MESSAGE);
        scanner.nextLine();

        boolean isValidReplayOrQuitInput = false;
        while (!isValidReplayOrQuitInput) {
            try {
                decideReplayOrQuit(scanner);
                isValidReplayOrQuitInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }
    }
}
