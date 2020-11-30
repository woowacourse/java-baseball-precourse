package baseball;

import utils.RandomUtils;

/**
 * 컴퓨터가 1에서 9까지의 서로 다른 임의의 수 3개를 정하게 하는 클래스
 *
 * @version 1.0 2020-11-29
 *
 */
public class Computer {
    private String number = "";

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

    /**
     * START 와 END 사이에 임의의 수를 만들어주는 메서드
     *
     * @return START 와 END 사이의 임의의 수를 반환
     */
    private int makeRandomNumber() {
        return RandomUtils.nextInt(START, END);
    }

    /**
     * makeRandomNumber()를 이용해 만든 임의의 수가 number에 있는 숫자인지 검사하는 메서드
     *
     * @param randomNum  makeRandomNumber()를 이용해 만든 임의의 수
     * @return 중복이면 true , 아니면 false
     */
    private boolean isDuplicateNumber(int randomNum) {
        return this.number.contains(String.valueOf(randomNum));
    }

    /**
     * isDuplicateNumber() 메서드로 중복 검사 후
     * 중복이 아니라면 number 변수에 임의의 수를 추가하는 메서드
     *
     * @param randomNum makeRandomNumber()를 이용해 만든 임의의 수
     */
    private void addNumber(int randomNum) {
        if (!isDuplicateNumber(randomNum)) {
            this.number += String.valueOf(randomNum);
        }
    }

    /**
     * number 변수를 가져오는 메서드
     *
     * @return number 변수를 반환
     */
    public String getNumber() {
        return this.number;
    }
}
