package BaseballGame;

import BaseballGame.Results.HintResult;
import BaseballGame.Results.NothingResult;
import BaseballGame.Results.ThreeStrikeResult;

import java.util.*;

public class NumbersGroup {
    private static Random random = new Random();
    private static final int SIZE_OF_NUMBERS = 3;
    private static final int MAX_NUMBER = 9;
    private static final int THREE_STRIKE = 3;
    private static final int ZERO_STRIKE = 0;
    private static final int ZERO_BALL = 0;
    private static final int STRIKE_POINT = 0;
    private static final int BALL_POINT = 1;
    private static final int NUMBER_OF_POINTS = 2;


    private Map<Integer, Integer> numbers = new HashMap<>();

    private NumbersGroup(Map<Integer, Integer> numbers) {
        this.numbers = numbers;
    }

    public static NumbersGroup makeNumbersRandomly() {
        Map<Integer, Integer> numbers = new HashMap<>();
        while (numbers.size() < SIZE_OF_NUMBERS) {
            int index = numbers.size() + 1;
            numbers.put(makeRandomNumber(), index);
        }
        return new NumbersGroup(numbers);
    }

    public static NumbersGroup makeNumbersFromInput(Map<Integer, Integer> numbers) throws Exception {
        validateNoZero(numbers);
        validateDuplication(numbers);
        return new NumbersGroup(numbers);
    }

    private static int makeRandomNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }

    private static void validateNoZero(Map<Integer, Integer> numbers) throws Exception {
        if (numbers.containsKey(0)) {
            throw new Exception("숫자는 0을 포함할 수 없습니다.");
        }
    }

    private static void validateDuplication(Map<Integer, Integer> numbers) throws Exception {
        if (numbers.size() != SIZE_OF_NUMBERS) {
            throw new Exception("숫자들은 중복될 수 없습니다.");
        }
    }

    public ComparedResult compareWith(NumbersGroup numbersToCompare) {
        int[] points = countStrikeAndBall(numbersToCompare);
        int strike = points[STRIKE_POINT];
        int ball = points[BALL_POINT];

        if (strike == THREE_STRIKE) {
            return new ThreeStrikeResult();
        }

        if (strike == ZERO_STRIKE && ball == ZERO_BALL) {
            return new NothingResult();
        }

        return new HintResult(strike, ball);
    }

    private int[] countStrikeAndBall(NumbersGroup numbersToCompare) {
        int[] points = new int[NUMBER_OF_POINTS];
        Set<Integer> valuesOfNumbers = numbersToCompare.numbers.keySet();
        for (int value : valuesOfNumbers) {
            int[] pointsAdded = countStrikeAndBall(value, numbersToCompare.numbers.get(value));
            points[STRIKE_POINT] += pointsAdded[STRIKE_POINT];
            points[BALL_POINT] += pointsAdded[BALL_POINT];
        }
        return points;
    }

    private int[] countStrikeAndBall(int value, int index) {
        int[] points = new int[NUMBER_OF_POINTS];
        if (this.numbers.containsKey(value)) {
            if (this.numbers.get(value) == index) {
                points[STRIKE_POINT]++;
            } else {
                points[BALL_POINT]++;
            }
        }
        return points;
    }
}