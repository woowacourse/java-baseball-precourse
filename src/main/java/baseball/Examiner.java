package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Examiner {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int NUMBER_LENGTH = 3;

    private List<Integer> randomNumberList;

    public void init() {
        generateNewNumberList();
    }

    public void generateNewNumberList() {
        randomNumberList = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_LENGTH);
    }

    public int countStrike(List<Integer> inputNumberList) {
        int strikeCount = 0;

        for (int i = 0 ; i < NUMBER_LENGTH ; i++) {
            if (isStrike(randomNumberList, inputNumberList, i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public boolean isStrike(List<Integer> randomNumberList,
                            List<Integer> inputNumberList,
                            int index) {
        return randomNumberList.get(index).equals(inputNumberList.get(index));
    }

}
