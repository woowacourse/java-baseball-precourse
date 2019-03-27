/*
 * 클래스 이름: Number.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/03/27
 * Copyright 2018 Inkwon Lee
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * 숫자들의 관한 클래스를 구현
 * computer 의 3자리 난수를 생성하는 클래스
 * player 의 3자리 수를 입력하는 클래스
 * player 의 입력값이 예외가 발생한경우 예오처리하는 함수 구현
 */
public class Number {

    /** 클래스 안에 클래스 holder를 두는 Singleton */
    private Number() { hashMap = new HashMap<>(); }
    private static class NumberHolder { public static final Number INSTANCE = new Number();}
    public static Number getInstance() { return NumberHolder.INSTANCE; }

    private HashMap<Integer, Integer> hashMap;

    /** 컴퓨터 3자리 난수 생성 함수 */
    public HashMap comNum() {

        if (!hashMap.isEmpty()) { // hashmap이 비어있지 않는경우 초기화
            hashMap.clear();
        }

        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * 9) + 1; // 난수 생성
            if (isOverLap(hashMap, num)) { // 숫자가 중복일 경우 i를 -1 빼 다시 난수 생성
                i -= 1;
                continue;
            }
            hashMap.put(i, num); // hashmap 에 난수를 넣음
        }
        return hashMap;
    }

    /** 컴퓨터 3자리난수 중복처리 함수
     *  hashmap 에 있는 수와 방금 만들어진 수가 같으면 true 로 리턴
     */
    private boolean isOverLap(HashMap hashMap, int num) {
        for (Object data : hashMap.values()) {
            if ((int) data == num){
                return true;
            }
        }
        return false;
    }

    /** playerNum 입력 함수, 예외처리 한 num 값을 리턴 시킨다.*/
    public String[] playerNum(BufferedReader br) throws IOException {

        System.out.print("숫자를 입력해 주세요 : ");
        String[] num = br.readLine().split(""); // 입력한 값을 split로 나뉘어줌
        return Number.getInstance().ExceptionPlayerNum(num);

    }

    /** playerNum이 Exception 생길때 예외처리 함수 */
    private String[] ExceptionPlayerNum(String[] num) {

        if (num.length != 3) { // 입력 값의 길이가 3이 아닐 경우
            System.out.println(ErrorMessage.LENGTH_ERROR.getErrorMessage());
            num[0] = "0";
            return num;
        }

        for (String data : num) { // 1~9까지의 숫자가 안올경우 예외처리
            char charData = data.charAt(data.length() - 1);
            if (charData <= 48 || charData >= 58) {
                System.out.println(ErrorMessage.NUMBER_FORMAT_ERROR.getErrorMessage());
                num[0] = "0";
                return num;
            }
        }

        if (num[0].equals(num[1]) || num[1].equals(num[2])
                || num[0].equals(num[2])) { // 중복일경우 예외처리
            System.out.println(ErrorMessage.OVERLAP_ERROR.getErrorMessage());
            num[0] = "0";
            return num;
        }

        return num;
    }

}
