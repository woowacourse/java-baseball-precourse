package baseball;

import utils.RandomUtils;

public class Computer {
    private String number="";

    private static final int SIZE = 3;
    private static final int START = 1;
    private static final int END = 9;

    public Computer() {
        StringBuilder sb = new StringBuilder();
        int randomNum;

        while (sb.length() < SIZE) {
            randomNum = RandomUtils.nextInt(START, END);

            if (!number.contains(String.valueOf(randomNum))) {
                sb.append(randomNum);
            }
        }
        number = sb.toString();
    }

    public String getNumber() {
        return number;
    }
}
