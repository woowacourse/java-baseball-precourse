package com.woowa.baseball;


import java.util.HashSet;
import java.util.Set;

/**
 * 사용자의 입력에 대해 숫자형으로 변환해주는 클래스
 *
 * @version 1.0
 * @since 03/25/2019
 * @author icarus8050
 */
public class ValidNumberConverter {

    /**
     * 사용자가 입력한 String형 숫자를 숫자형 배열로 변환시킵니다.
     * 유효하지 않은 값에 대해서는 예외를 던집니다.
     *
     * @param stringBasedNumber     변환 시킬 String형 숫자
     * @return                      변환된 숫자형 배열
     */
    public int[] convert(String stringBasedNumber) {
        int[] convertedNumber;

        if (!isNumber(stringBasedNumber)) {
            throw new RuntimeException("입력된 값이 숫자가 아닙니다.");
        }

        if (!isValidLength(stringBasedNumber)) {
            throw new RuntimeException("입력된 길이가 유효하지 않습니다.");
        }

        convertedNumber = makeTheUniqueNumber(stringBasedNumber);

        if (convertedNumber == null) {
            throw new RuntimeException("유효한 숫자가 아닙니다.");
        }

        return convertedNumber;
    }

    private boolean isNumber(String stringBasedNumber) {
        try {
            Integer.parseInt(stringBasedNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidLength(String stringBasedNumber) {
        return ((stringBasedNumber.length() > 0)
                && (stringBasedNumber.length() < 4));
    }

    private int[] makeTheUniqueNumber(String stringBasedNumber) {
        int[] uniqueNumber = new int[stringBasedNumber.length()];
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(0);

        for (int i = 0; i < stringBasedNumber.length(); i++) {
            int num = stringBasedNumber.charAt(i) - '0';

            if (numberSet.contains(num)) {

                /* 사용자가 입력한 숫자가 중복되어 있을 경우 */
                return null;
            }
            numberSet.add(num);
            uniqueNumber[i] = num;
        }

        return uniqueNumber;
    }
}
