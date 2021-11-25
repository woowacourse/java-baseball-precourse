package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examiner {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int NUMBER_LENGTH = 3;

    private List<Integer> randomNumberList = new ArrayList<>();

    public Examiner() {}

    public void init() {
        generateNewNumberList();
    }

    public void generateNewNumberList() {
        int randomNumber;
        clearNumberList();
        while (randomNumberList.size() < NUMBER_LENGTH) {
            randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
    }

    private void clearNumberList() {
        randomNumberList.clear();
    }

    public int countStrike(List<Integer> inputNumberList) {
        int strikeCount = 0;

        for (int i = 0 ; i < NUMBER_LENGTH ; i++) {
            if (isStrike(inputNumberList, i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private boolean isStrike(List<Integer> inputNumberList, int index) {
        return randomNumberList.get(index).equals(inputNumberList.get(index));
    }

    public int countBall(List<Integer> inputNumberList) {
        int ballCount = 0;

        for (int i = 0 ; i < NUMBER_LENGTH ; i++) {
            if (isBall(inputNumberList, i)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean isBall(List<Integer> inputNumberList, int index) {
        return !isStrike(inputNumberList, index) && randomNumberList.contains(inputNumberList.get(index));
    }

    public boolean isNothing(List<Integer> inputNumberList) {
        for (int number : inputNumberList) {
            if (randomNumberList.contains(number)) {
                return false;
            }
        }

        return true;
    }

    public boolean isCorrect(List<Integer> inputNumberList) {
        return Arrays.equals(randomNumberList.toArray(), inputNumberList.toArray());
    }
}