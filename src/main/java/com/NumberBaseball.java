package com;

import java.util.*;

/**
 * 숫자야구를 실행시킬 수 있는 클래스이다.
 * 기능 목록에 의거하여 구현됐다.
 */
public class NumberBaseball {
    static HashMap<Integer, Integer> com = new HashMap<>();

    public static void main(String[] args){
        setComNumber();         // 난수 발생

        Arrays.asList(com)
                .stream()
                    .forEach(System.out::print);    // 난수 출력
    }

    /**
     * 컴퓨터에 난수를 발생시키는 메소드
     * 중복을 피하며 1~9의 범위의 난수를 hashmap에 저장한다.
     */
    static void setComNumber(){
        int num = 0;

        for(int i=0; i<3;) {
            num = (int) (Math.random() * 10) + 1;

            if (num >= 10 || com.containsValue(num)) {
                continue;
            }

            com.put(i++, num);
        }
    }
}
