package baseball;

import java.util.HashSet;
import java.util.Set;
import utils.RandomUtils;

public class BaseBall {
    private static final int RADIX = 10;
    private static final int DIGIT_NUM = 3;
    private String userNum;
    private String randNum;

    public BaseBall() {
        userNum = "";
        randNum = "";
    }

    public void init() {
        randNum = makeRandNum(DIGIT_NUM);
    }

    private String makeRandNum(final int digit) {
        Set<Character> randNumSet = new HashSet<>();
        int cnt = 0;
        String result = "";

        while (cnt < digit) {
            char temp = Character.forDigit(RandomUtils.nextInt(1, 9), RADIX);

            if (randNumSet.contains(temp)) {
                continue;
            }

            randNumSet.add(temp);
            result += temp;
            cnt++;
        }

        return result;
    }
}
