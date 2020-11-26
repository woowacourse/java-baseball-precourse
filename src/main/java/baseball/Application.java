package baseball;

import utils.RandomUtils;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        BaseBallGame baseBallGame=new BaseBallGame();
        baseBallGame.run();
    }
}
