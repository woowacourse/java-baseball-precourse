/**
 * 클래스 이름      PlayerInput
 * 버전 정보        1.0
 * 날짜            2019.11.30
 * 저작권          YebinK
 */

import java.util.Scanner;

public class PlayerInput {

    private int [] input = new int[3];

    public int[] getInput() {
        System.out.println("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        String str_input = sc.next();

        stringToIntArr(str_input);

        return input;
    }

    public void stringToIntArr(String s) {
        input[0] = s.charAt(0) - '0';
        input[1] = s.charAt(1) - '0';
        input[2] = s.charAt(2) - '0';
    }
}