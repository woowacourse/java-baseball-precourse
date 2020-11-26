package baseball;

import java.util.Scanner;

import static baseball.domain.GameInfomation.GAME_START;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // TODO 구현 진행
        BaseBallGame baseBallGame = new BaseBallGame();
        int gameStatus = GAME_START;
        while(gameStatus == GAME_START) {
            gameStatus = baseBallGame.play(scanner);
        }
        scanner.close();
    }
}
