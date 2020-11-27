package baseball.model;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static List<Integer> balls = new ArrayList<>();

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_LENGTH = 3;

    public static void makeBalls() {
        balls.clear();

        while (balls.size() < MAX_LENGTH) {
            int number = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
            if (!balls.contains(number)) {
                balls.add(number);
            }
        }
    }
}
