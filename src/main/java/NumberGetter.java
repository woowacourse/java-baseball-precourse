/**
 * NumberGetter 클래스에서는 플레이어의 수를 입력받는다.
 */

import java.util.Scanner;


public class NumberGetter {

    private static final int NUMBER_LENGTH = 3;
    private static int userNumber;

    public static int numberGetter() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            userNumber = scan.nextInt();
            if (userNumberLengthChecker()) {
                break;
            } else {
                continue;
            }
        }

        return userNumber;
    }

    public static boolean userNumberLengthChecker() {
        return String.valueOf(userNumber).length() == NUMBER_LENGTH;
    }

}
