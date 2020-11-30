package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        Player player = new Player();
        Computer computer = new Computer();

        player.playGame(scanner, computer);
        player.replayOrQuit(scanner);
    }
}
