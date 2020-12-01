package baseball;

import static baseball.Constants.MESSAGE_GAME_FINISHED;
import static baseball.Constants.MESSAGE_GAME_INPUT;
import static baseball.Constants.MESSAGE_GAME_REPLAY;
import static baseball.UtilityFunctions.generateResultString;
import static baseball.UtilityFunctions.parseGameExitString;
import static baseball.UtilityFunctions.parseGuessString;

import java.util.Scanner;

public class ConsoleBaseballProgram {

    private final Scanner scanner;

    public ConsoleBaseballProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    // 숫자 야구 게임을 진행하는 메소드
    private void playBaseballGame() {
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

    // 게임 종료 요쳥 전까지 숫자 야구 게임을 반복 실행하는 메소드
    public void run() {
        boolean gameExitFlag = false;

        while (!gameExitFlag) {
            playBaseballGame();

            System.out.println(MESSAGE_GAME_FINISHED);
            System.out.println(MESSAGE_GAME_REPLAY);
            final String userGameExitString = scanner.nextLine();

            gameExitFlag = parseGameExitString(userGameExitString);
        }
    }
}
