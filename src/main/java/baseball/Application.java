package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Computer computer = new Computer();
        BaseBallGame baseBallGame = new BaseBallGame(scanner, computer);
        baseBallGame.play();
    }
}
