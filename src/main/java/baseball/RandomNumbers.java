package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNumbers {
    private List<Integer> numbers = new ArrayList<>();

    public RandomNumbers() {
        createNumbers();
    }

    private void createNumbers() {
        while (numbers.size() < 3) {
            int value = Randoms.pickNumberInList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            if (validationNumber(value)) {
                numbers.add(value);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean validationNumber(int number) {
        return !numbers.contains(number);
    }
}
