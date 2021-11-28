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

    private String convert3DigitString(List<Integer> threeNumsList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(Integer.toString(threeNumsList.get(i)));
        }
        return stringBuilder.toString();
    }

    public String pickRandom3DigitNum() {
        String random3DigitNum;
        while (true) {
            List<Integer> random3NumsList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            if (isUnique(random3NumsList)) {
                random3DigitNum = convert3DigitString(random3NumsList);
                break;
            }
        }
        return random3DigitNum;
    }

}
