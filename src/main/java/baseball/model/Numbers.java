package baseball.model;

import java.util.ArrayList;

public class Numbers {
    private static final int NUMBERS_LENGTH = 3;

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
}
