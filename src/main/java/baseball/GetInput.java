package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class GetInput {
    public static ArrayList<Integer> inputNumberList(Scanner scanner) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String inputString = getInputString(scanner);
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

    static void sameException(ArrayList<Integer> inputNumberList, int i) {
        boolean isContain = Check.isContain(inputNumberList, i);
        if(isContain){
            throw new IllegalArgumentException();
        }
    }

    static int inputParseInt(String inputString) {
        int result = Integer.parseInt(inputString);

        if (result == 0) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    static void lengthException(String inputString) {
        if (inputString.length() != Application.TARGET_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
