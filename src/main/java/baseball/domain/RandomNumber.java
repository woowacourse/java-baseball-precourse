package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumber {
    private ArrayList<Integer> numbers;
    private static final int NUMBER_SIZE = 3;

    public RandomNumber() {
        numbers = new ArrayList<>();
    }

    public void init() {
        resetRandomNumber();
        createRandomNumber();
    }

    private void createRandomNumber() {
        while (numbers.size() != NUMBER_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
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

//    public void showRandomNumber() {
//        System.out.println(numbers);
//    }
}
