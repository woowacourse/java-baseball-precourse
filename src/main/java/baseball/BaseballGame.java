package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {

    private final int NUMBER_RANGE_START = 0;
    private final int NUMBER_RANGE_END = 1;
    private final int HOW_MANY_RANDOM_NUMBERS = 3;

    public BaseballGame() {

    }

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumList = Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_START, NUMBER_RANGE_END, HOW_MANY_RANDOM_NUMBERS);
        return randomNumList;
    }
}
