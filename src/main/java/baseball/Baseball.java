package baseball;

import utils.RandomUtils;

public class Baseball {
    private int[] numbers = {0, 0, 0}; // 정답

    public Baseball() {
        rand();
    }

    public int numberAt(int index) {
        return numbers[index];
    }

    private boolean contains(int num) {
        for (int number : numbers) {
            if (number == num) {
                return true;
            }
        }
        return false;
    }

    private void setNumber(int index) {
        int num = RandomUtils.nextInt(1, 9);
        while (contains(num)) {
            num = RandomUtils.nextInt(1, 9);
        }
        numbers[index] = num;
    }

    public void rand() {
        for (int i=0; i<3; i++) {
            setNumber(i);
        }
    }
}