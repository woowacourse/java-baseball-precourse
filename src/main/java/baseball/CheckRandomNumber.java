package baseball;

import utils.RandomUtils;

import java.util.Scanner;

/**
 * 조건에 맞는 난수를 생성하는 클래스
 */
public class CheckRandomNumber {

    private final static int START_NUMBER = 100;
    private final static int END_NUMBER = 999;
    private final Scanner scanner;

    CheckRandomNumber(Scanner scanner) {
        this.scanner = scanner;
    }

    CheckInputNumber checkInputNumber;

    public String makeRandomNumber() {
        String random = parseString(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
        checkInputNumber = new CheckInputNumber(scanner);
        if (!(checkInputNumber.isValid(random))) {
            return makeRandomNumber();
        }
        return random;
    }

    private String parseString(int input) {
        return String.valueOf(input);
    }
}
