package mypackage.minuyim.baseball.util;

import java.util.Scanner;

public class NumberInput {
    private static final int LENGTH_NUMBER = 3;

    public static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        int num;
        
        System.out.print("숫자를 입력해주세요 : ");
        while (true) {
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("숫자를 입력하세요.");
            }
            num = sc.nextInt();
            if (!isWrongNumber(num)) {
                break;
            } else {
                System.out.println("1~9까지 각 자리 중복없이 3자리의 수를 입력해주세요.");
            }
        }
        return num;
    }

    private static boolean isWrongNumber(int num) {
        boolean isWrong;
        String stringNumber;
        int i;
        int count;
        int[] temp = new int[10];

        stringNumber = Integer.toString(num);
        isWrong = false;
        if (stringNumber.length() != LENGTH_NUMBER) {
            isWrong = true;
        }

        for (int j = 0; j < LENGTH_NUMBER; j++) {
            i = stringNumber.charAt(j) - '0';
            temp[i] += 1;
            if (i == 0) {
                isWrong = true;
            }
        }

        count = 0;
        for (int j = 0; j < 10; j++) {
            if (temp[j] == 1) {
                count += 1;
            }
        }
        if (count != 3) {
            isWrong = true;
        }

        return isWrong;
    }
}