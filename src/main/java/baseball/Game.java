package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final int DIGIT = 3;

    private String makeRandNum () {
        StringBuilder randNum = new StringBuilder();

        while (randNum.length() < DIGIT) {
            String temp = Integer.toString(Randoms.pickNumberInRange(1, 9));

            if (!randNum.toString().contains(temp)) {
                randNum.append(temp);
            }
        }

        return String.valueOf(randNum);
    }
}
