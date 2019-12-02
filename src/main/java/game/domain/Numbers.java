
/*
 * Numbers.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static final int SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static final String INPUT_ERROR_MESSAGE = "잘못된 입력";
    private final List<Integer> numbers;

    /**
     * Create an numbers which is composed of three different digits from one to nine.
     * @param inputText
     * @throws RuntimeException
     */
    private Numbers(String inputText) throws Exception {
        numbers = verify(parse(inputText));
    }

    /**
     * This is a static factory method that converts input values
     * into three single digits after validation.
     * @param inputText
     * @return Numbers, that the inputText is divided into three single digits.
     */
    public static Numbers valueOf(String inputText) throws Exception {
        return new Numbers(inputText);
    }

    private List<Integer> parse(String inputText) {
        return inputText.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private List<Integer> verify(List<Integer> inputNumbers) throws Exception{
        List<Integer> refinedNumbers = removeInvalidElement(inputNumbers);
        if (refinedNumbers.size() != SIZE) {
            throw new RuntimeException(INPUT_ERROR_MESSAGE);
        }
        return refinedNumbers;
    }

    private List<Integer> removeInvalidElement(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .filter(this::isDigit)
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean isDigit(Integer integer) {
        return MIN_NUMBER <= integer && integer <= MAX_NUMBER;
    }

    public int getSize() {
        return numbers.size();
    }
}
