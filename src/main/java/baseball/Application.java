package baseball;

import java.util.LinkedHashSet;
import java.util.Iterator;
import camp.nextstep.edu.missionutils.Randoms;
import baseball.Input;

public class Application {
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 9;
    static final int INPUT_LEN = 3;

    public static void main(String[] args) {
        randomNumberGenerator(MIN_NUM, MAX_NUM, INPUT_LEN);
    }

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
