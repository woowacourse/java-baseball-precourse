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
        printResult (numbers.checkBall());
    }

    private void printResult(int checkBall) {
        if (checkBall > 0) {
            System.out.print(checkBall + "볼 ");
        }
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
