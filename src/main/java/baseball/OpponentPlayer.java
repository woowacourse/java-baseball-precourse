package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class OpponentPlayer {

    OpponentPlayer() {

    }

    public String pickRandom3DigitNum() {
        List<Integer> random3NumsList = Randoms.pickUniqueNumbersInRange(0, 9, 3);
        String random3DigitNum = "";
        for (int i = 0; i < 3; i++) {
            random3DigitNum += Integer.toString(random3NumsList.get(i));
        }
        return random3DigitNum;
    }

}
