package utils;

import org.junit.jupiter.api.Test;

import java.util.*;

class InputUtilsTest {

    public Scanner createInput() {
        return new Scanner("0135");
    }

    @Test
    public void useStringInputExceptionTest() {
        Scanner sc = createInput();
        if (!sc.hasNextInt()) {
            throw new IllegalArgumentException("정수가 아님");
        }

        String str = sc.nextLine();
        if (str.length() != 3) {
            throw new IllegalArgumentException("3자리 정수가 아님");
        }

        String[] strList = str.split("");
        Set<Integer> numberSet = new HashSet<Integer>();
        for (int i = 0; i < strList.length; i++) {
            int number = Integer.parseInt(strList[i]);
            if (number == 0 || numberSet.contains(number)) {
                throw new IllegalArgumentException("0이거나 중복값");
            }
            numberSet.add(number);
        }

        System.out.println(numberSet);
    }

    @Test   // 0123 과 같이 앞자리에 0이 붙는 경우를 못 걸러냄.
    public void useIntegerInputExceptionTest() {
        Scanner sc = createInput();
        if (!sc.hasNextInt()) {
            throw new IllegalArgumentException("정수가 아님");
        }

        int number = sc.nextInt();
        Set<Integer> numberSet = new HashSet<Integer>();

        while (number > 0) {
            numberSet.add(number % 10);
            number /= 10;
        }

        if (numberSet.size() != 3) {
            throw new IllegalArgumentException("너무 짧거나, 너무 길거나, 중복 값 포함");
        }

    }
}