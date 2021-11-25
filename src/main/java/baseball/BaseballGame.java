package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.PrintStatement.ASK_GAME_RESTART_MESSAGE;

public class BaseballGame {

    public static Computer computer = new Computer();
    public static Player player = new Player();

    public static void gameStart() {
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
        }
        if (continueGame.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2 이외의 값을 입력하셨습니다.");
    }
}
