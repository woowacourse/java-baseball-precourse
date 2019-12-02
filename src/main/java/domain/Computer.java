package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :   김시영
 * @version :   1.0 2019년 11월 30일
 * @apiNote :   컴퓨터 역할을 수행하는 클래스로, 난수를 생성하는 기능을 가지고 있습니다.
 */
public class Computer {
    private static final String DEFALUT_STRING_BLANK = "";
    private static final int DIGIT_NUMBER = 3;
    private static final int RANGE_OF_NUMBER = 9;
    private static final int START_NUMBER = 1;

    public int makeRandomNumber() {
        Set<Integer> setForRandomNumber = new HashSet<>();
        String randomNumber = DEFALUT_STRING_BLANK;

        while (setForRandomNumber.size() < DIGIT_NUMBER) {
            setForRandomNumber.add(
                    (int) (Math.random() * RANGE_OF_NUMBER) + START_NUMBER
            );
        }
        for (int s : setForRandomNumber)
            randomNumber += String.valueOf(s);
        return Integer.parseInt(randomNumber);
    }
}
