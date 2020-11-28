package utils;

import number.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private InputUtils inputUtils;
    private Number number;

    private Game(Scanner scanner) {
        this.inputUtils = InputUtils.of(scanner);
    }

    public static Game of(Scanner scanner) {
        return new Game(scanner);
    }

    public void start() {
        List<Integer> integerList = inputUtils.getIntegerList();
        number = Number.of(integerList);
        List<Integer> randomList = createRandomList(3);
        System.out.println("number = " + number.getNumbers());
        System.out.println("randomList = " + randomList);
    }

    public static List<Integer> createRandomList(int numberSize) {
        List<Integer> randomList = new ArrayList<>();
        int randomNumber;
        for (int i = 0; i < numberSize; i++) {
            randomNumber = RandomUtils.nextInt(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
                continue;
            }
            i--;
        }
        return randomList;
    }
}
