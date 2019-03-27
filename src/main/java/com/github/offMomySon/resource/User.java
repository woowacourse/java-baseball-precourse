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
        num_string = inputNumStirng();
        saveNums(num_string);
    }

    /**
     * @param input (1~9)까지의 3가지 수로 변환 가능한 String
     * @desc :사용자로 부터 받아온 String 을 int 로 변환하여 저장한다.
     */
    private void saveNums(String input) {
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            numsMap.put(num, num);
            numsList.add(num);
        }
    }

    /**
     * @return (1 ~ 9)까지의 3가지 수로 변환가능한 String
     * @desc : 사용자로부터 변환가능한 String 을 입력받을 때까지 반복.
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
     * @param num_string : 사용자로부터 입력받은 String
     * @return 입력받은 String 이 유효하면 true 리턴
     * @desc : 사용자로부터 입력받은 String 이 서로다른 (1~9 까지의) 3가지의 숫자가 될수 있는지 검사.
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
     * @return 게임 재시작이면 true 리턴, 종료면 false 리턴
     * @desc 게임 재시작 여부를 묻는 함수.
     * 1을 입력하면 재시작,
     * 2를 입력하면 종료,
     * 다른 키를 입력하면 다시 게임 재시작 여부를 묻는다.
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
