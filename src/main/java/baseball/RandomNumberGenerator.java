package baseball;

import utils.RandomUtils;

/**
 * 조건에 맞는 난수를 생성하는 클래스
 */
public class RandomNumberGenerator {

    private static final int START_NUMBER = 100;
    private static final int END_NUMBER = 999;

    public String makeRandomNumber() {
        String random = String.valueOf(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
        InputValidator inputValidator = new InputValidator();
        if (!inputValidator.isValid(random)) {
            return makeRandomNumber();
        }
        return random;
    }
}
