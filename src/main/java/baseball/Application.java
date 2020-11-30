package baseball;

import static baseball.Constants.MESSAGE_GAME_FINISHED;
import static baseball.Constants.MESSAGE_GAME_INPUT;
import static baseball.Constants.MESSAGE_GAME_REPLAY;
import static baseball.UtilityFunctions.generateResultString;
import static baseball.UtilityFunctions.parseGameExitString;
import static baseball.UtilityFunctions.parseGuessString;

import java.util.Scanner;

public class Application {

    // 숫자 야구 게임을 진행하는 메소드
    private static void playBaseballGame(Scanner scanner) {
        BaseballGame baseballGame = new BaseballGame();
        boolean gameFinished = false;

        while (!gameFinished) {
            System.out.print(MESSAGE_GAME_INPUT);
            final String userGuessString = scanner.nextLine();

            final int[] userGuessArray = parseGuessString(userGuessString);

            final BaseballResult baseballResult = baseballGame.playBall(userGuessArray);

            final String resultString = generateResultString(baseballResult);
            System.out.println(resultString);

            gameFinished = baseballResult.isGameFinished();
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        boolean gameExitFlag = false;

        while (!gameExitFlag) {
            playBaseballGame(scanner);

            System.out.println(MESSAGE_GAME_FINISHED);
            System.out.println(MESSAGE_GAME_REPLAY);
            String userGameExitString = scanner.nextLine();

            gameExitFlag = parseGameExitString(userGameExitString);
        }
    }
}
