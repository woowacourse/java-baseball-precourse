package baseball;

import utils.RandomUtils;

/**
 * 조건에 맞는 난수를 생성하는 클래스
 */
public class CheckRandomNumber {

    private static final int START_NUMBER = 100;
    private static final int END_NUMBER = 999;

    public String makeRandomNumber() {
        String random = parseString(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
        CheckInputNumber checkInputNumber = new CheckInputNumber();
        if (!(checkInputNumber.isValid(random))) {
            return makeRandomNumber();
        }
        return random;
    }

    private String parseString(int input) {
        return String.valueOf(input);
    }
}
