package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class Application {
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;
    static final int INPUT_LEN = 3;

    public static void main(String[] args) {
        randomNumberGenerator(MIN_NUM, MAX_NUM, INPUT_LEN);

    }

    public static String randomNumberGenerator(int startInclusive, int endInclusive, int count) {
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();
        while (randomNumberSet.size() < count) {
            randomNumberSet.add(Integer.valueOf(Randoms.pickNumberInRange(startInclusive, endInclusive)));
        }

        Iterator<Integer> randomNumberIter = randomNumberSet.iterator();
        String randomNumberStr = "";
        while (randomNumberIter.hasNext()) {
            randomNumberStr += randomNumberIter.next() + "";
        }

        return randomNumberStr;
    }
}
