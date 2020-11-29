package baseball;

import baseball.service.BaseballGame;

import java.util.Scanner;

public class Application {
    private static final String GAME_START = "1";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        BaseballGame baseballGame = new BaseballGame(scanner);
        baseballGame.start();
    }

}
