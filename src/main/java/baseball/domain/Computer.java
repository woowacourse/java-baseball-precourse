package baseball.domain;

import utils.RandomUtils;
import baseball.util.Validator;

import java.util.*;

import static baseball.util.Validator.INPUT_MAX_NUMBER;
import static baseball.util.Validator.INPUT_MIN_NUMBER;

public class Computer {

    private static List<Integer> numbers;

    private Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer create() {

        List<Integer> numbers = createNumbers();
        Collections.shuffle(numbers);

        return new Computer(numbers);
    }

    private static List<Integer> createNumbers() {

        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < Validator.REQUIRE_NUMBER_COUNT) {
            numbers.add(getRandom());
        }

        return new ArrayList<>(numbers);
    }

    private static int getRandom() {
        return RandomUtils.nextInt(INPUT_MIN_NUMBER, INPUT_MAX_NUMBER);
    }


    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public boolean hasNumberOfIndex(int number, int index) {
        return numbers.indexOf(number) == index;
    }

    public List<Integer> cloneNumbers() {       //TODO 테스트용
        return Collections.unmodifiableList(this.numbers);
    }

}
