/*
 * User Class
 *
 * @version 1.1
 *
 * @date 2019-3-28
 *
 * Copyright (c) 2019 Jihun oh.
 * All rights reserved.
 */
package com.github.offMomySon.resource;

import java.util.*;

/**
 * 사용자로부터 유효한 3개의 수를 입력받으며,
 * 사용자로부터 게임 시작, 종료를 입력받으며,
 * 입력받은 수를 List 와 HashMap 을 이용하여 저장하는 클래스.
 */
public class User {
    static Scanner scanner = new Scanner(System.in);

    private HashMap<Integer, Integer> numsMap;
    private List<Integer> numsList;

    public User() {
        numsMap = new HashMap<>();
        numsList = new ArrayList<>();
    }

    /**
     * 사용자로부터 숫자를 입력받아. 인스턴스 변수, numsMap, numsList 에 저장.
     */
    public void inputNums() {
        String num_string;
        initValue();
        num_string = inputNumStirng();
        saveNums(num_string);
    }

    /**
     * 사용자로부터 입력되었던 값들 초기화 한다.
     */
    public void initValue() {
        numsMap.clear();
        numsList.clear();
    }

    /**
     * 사용자로부터 받아온 String 을 int 로 변환하여 저장한다.
     *
     * @param input (1~9)까지의 3가지 수로 변환 가능한 String
     */
    private void saveNums(String input) {
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            numsMap.put(num, num);
            numsList.add(num);
        }
    }

    /**
     * 사용자로부터 변환 가능한 String 을 입력받을 때까지 반복한다.
     *
     * @return (1 ~ 9)까지의 3가지 수로 변환 가능한 String
     */
    private String inputNumStirng() {
        String num_string;

        while (true) {
            num_string = scanner.nextLine();
            if (isValidNums(num_string))
                break;
            System.out.print("유효한 숫자를 입력해 주세요 : ");
        }

        return num_string;
    }

    /**
     * 사용자로부터 입력받은 String이 서로 다른 (1~9 까지의) 3가지의 숫자가 될 수 있는지 검사한다.
     *
     * @param num_string 사용자로부터 입력받은 String
     * @return 입력받은 String 이 유효하면 true 리턴.
     */
    private boolean isValidNums(String num_string) {
        HashSet<Integer> numsSet = new HashSet<>();

        /*입력된 Stirng 의 길이가 3을 넘지 말아야 한다.*/
        if (num_string.length() > 3)
            return false;

        /*입력된 각각의 문자가 1~9 사이의 수여야 한다.*/
        for (int i = 0; i < num_string.length(); i++) {
            int eachNum = num_string.charAt(i) - '0';
            if (eachNum <= 0 || eachNum >= 10)
                return false;
            numsSet.add(eachNum);
        }

        /*입력된 숫자중에 중복된 숫자가 있으면 안된다.*/
        if (numsSet.size() != 3)
            return false;

        return true;
    }

    /**
     * 게임 재시작 여부를 묻는 함수.
     * 1을 입력하면 재시작,
     * 2를 입력하면 종료,
     * 다른 키를 입력하면 다시 게임 재시작 여부를 묻는다.
     *
     * @return 게임 재시작이면 true 리턴, 종료 면 false 리턴
     */
    public boolean isContinue() {
        String string;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            string = scanner.nextLine();

            if (string.equals("1"))
                return true;
            else if (string.equals("2"))
                return false;
            else
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    /**
     * @return 유저가 입력한 (1~9)까지의 3가지 수를 List 로 리턴.
     */
    public List<Integer> getNumsList() {
        return numsList;
    }

    /**
     * @return 유저가 입력한 (1~9)까지의 3가지 수를 HashMap 으로 리턴.
     */
    public HashMap<Integer, Integer> getNumsMap() {
        return numsMap;
    }
}
