package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;

import baseball.Input;

public class Game {
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;
    static final int INPUT_LEN = 3;

    public static String randomNumberGenerator(int startInclusive, int endInclusive, int count) {
        LinkedHashSet<Integer> randomNumber = new LinkedHashSet<>();
        while (randomNumber.size() < count) {
            randomNumber.add(Integer.valueOf(Randoms.pickNumberInRange(startInclusive, endInclusive)));
        }

        Iterator<Integer> randomNumberIter = randomNumber.iterator();
        String resultRandomNumber = "";
        while (randomNumberIter.hasNext()) {
            resultRandomNumber += randomNumberIter.next() + "";
        }

        return resultRandomNumber;
    }
}
