package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Computer computer;
        BaseBallGame baseBallGame;
        do {
            computer = new Computer(new RandomNumberMaker());
            baseBallGame = new BaseBallGame(scanner, computer);
            baseBallGame.play();
        } while (baseBallGame.isRestart());
    }
}
