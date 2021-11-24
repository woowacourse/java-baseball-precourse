package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final int DIGIT = 3;

    private String makeRandNum () {
        StringBuilder RandNum = new StringBuilder();

        while (RandNum.length() < DIGIT) {
            String temp = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!RandNum.toString().contains(temp)) {
                RandNum.append(temp);
            }
        }

        return String.valueOf(RandNum);
    }
}
