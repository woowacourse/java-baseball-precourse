package baseball;

import java.util.Scanner;
import java.util.stream.Stream;

public class UserInput {
    private static Scanner input = new Scanner(System.in);
    private static int[] userNum;
    private static String userNumString;

    public int[] getUserNum () {
        System.out.print("숫자를 입력해주세요 : ");
        userNumString = input.nextLine();
        if (userNumValidation(userNumString)) {
            userNum = Stream.of(userNumString.split("")).mapToInt(Integer::parseInt).toArray();
            return userNum;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean userNumValidation(String num) {
        /* 예외 1) 문자가 입력된 경우 */
        try {
            int parsedNum = Integer.parseInt(num);
            if (!(99<parsedNum && parsedNum<1000)) {
                return false;
            }
        } catch(NumberFormatException error) {
            return false;
        }
        /* 예외 2) 입력 길이가 3이 아닌 경우*/
        if (num.length() != 3) {
            return false;
        }
        /* 예외 3) 입력 값 중 0이 포함된 경우*/
        if (num.contains("0")) {
            return false;
        }
        /* 예외 4) 서로 다른 수가 아닌 경우 */
        if (num.charAt(0)==num.charAt(1) || num.charAt(0)==num.charAt(2) || num.charAt(1)==num.charAt(2)) {
            return false;
        }
        /* 예외가 아닌 경우 true 반환 */
        return true;
    }
}
