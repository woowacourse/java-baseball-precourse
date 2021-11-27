package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class OpponentPlayer {

    OpponentPlayer() {

    }

    private boolean isUnique(List<Integer> threeNumList) {
        if (threeNumList.get(0).equals(threeNumList.get(1))) {
            return false;
        }
        if (threeNumList.get(1).equals(threeNumList.get(2))) {
            return false;
        }
        if (threeNumList.get(0).equals(threeNumList.get(2))) {
            return false;
        }
        return true;
    }

    public String pickRandom3DigitNum() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> random3NumsList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        while (true)
        {
            for (int i = 0; i < 3; i++) {
                stringBuilder.append(Integer.toString(random3NumsList.get(i)));
            }
            if (isUnique(random3NumsList))
                break;
        }
        String random3DigitNum = stringBuilder.toString();
        return random3DigitNum;
    }

}
