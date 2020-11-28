package baseball;

import utils.RandomUtils;

public class Computer {
    private String number="";

    private static final int SIZE = 3;
    private static final int START = 1;
    private static final int END = 9;

    public Computer() {
        int randomNum;

        while (number.length() < SIZE) {
            randomNum = makeRandomNumber();
            addNumber(randomNum);
        }
    }

    private int makeRandomNumber() {
        return RandomUtils.nextInt(START, END);
    }

    private boolean isDuplicateNumber(int randomNum) {
        return number.contains(String.valueOf(randomNum));
    }

    public void addNumber(int randomNum) {
        if (!isDuplicateNumber(randomNum)) {
            number += String.valueOf(randomNum);
        }
    }

    public String getNumber() {
        return number;
    }
}
