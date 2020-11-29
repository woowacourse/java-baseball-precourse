package baseball;

import utils.ListUtils;

import java.util.List;

public class Calculator {
    private List<Integer> targetDigitsList;
    private List<Integer> InputDigitsList;

    public Calculator(int targetNumber, int inputNumber) {
        this.targetDigitsList = ListUtils.intToDigitsList(targetNumber);
        this.InputDigitsList = ListUtils.intToDigitsList(inputNumber);
    }

    public int countBall() {
        return countOverlap() - countStrike();
    }

    public int countStrike() {
        int index = 0;
        int count = 0;
        for (int num : targetDigitsList) {
            if (InputDigitsList.get(index) ==  num){
                count += 1;
            }
            index += 1;
        }
        return count;
    }

    private int countOverlap() {
        int count = 0;
        for (int num : targetDigitsList) {
            if (InputDigitsList.contains(num)){
                count += 1;
            }
        }
        return count;
    }
}
