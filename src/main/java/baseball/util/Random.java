package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    public static List<Integer> extractNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
