package baseball;

import baseball.domain.BaseballGameLauncher;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseballGameLauncher.play(scanner);
    }
}
