package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class OpponentPlayer {

    OpponentPlayer() {

    }

    private String pick3DigitNum() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            int random1DigitNum = Randoms.pickNumberInRange(1, 9);
            result = result.concat(Integer.toString(random1DigitNum));
        }
        return result;
    }

    private boolean isUnique(String target) {
        if (target.charAt(0) == target.charAt(1)) {
            return false;
        }
        if (target.charAt(0) == target.charAt(2)) {
            return false;
        }
        if (target.charAt(1) == target.charAt(2)) {
            return false;
        }
        return true;
    }

    public String pickUnique3DigitNum() {
        String result;
        do {
            result = pick3DigitNum();
        } while (!isUnique(result));
        return result;
    }

}
