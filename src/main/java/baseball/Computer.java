package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber;

    public Computer() {
        this.randomNumber = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        boolean isDuplicate;

        do {
            isDuplicate = false;
            for (int i = 0; i < 3; i++) {
                int num = Randoms.pickNumberInRange(1, 9); // 1 ~ 9 난수 생성
                if (!numbers.contains(num)) {
                    numbers.add(num);
                } else {
                    isDuplicate = true;
                    break; // 중복이 발생하면 break -> 다시 시도
                }
            }

            if (isDuplicate) {
                numbers.clear();
            }
        } while (isDuplicate || numbers.size() < 3);

        return numbers;
    }

    public List<Integer> getRandomNumber() {
        return this.randomNumber;
    }

    public void resetRandomNumber() {
        this.randomNumber = generateRandomNumber();
    }
}
