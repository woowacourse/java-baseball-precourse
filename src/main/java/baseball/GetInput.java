package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class GetInput {
    public static ArrayList<Integer> inputNumberList(Scanner scanner) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String inputString = getInputString(scanner);
        isInt(inputString);
        lengthException(inputString);
        for (int i = 0; i < Application.TARGET_LENGTH; i++) {
            String tempString = inputString.substring(i, i + 1);
            int tempInt = inputParseInt(tempString);
            sameException(result, tempInt);
            result.add(tempInt);
        }

        return result;
    }

    static String getInputString(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.next();
    }

    static void sameException(ArrayList<Integer> inputNumberList, int i) throws IllegalArgumentException {
        boolean isContain = Check.isContain(inputNumberList, i);
        if (isContain) {
            throw new IllegalArgumentException("오류: 중복된 숫자가 존재합니다!");
        }
    }

    static boolean isInt(String inputString) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("오류: 숫자가 아닙니다!");
        }
    }

    static int inputParseInt(String inputString) throws IllegalArgumentException {
        int result = Integer.parseInt(inputString);

        if (result == 0) {
            throw new IllegalArgumentException("오류: 0은 사용할 수 없습니다!");
        }
        return result;
    }

    static void lengthException(String inputString) throws IllegalArgumentException {
        if (inputString.length() != Application.TARGET_LENGTH) {
            throw new IllegalArgumentException("오류: 3자리 수가 아닙니다!");
        }
    }
}
