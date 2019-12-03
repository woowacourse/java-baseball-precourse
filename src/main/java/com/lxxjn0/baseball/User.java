/*
 * @(#)User.java        0.6 2019/12/03
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 사용자로부터 3자리 수를 입력받는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.6 2019/12/03
 */
public class User {
    /**
     * 입력해야 하는 수의 길이에 해당하는 상수
     */
    private static final int NUM_LEN_TO_ENTER = 3;

    /**
     * 각 자리에 입력될 숫자 범위의 하한 문자 상수
     */
    private static final char MIN_NUM = '1';

    /**
     * 각 자리에 입력될 숫자 범위의 상한 문자 상수
     */
    private static final char MAX_NUM = '9';

    /**
     * 게임을 다시 시작하는 입력을 확인하기 위한 문자열 상수
     */
    private static final String PLAY_AGAIN = "1";

    /**
     * 게임을 종료하는 입력을 확인하기 위한 문자열 상수
     */
    private static final String STOP = "2";

    /**
     * 사용자가 조건에 맞게 입력한 3자리 수를 Integer형으로 바꿔 저장할 ArrayList
     */
    private ArrayList<Integer> enteredNumber;

    /**
     * 사용자로부터 입력을 받아 저장해 둘 문자열
     */
    private String userInput;

    /**
     * 사용자로부터 받은 입력의 길이가 3인지, 1부터 9까지의 숫자가 아닌 입력이 존재하는지,
     * 또는 각 자리에 중복되는 수가 존재하는 지 판단하고,
     * 입력을 Integer로 변환 후 ArrayList에 저장하는 메서드.
     */
    public void receiveInput() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = sc.nextLine();
        } while (!isValidInput());
        enteredNumber = toIntegerArrayList();
    }

    /**
     * 사용자로부터 받은 입력의 길이가 3인지, 1부터 9까지의 숫자가 아닌 입력이 존재하는지,
     * 또는 각 자리에 중복되는 수가 존재하는 지 판단하고 유효하지 않은 입력이 들어왔을 경우,
     * 재입력을 요구하는 출력문 출력하는 메서드.
     *
     * @return 사용자의 입력이 유효한 경우 true 반환.
     */
    private boolean isValidInput() {
        /* if문의 조건 내부에 우선적으로 확인하면 좋은 예외 순서대로 입력 */
        if (!(isValidLength() && isValidNumber()
                && isNoDuplication())) {
            System.out.println("잘못된 입력입니다! 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    /**
     * 사용자의 입력의 길이가 3인지 여부를 확인하는 메서드.
     *
     * @return 사용자의 입력의 길이가 3인 경우 true 반환.
     */
    private boolean isValidLength() {
        return (userInput.length() == NUM_LEN_TO_ENTER);
    }

    /**
     * 사용자의 입력의 각 자리가 1 ~ 9까지의 숫자로 이루어져 있는지 확인하는 메서드.
     *
     * @return 각 자리가 1부터 9까지 범위 내의 숫자일 경우 true 반환.
     */
    private boolean isValidNumber() {
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if ((c < MIN_NUM) || (c > MAX_NUM)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자의 입력의 각 자리에 중복된 수가 존재하는지 확인하는 메서드.
     *
     * @return 각 자리가 서로 다른 수일 경우 true 반환.
     */
    private boolean isNoDuplication() {
        for (int i = 0; i < userInput.length(); i++) {
            if (isDuplicatePosition(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 해당 position 위치의 문자가 문자열의 다른 위치에 존재하는지(중복되는지) 확인하는 메서드.
     *
     * @param position 중복 여부를 확인하고 싶은 자리.
     * @return 해당 position이 아닌 자리에 동일한 문자가 존재 시 true 반환.
     */
    private boolean isDuplicatePosition(int position) {
        for (int i = 0; i < userInput.length(); i++) {
            if ((userInput.charAt(position) == userInput.charAt(i))
                    && (i != position)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 사용자의 입력을 Integer형 ArrayList로 변환해주는 메서드.
     *
     * @return 사용자의 입력을 Integer형 ArrayList로 변환한 tmp 반환.
     */
    private ArrayList<Integer> toIntegerArrayList() {
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            tmp.add(userInput.charAt(i) - '0');
        }
        return tmp;
    }

    /**
     * 사용자로부터 1을 입력받으면 다시 시작, 2를 입력받으면 종료하는 상태를 반환하는 메서드.
     *
     * @return 다시 시작(PLAY_AGAIN)을 입력받은 경우 true 반환
     */
    public boolean receivePlayAgainInput() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = sc.nextLine();
        } while (!isValidPlayAgainInput());

        return userInput.equals(PLAY_AGAIN);
    }

    /**
     * 사용자의 입력이 1또는 2가 아닌 다른 유효하지 않은 입력인지를 판단하고,
     * 유효하지 않은 입력의 경우 재입력을 요구하는 출력문 출력하는 메서드.
     *
     * @return 입력이 1(PLAY_AGAIN)또는 2(STOP)일 경우 true 반환.
     */
    private boolean isValidPlayAgainInput() {
        if (!(userInput.equals(PLAY_AGAIN) || userInput.equals(STOP))) {
            System.out.println("잘못된 입력입니다! 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    /**
     * enteredNumber getter
     *
     * @return 사용자의 입력을 Integer형으로 변환한 enteredNumber 반환.
     */
    public ArrayList<Integer> getEnteredNumber() {
        return enteredNumber;
    }
}
