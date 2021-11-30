package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static baseball.util.Constant.*;

public class RandomNumber {
    private ArrayList<Integer> numbers;

    public RandomNumber() {
        numbers = new ArrayList<>();
    }

    public void init() {
        resetRandomNumber();
        createRandomNumber();
    }

    private void createRandomNumber() {
        while (numbers.size() != NUMBER_SIZE) {
            int num = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
    }

    public int getByIndex(int index) {
        return numbers.get(index);
    }

    public boolean contains(int userNumber) {
        return numbers.contains(userNumber);
    }

    public void resetRandomNumber() {
        numbers.clear();
    }

}
