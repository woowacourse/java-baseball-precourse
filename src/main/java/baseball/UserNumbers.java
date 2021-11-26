package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class UserNumbers {
    public static ArrayList<Integer> UserNumbers() {
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        System.out.print("숫자를 입력해주세요 : ");
        String tmpUserNumbers = Console.readLine();

        // 예외처리
        Validation.isRightDigit(tmpUserNumbers);
        Validation.isThreeDigit(tmpUserNumbers);
        Validation.isContainSameDigit(tmpUserNumbers);

        //String -> int
        for (int i = 0; i < 3; i++) {
            userNumbers.add(tmpUserNumbers.charAt(i) - '0');
        }
        return userNumbers;
    }
}
