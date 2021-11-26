package baseball;

import static baseball.Message.ASK_GAME_RESTART_MESSAGE;
import static baseball.Message.NOT_RELATED_ABOUT_RESTART_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public static Computer computer = new Computer();
    public static Player player = new Player();

    public static void startGame() {
        boolean continueGame = true;
        while (continueGame) {
            continueGame = playGameUntilGetAnswer();
        }
    }

    private static Boolean playGameUntilGetAnswer() {
        computer.makeThreeDigitNumber();
        guessUntilGetAnswer();
        return decideToContinueGame();
    }

    private static void guessUntilGetAnswer() {
        while (true) {
            Result resultOfGuess = computer.compareGuessNumberAndAnswer(player.guessNumber());
            System.out.println(resultOfGuess.makeResultSentence());
            if (resultOfGuess.isAnswer()) {
                break;
            }
        }
    }

    private static Boolean decideToContinueGame() {
        System.out.println(ASK_GAME_RESTART_MESSAGE);
        String continueGame = Console.readLine();
        if (continueGame.equals("1")) {
            return true;
        } else if (continueGame.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(NOT_RELATED_ABOUT_RESTART_MESSAGE);
    }
}
