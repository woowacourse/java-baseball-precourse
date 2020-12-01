/**
 * Numbers.java
 * Number 객체를 리스트로 가지는 일급 컬렉션
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package baseball.model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.RandomUtils;

public class Numbers {
    public static final int NUMBERS_LENGTH = 3;
    private static final int ZERO = 0;

    private final ArrayList<Number> numbers;

    private Numbers(ArrayList<Number> numbers) {
        this.numbers = numbers;
    }

    /* String을 받아 Numbers를 생성하는 메소드 */
    public static Numbers valueOf(String input) {
        isValidLengthOrThrowException(input);   /* 입력값의 길이 예외 처리 */

        ArrayList<Number> inputNumbers = new ArrayList<Number>();
        input.chars()
                .map(Character::getNumericValue)
                .mapToObj(Number::valueOf)      /* 정적 팩토리 메소드에 의해 Number 객체 생성 */
                .filter(number -> notContainsOrThrowException(inputNumbers, number))    /* 중복 예외 처리 */
                .forEach(inputNumbers::add);
        return new Numbers(inputNumbers);
    }

    /* 입력값의 길이가 유효한지 판단하는 메소드 */
    private static boolean isValidLengthOrThrowException(String input) {
        if (input.length() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NUMBERS_LENGTH + "자리의 숫자만 입력받을 수 있습니다.");
        }
        return true;
    }

    /* destination ArrayList에 이미 같은 수가 추가되어 있는지 확인하는 메소드 */
    private static boolean notContainsOrThrowException(ArrayList<Number> destination, Number number) {
        if (destination.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        return true;
    }

    /* 제시된 RandomUtils를 이용한 Numbers 생성 정적 팩토리 메소드 */
    public static Numbers createRandomNumbers() {
        ArrayList<Number> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBERS_LENGTH) {
            Number randomNumber = Number.valueOf(RandomUtils.nextInt(Number.MIN, Number.MAX));
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return new Numbers(randomNumbers);
    }

    /* 인자로 받은 Numbers와 비교해 볼카운트 객체를 만듭니다. */
    public BallCount calculateBallCountWith(Numbers comparedNumbers) {
        int strike = calculateStrike(comparedNumbers);
        int ball = calculateBall(comparedNumbers);

        return BallCount.createBallCount(strike, ball);
    }

    /* Numbers를 받아 자신과 비교해 스트라이크를 산출합니다. */
    private int calculateStrike(Numbers comparedNumbers) {
        return (int) IntStream.range(ZERO, NUMBERS_LENGTH)
                .filter(i -> comparedNumbers.get(i).equals(this.get(i)))
                .count();
    }

    /* Numbers를 받아 자신과 비교해 볼을 산출합니다. */
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
