/*
 * @(#)Computer.java        0.1 2019/12/01
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 사용자로부터 3자리 수를 입력받는 클래스.
 *
 * @version         0.1 2019/12/01
 * @author          JUNYOUNG LEE (lxxjn0)
 */
public class User {
    /** 입력해야 하는 수의 길이를 저장한 상수 */
    private static final int NUM_LEN = 3;
    /** 각 자리에 입력될 숫자 범위의 상한 문자 상수 */
    private static final int MAX_NUM = '9';
    /** 각 자리에 입력될 숫자 범위의 하한 문자 상수 */
    private static final int MIN_NUM = '1';
    /** 게임을 다시 시작하는 입력을 확인하기 위한 문자열 상수 */
    private static final String CONTINUE = "1";
    /** 게임을 종료하는 입력을 확인하기 위한 문자열 상수 */
    private static final String STOP = "2";
    /** 조건에 맞게 사용자가 입력한 3자리 수를 저장할 ArrayList */
    private ArrayList<Integer> numList;

    /**
     * User 클래스의 생성자.
     * 사용자로부터 입력을 받아 3자리 수가 입력되지 않은 예외(1번), 3자리 수 중에서 같은 수가 입력된 예외(2번),
     * 0이 입력된 예외(3번)를 처리하고 입력을 Integer로 변환 후 ArrayList에 저장.
     */
    public User() {
        String userInput = "";
        Scanner sc = new Scanner(System.in);

        /* 예외 1번과 예외 3번에 대한 처리 진행. */
        do {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = sc.next();
        }while(!inputValidCheck(userInput));
        numList = inputToArrayList(userInput);
    }

    /**
     * 사용자로부터 받은 입력의 길이가 3인지 여부(1번)와 숫자가 아닌 입력(1번)과 0의 존재(2번)를 확인 후 입력의 유효성 반환하는 메서드.
     * @param userInput 사용자의 입력이 저장된 문자열.
     * @return 사용자의 입력이 유효한 경우 true 반환.
     *         false 인 경우 유효하지 않은 입력이 들어왔다는 출력문 출력.
     */
    private boolean inputValidCheck(String userInput) {
        boolean validCheck = true;

        if(!inputLengthCheck(userInput)) {
            validCheck = false;
        }
        else {
            validCheck = inputNumberCheck(userInput);
            if (!validCheck) {
                System.out.println("잘못된 입력입니다! 조건을 확인한 후 다시 입력해주세요.\n" +
                        "(조건 : 1부터 9까지 서로 다른 수로 이루어진 3자리의 수)");
            }
        }
        return validCheck;
    }

    /**
     * 사용자의 입력의 길이가 3인지 여부를 확인하는 메서드.
     * @param userInput 사용자의 입력이 저장된 문자열.
     * @return 사용자의 입력의 길이가 3인 경우 true 반환.
     */
    private boolean inputLengthCheck(String userInput) {
        return (userInput.length() == NUM_LEN);
    }

    /**
     * 사용자의 입력의 각 자리가 1 ~ 9까지의 숫자로 이루어져 있는지 확인하는 메서드.
     * @param userInput 사용자의 입력이 저장된 문자열(길이가 3이라는 유효성 검증 완료).
     * @return 각 자리가 1부터 9까지 범위 내의 숫자일 경우 true 반환.
     */
    private boolean inputNumberCheck(String userInput) {
        boolean numberValidCheck = true;

        for(int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if(c < MIN_NUM || c > MAX_NUM) {
                numberValidCheck = false;
                break;
            }
        }

        if(numberValidCheck) {
            numberValidCheck = inputDuplicateCheck(userInput);
        }
        return numberValidCheck;
    }

    /**
     * 사용자의 입력의 각 자리에 중복된 수가 존재하는지 확인하는 메서드.
     * @param userInput 사용자의 입력이 저장된 문자열(1부터 9까지의 3자리 수라는 유효성 검증 완료).
     * @return 각 자리가 서로 다른 수일 경우 true 반환.
     */
    private boolean inputDuplicateCheck(String userInput) {
        int tmp;
        boolean duplicateValidCheck = true;

        for(int i = 1; i < userInput.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(userInput.charAt(i) == userInput.charAt(j)) {
                    duplicateValidCheck = false;
                    break;
                }
            }
            if(!duplicateValidCheck) {
                break;
            }
        }
        return duplicateValidCheck;
    }

    /**
     * 사용자의 입력을 ArrayList로 변환해주는 메서드.
     * @param userInput 사용자의 입력이 저장된 문자열(모든 유효성 검사 완료).
     * @return tmpList 사용자의 입력을 Integer형 ArrayList로 변환.
     */
    private ArrayList<Integer> inputToArrayList(String userInput) {
        ArrayList<Integer> tmpList = new ArrayList<Integer>();

        for(int i = 0; i < userInput.length(); i++) {
            tmpList.add(userInput.charAt(i) - '0');
        }
        return tmpList;
    }

    /**
     * numList getter
     * @return 사용자의 입력을 Integer ArrayList로 변환해서 반환.
     */
    public ArrayList<Integer> getNumList() {
        return numList;
    }

    /**
     * 사용자로부터 입력을 받아서 1을 입력받으면 다시 시작, 2를 입력받으면 종료하는 상태를 반환하는 메서드.
     * @return 다시 시작을 입력받은 경우 true를 반환
     */
    public boolean continueCheck() {
        String userInput = "";
        boolean continueStat = true;
        boolean validCheck = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
            userInput = sc.next();
            if(userInput.equals(CONTINUE)) {
                continueStat = true;
                validCheck = true;
            }
            else if(userInput.equals(STOP)) {
                continueStat = false;
                validCheck = true;
            }
            else {
                System.out.println("잘못된 입력입니다! 조건을 확인한 후 다시 입력해주세요.");
                validCheck = false;
            }
        }while(!validCheck);

        return continueStat;
    }
}
