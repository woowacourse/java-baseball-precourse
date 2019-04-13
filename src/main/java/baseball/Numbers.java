package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        Set numberSet = new HashSet(numbers);

        if (numberSet.size() != 3) {
            System.out.println("서로 다른 숫자 세개를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isStrike(int index, int number) {
        if (numbers.get(index) == number) {
            return true;
        }

        return false;
    }

    public boolean isBall(int number) {
        if (numbers.contains(number)) {
            return true;
        }

        return false;
    }
}
