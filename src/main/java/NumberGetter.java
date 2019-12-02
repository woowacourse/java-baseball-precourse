/**
 * 클래스 이름 : NumberGetter.java
 *
 * @version 1.0
 *
 * 날짜 : 2019.12.2 월요일
 *
 * @author Seungwan Park, github.com/toneyparky
 */

import java.util.Scanner;

/**
 * NumberGetter 클래스에서는 플레이어의 수를 입력받는다.
 */

public class NumberGetter {

    private static final int NUMBER_LENGTH = 3;
    private static int userNumber;

    /** 플레이어로부터 숫자를 입력받는 로직을 진행하는 메서드  */
    public static int numberGetter() {
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            userNumber = getInputNumber();
            if (userNumberLengthChecker()) {
                System.out.print("길이가 같아요.  ");
                break;
            } else {
                System.out.print("길이가 달라요.  ");
                continue;
            }
        }

        return userNumber;
    }

    /** 플레이어가 입력한 숫자가 규칙에 맞는 길이의 숫자인지 판단하는 메서드  */
    public static boolean userNumberLengthChecker() {
        return String.valueOf(userNumber).length() == NUMBER_LENGTH;
    }

    /** 사용자로부터 받은 입력을 정수로 저장하는 메서드  */
    public static int getInputNumber() {
        int inputNumber;
        Scanner scan = new Scanner(System.in);
        inputNumber = scan.nextInt();
        return inputNumber;
    }


}
