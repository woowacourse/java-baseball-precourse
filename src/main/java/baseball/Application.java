package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        BaseballGameInput baseballGameInput = new BaseballGameInput(scanner);
        BaseballGame baseballGame = new BaseballGame(baseballGameInput);
        baseballGame.run();
    }
}
