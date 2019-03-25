package com.woowa.baseball;

import org.junit.Test;

import java.util.Scanner;

public class ValidNumberConverterTest {

    @Test
    public void validNumberTest() {
        ValidNumberConverter converter = new ValidNumberConverter();
        String[] input = {"as1", "5135", "224", "123"};       //사용자가 입력한 값을 담을 변수
        int[] convertedNum = {}; //입력 값을 숫자로 변환 시킨 배열을 담을 변수
        boolean flag = false;   //입력 값이 유효하여 변환되었는지 여부 체크
        int idx = 0;
        while (!flag) {
            try {
                convertedNum = converter.convert(input[idx++]);
                flag = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < convertedNum.length; i++) {
            System.out.print(convertedNum[i]);
        }
        System.out.println();
    }
}
