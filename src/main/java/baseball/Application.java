package baseball;

import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        while (true) {
            BaseballGame baseballGame = new BaseballGame(scanner);
            boolean exit = baseballGame.restartOrExit();
            if (exit) {
                return;
            }
        }
    }


}
