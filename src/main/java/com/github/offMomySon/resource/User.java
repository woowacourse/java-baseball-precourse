package com.github.offMomySon.resource;

import java.util.*;

/**
 * @desc : User Class
 * 사용자로 부터 유효한 3개의 수를 입력 받는다.
 * 사용자로 부터 게임 시작, 종료를 입력 받는다.
 * 입력 받은 수를 List와 HashMap 을 이용하여 저장한다.
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
     * @desc : 사용자로부터 숫자를 입력 받아. 인스턴스 변수, numsMap, numsList 에 저장.
     */
    public void inputNums() {
        String num_string;
        num_string = getValid_NumStirng();

        for (int i = 0; i < num_string.length(); i++) {
            int num = num_string.charAt(i) - '0';
            numsMap.put(num, num);
            numsList.add(num);
        }
    }

    /**
     * @return (1 ~ 9)까지의 3가지 수로 변환가능한 String
     * @desc : 사용자로부터 변환가능한 String 을 입력받을 때까지 반복.
     */
    private String getValid_NumStirng() {
        String num_string;

        System.out.print("숫자를 입력해주세요 : ");
        while (true) {
            num_string = scanner.nextLine();
            if (isValidNums(num_string))
                break;

            System.out.print("유효한 숫자를 입력해 주세요 : ");
        }
        return num_string;
    }

    /**
     * @param num_string : 사용자로부터 입력받은 String
     * @return 입력받은 String 이 유효하면 true 리턴
     * @desc : 사용자로부터 입력받은 String 이 서로다른 (1~9 까지의) 3가지의 숫자가 될수 있는지 검사.
     */
    private boolean isValidNums(String num_string) {
        HashSet<Integer> numsSet = new HashSet<>();

        if (num_string.length() > 3)
            return false;
        for (int i = 0; i < num_string.length(); i++) {
            int eachNum = num_string.charAt(i) - '0';

            if (eachNum <= 0 || eachNum >= 10)
                return false;

            numsSet.add(eachNum);
        }

        if (numsSet.size() != 3)
            return false;

        return true;
    }

    /**
     * @return 유저가 입력한 (1~9)까지의 3가지 수를 List Class 로 Return
     */
    public List<Integer> getNumsList() {
        return numsList;
    }

    /**
     * @return 유저가 입력한 (1~9)까지의 3가지 수를 HashMap Class 로 Return
     */
    public HashMap<Integer, Integer> getNumsMap() {
        return numsMap;
    }
}
