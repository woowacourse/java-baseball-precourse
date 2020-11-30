package baseball;

import utils.RandomUtils;
import java.util.ArrayList;
import java.util.HashSet;

public class RandomNumberGenerator {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private RandomNumberGenerator() {
    }

    public static Digits makeRandomNumber() {
        HashSet<Integer> number = new HashSet<Integer>();

        while (number.size() < NUMBER_LENGTH) {
            number.add(RandomUtils.nextInt(MIN, MAX));
        }
        ArrayList<Integer> temp2 = new ArrayList<Integer>(number);
        return new Digits(temp2.get(0)*100 + temp2.get(1)*10+temp2.get(2));
    }

}
