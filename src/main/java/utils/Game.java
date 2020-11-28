package utils;

import number.Number;
import number.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private InputUtils inputUtils;
    private static Numbers numbers;
    private static List<Integer> randomList;

    private Game(Scanner scanner) {
        this.inputUtils = InputUtils.of(scanner);
    }

    public static Game of(Scanner scanner) {
        return new Game(scanner);
    }

    public void start() {
        while (true) {
            initializeGame();
            int ballCount = numbers.checkBall();
            int strikeCount = numbers.checkStrike();

            printResult(ballCount, strikeCount);

            if (isFinish(strikeCount)) {
                break;
            }
        }
    }

    public static void printResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    private void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void initializeGame() {
        List<Number> gameNumber = new ArrayList<>();
        if(randomList == null) {
            randomList = Number.createRandomList(3);
        }
        List<Integer> inputList = inputUtils.getIntegerList();
        gameNumber.add(Number.of(randomList));
        gameNumber.add(Number.of(inputList));
        this.numbers = Numbers.of(gameNumber);
    }

    public boolean isFinish(int strikeCount) {
        if (strikeCount == 3) {
            printFinish();
            return true;
        }
        return false;
    }
}
