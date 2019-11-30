import java.util.*;

public class NumbersGroup {
    private static Random random = new Random();
    private static final int SIZE_OF_NUMBERS = 3;
    private static final int MAX_NUMBER = 9;

    private Map<Integer, Integer> numbers = new HashMap<>();

    public NumbersGroup(Map<Integer, Integer> numbers) {
        validateNoZero(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public static NumbersGroup makeNumbersGroupRandomly() {
        Map<Integer, Integer> numbers = new HashMap<>();
        while (numbers.size() < SIZE_OF_NUMBERS) {
            int index = numbers.size() + 1;
            numbers.put(makeRandomNumber(), index);
        }
        return new NumbersGroup(numbers);
    }

    public static NumbersGroup makeNumbersGroupFromInput(Map<Integer, Integer> numbers) {
        return new NumbersGroup(numbers);
    }

    private static int makeRandomNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }

    public void validateNoZero(Map<Integer, Integer> numbers) {
        if (numbers.containsKey(0)) {
            throw new IllegalArgumentException("숫자는 0을 포함할 수 없습니다.");
        }
    }

    public void validateDuplication(Map<Integer, Integer> numbers) {
        if (numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자들은 중복될 수 없습니다.");
        }
    }

    public void compareWith(NumbersGroup numbersGroupToCompare) {
        int strike = 0;
        int ball = 0;
        Set<Integer> valuesToCompare = numbersGroupToCompare.numbers.keySet();
        for (int valueToCompare : valuesToCompare) {

        }
    }

    private int countStrike(NumbersGroup numbersGroupToCompare) {
        Set<Integer> valuesOfNumbers = numbers.keySet();
        for (int value : valuesOfNumbers) {
            int index = numbers.get(value);
            Set<Integer> valuesOfNumbersToCompare = numbersGroupToCompare.numbers.keySet();
            for (int valueToCompare : valuesOfNumbersToCompare) {
                if (valueToCompare)
            }
        }
        return 0;
    }
}