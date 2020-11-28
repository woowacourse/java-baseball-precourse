package utils;

import number.Number;
import number.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private InputUtils inputUtils;
    private static Numbers numbers;

    private Game(Scanner scanner) {
        this.inputUtils = InputUtils.of(scanner);
    }

    public static Game of(Scanner scanner) {
        return new Game(scanner);
    }

    public void start() {
        initializeGame();
        printResult(numbers.checkBall(), numbers.checkStrike());
    }

    private void printResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    private void initializeGame() {
        List<Number> gameNumber = new ArrayList<>();
        List<Integer> randomList = Number.createRandomList(3);
        List<Integer> inputList = inputUtils.getIntegerList();
        gameNumber.add(Number.of(randomList));
        gameNumber.add(Number.of(inputList));
        this.numbers = Numbers.of(gameNumber);
    }
}
