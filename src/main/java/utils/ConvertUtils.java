/**
 * java-baseball-precourse
 * ConvertUtils.java
 * Purpose: 필요한 변환들을 구현함.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */
package utils;

import java.util.ArrayList;
import java.util.Collections;

public class ConvertUtils {
    /**
     * 수를 자릿수별로 끊어서 배열화 한다.
     *
     * @param number 자릿수별로 끊을 수
     * @return 자릿수별로 끊어 담은 ArrayList
     */
    public static ArrayList<Integer> toDigitArrayList(Integer number) {
        int temp = number;
        ArrayList<Integer> digitArrayList = new ArrayList<>();
        while (temp > 0) {
            digitArrayList.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(digitArrayList);    /* 역순으로 만들어 0부터 가장 큰 자릿수의 수가 들어간다 */
        return digitArrayList;
    }
}