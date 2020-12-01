package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        Printer printer = new Printer();
        Score score = new Score();
        Valid valid = new Valid();
        Game baseballGame = new Game(printer, score, valid);

        baseballGame.initNewGame();


        while (true) {
            baseballGame.readyForInput();
            if (baseballGame.playing(scanner.nextLine())) {
                continue;
            }
            if (baseballGame.askStop(scanner.nextLine())) {
                break;
            }
            baseballGame.initNewGame();
        }
    }
}
