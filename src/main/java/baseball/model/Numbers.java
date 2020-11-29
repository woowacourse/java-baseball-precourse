package baseball.model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import utils.RandomUtils;

public class Numbers {
    private static final int NUMBERS_LENGTH = 3;
    private static final int ZERO = 0;

    private final ArrayList<Number> numbers;

    private Numbers(ArrayList<Number> numbers){
        this.numbers = numbers;
    }

    public static Numbers valueOf(String input) {
        isValidLengthOrThrowException(input);

        ArrayList<Number> inputNumbers = new ArrayList<Number>();
        input.chars()
                .map(Character::getNumericValue)
                .mapToObj(Number::valueOf)
                .filter(number -> notContainsOrThrowException(inputNumbers, number))
                .forEach(inputNumbers::add);
        return new Numbers(inputNumbers);
    }

    private static boolean isValidLengthOrThrowException(String input) {
        if (input.length() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NUMBERS_LENGTH + "자리의 숫자만 입력받을 수 있습니다.");
        }
        return true;
    }

    private static boolean notContainsOrThrowException(ArrayList<Number> destination, Number number) {
        if (destination.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        return true;
    }

    public static Numbers createRandomNumbers(){
        ArrayList<Number> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBERS_LENGTH){
            Number randomNumber = Number.valueOf(RandomUtils.nextInt(Number.MIN, Number.MAX));
            if (!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        return new Numbers(randomNumbers);
    }

    public BallCount calculateBallCountWith(Numbers comparedNumbers) {
        int strike = calculateStrike(comparedNumbers);
        int ball = calculateBall(comparedNumbers);

        return BallCount.createBallCount(strike, ball);
    }

    private int calculateStrike(Numbers comparedNumbers) {
        return (int) IntStream.range(ZERO, NUMBERS_LENGTH)
                .filter(i -> comparedNumbers.get(i).equals(this.get(i)))
                .count();
    }

    private int calculateBall(Numbers comparedNumbers) {
        return (int) IntStream.range(ZERO, NUMBERS_LENGTH)
                .filter(i -> this.contains(comparedNumbers.get(i)))
                .filter(i -> !this.get(i).equals(comparedNumbers.get(i)))
                .count();
    }

    private Number get(int i) {
        return numbers.get(i);
    }

    private boolean contains(Number number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining());
    }
}
