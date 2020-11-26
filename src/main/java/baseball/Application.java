package baseball;

import baseball.controller.BaseballGameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new BaseballGameController(scanner).runBaseballGameApplication();
    }
}
