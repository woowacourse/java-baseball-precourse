package number;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number {

    private List<Integer> number;

    private Number(List<Integer> number) {
        this.number = validateDigitNumber(number);
    }

    public static Number of(List<Integer> numbers) {
        return new Number(numbers);
    }

    public List<Integer> validateDigitNumber(List<Integer> numbers) {
        List<Integer> validatedList = new ArrayList<>();
        numbers.stream()
                .forEach(number -> {
                    if (!validatedList.contains(number)) {
                        validatedList.add(number);
                    }
                });
        if (validatedList.size() != numbers.size()) {
            throw new IllegalArgumentException("각 자릿 수는 모두 달라야 합니다");
        }
        return validatedList;
    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(number);
    }

    public static List<Integer> createRandoms(int numberSize) {
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
