package number;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public int countBall() {
        List<Integer> number = numbers.get(0).getNumbers();
        List<Integer> targetNumber = numbers.get(1).getNumbers();
        int ballCount = 0;
        for (int index = 0; index < number.size(); index++) {
            if (isBall(index, number, targetNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int countStrike() {
        List<Integer> number = numbers.get(0).getNumbers();
        List<Integer> targetNumber = numbers.get(1).getNumbers();
        int strikeCount = 0;
        for (int index = 0; index < number.size(); index++) {
            if (isStrike(index, number, targetNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isBall(int index, List<Integer> number, List<Integer> targetNumber) {
        for (int targetIndex = 0; targetIndex < targetNumber.size(); targetIndex++) {
            if (targetIndex == index) {
                continue;
            }
            if (number.get(index) == targetNumber.get(targetIndex)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrike(int index, List<Integer> number, List<Integer> targetNumber) {
        for (int targetIndex = 0; targetIndex < targetNumber.size(); targetIndex++) {
            if (targetIndex != index) {
                continue;
            }
            if (number.get(index) == targetNumber.get(targetIndex)) {
                return true;
            }
        }
        return false;
    }
}
