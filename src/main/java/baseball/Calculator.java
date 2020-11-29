package baseball;

import java.util.List;

public class Calculator {
    private List<Integer> targetNumber;
    private List<Integer> inputNumber;

    private int countBall() {
        return countOverlap() - countStrike();
    }

    private int countStrike() {
        int index = 0;
        int count = 0;
        for (int num : targetNumber) {
            if (inputNumber.get(index) ==  num){
                count += 1;
            }
            index += 1;
        }
        return count;
    }

    private int countOverlap() {
        int count = 0;
        for (int num : targetNumber) {
            if (inputNumber.contains(num)){
                count += 1;
            }
        }
        return count;
    }
}
