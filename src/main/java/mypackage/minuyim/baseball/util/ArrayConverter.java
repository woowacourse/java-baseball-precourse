/*
 * @(#)ArrayConverter.java
 * 
 * version : 1.0
 * 
 * 2019.12.01
 */

package mypackage.minuyim.baseball.util;

/**
 * ArrayConverter : 사용자가 입력한 숫자를 비교를 위한 Array로 변환시키는 클래스
 * 
 * @version 1.00 2019/12/01
 * @author 임민우
 */
public class ArrayConverter {

    public static int[] convertToArray(int num) {
        String temp = Integer.toString(num);
        int[] nums = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++) {
            nums[i] = temp.charAt(i) - '0';
        }
        return nums;
    }
}