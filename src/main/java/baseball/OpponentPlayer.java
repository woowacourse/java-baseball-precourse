package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class OpponentPlayer {

    OpponentPlayer() {

    }

    public String pickRandom3DigitNum() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> random3NumsList = Randoms.pickUniqueNumbersInRange(0, 9, 3);
        for (int i = 0; i < 3; i++) {
             stringBuilder.append(Integer.toString(random3NumsList.get(i)));
        }
        return stringBuilder.toString();
    }

}
