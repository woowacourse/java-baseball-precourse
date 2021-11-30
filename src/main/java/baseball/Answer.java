package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Answer {
    List<Integer> numbers;

    public Answer() {
        initAnswer();
    }

    private void initAnswer() {
        numbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numbers.add(getUniqueNumber());
        }
    }

    private int getUniqueNumber() {
        int number;

        while (true) {
            number = Randoms.pickNumberInRange(0, 9);

            if (!numbers.contains(number)) return number;
        }
    }

    public boolean isStrike(int idx, int number) {
        return numbers.get(idx) == number;
    }

    public boolean isBall(int number) {
        return numbers.contains(number);
    }
}
