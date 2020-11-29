package number;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number {

    private List<Integer> numbers;

    private Number(List<Integer> numbers) {
        this.numbers = numbers;
        validateNaturalNumber();
        validateDigitNumber();
    }

    public static Number of(List<Integer> numbers) {
        return new Number(numbers);
    }

    private void validateDigitNumber() {
        List<Integer> validates = new ArrayList<>();
        this.numbers.stream()
                .forEach(number -> {
                    if (!validates.contains(number)) {
                        validates.add(number);
                    }
                });
        if (validates.size() != numbers.size()) {
            throw new IllegalArgumentException("각 자릿 수는 모두 달라야 합니다");
        }
    }

    private void validateNaturalNumber() {
        if (this.numbers.contains(0)) {
            throw new IllegalArgumentException("자연수만 입력해 주세요");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static List<Integer> createRandoms(int numberSize) {
        List<Integer> randoms = new ArrayList<>();
        int randomNumber;
        for (int i = 0; i < numberSize; i++) {
            randomNumber = RandomUtils.nextInt(1, 9);
            if (!randoms.contains(randomNumber)) {
                randoms.add(randomNumber);
                continue;
            }
            i--;
        }
        return randoms;
    }
}
