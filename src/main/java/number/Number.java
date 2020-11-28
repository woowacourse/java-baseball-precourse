package number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number {

    private List<Integer> numbers;

    private Number(List<Integer> numbers) {
        this.numbers = validateDigitNumber(numbers);
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

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
