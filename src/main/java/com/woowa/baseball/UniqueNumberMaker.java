/**
 * UniqueNumberMaker.java
 */

package com.woowa.baseball;


import java.util.HashSet;
import java.util.Set;

/**
 * 서로가 중복되지 않는 고유한 숫자를 생성하여
 * UniqueNumber 인스턴스를 생성하는 객체입니다.
 *
 * @version     1.0
 * @since       03/24/2019
 * @author      icarus8050
 */
public class UniqueNumberMaker {

    /**
     * 서로가 중복되지 않는 숫자 3개를 담은 UniqueNumber 인스턴스를 생성합니다.
     *
     * @return  숫자 야구 게임의 정답을 담은 UniqueNumber
     */
    public UniqueNumber create() {
        int[] uniqueNumber = new int[3];            // 유니크한 숫자들을 담을 배열
        Set<Integer> numberSet = new HashSet<>();   // 중복된 숫자를 체크하기 위한 HashSet

        numberSet.add(0);   // 1 ~ 9까지의 숫자만 담을 수 있도록 0을 제외

        for (int i = 0; i < uniqueNumber.length; i++) {
            int number = 0;

            while (numberSet.contains(number)) {
                number = (int) (Math.random() * 10);    // 0 ~ 9까지 난수 생성
            }

            numberSet.add(number);
            uniqueNumber[i] = number;
        }

        return new UniqueNumber(uniqueNumber);
    }

}
