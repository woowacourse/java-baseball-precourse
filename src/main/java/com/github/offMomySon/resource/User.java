package com.github.offMomySon.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @desc : User Class
 * 사용자로 부터 유효한 3개의 수를 입력 받는다.
 * 입력 받은 수를 List와 HashMap 을 이용하여 저장한다.
 * <p>
 * 사용자로 부터 게임 시작, 종료를 입력 받는다.
 * @pakage : com.github.offMomySon.resource
 * @authon : 오지훈
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
     * @desc : 사용자로부터 숫자를 입력 받아.
     * 인스턴스 변수, numsMap, numsList 에 저장.
     */
    public void inputNums() {
        String num_string = scanner.nextLine();

        for (int i = 0; i < num_string.length(); i++) {
            int num = num_string.charAt(i) - '0';
            numsMap.put(num, num);
            numsList.add(num);
        }
    }


    /**
     * @desc : User class의  인스턴스 변수 getter
     */
    public List<Integer> getNumsList() {
        return numsList;
    }

    public HashMap<Integer, Integer> getNumsMap() {
        return numsMap;
    }
}
