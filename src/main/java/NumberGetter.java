/**
 * 클래스 이름 : NumberGetter.java
 *
 * @version 1.0
 *
 * 날짜 : 2019.12.2 월요일
 *
 * @author Seungwan Park, github.com/toneyparky
 */

import java.util.*;

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
            if (userNumberChecker()) {
                break;
            }
        }

        return userNumber;
    }

    /** 플레이어로부터 입력받은 숫자가 예외조건을 통과하는지에 따라 에러를 출력하는 메서드 */
    public static boolean userNumberChecker() {
        if (!userNumberLengthChecker()) {
            System.out.println("맞춰야할 숫자와 길이가 다릅니다. 다시 입력하세요.");
            return false;
        }

        if (!userNumberRepeatChecker()) {
            System.out.println("숫자가 중복됩니다. 다시 입력하세요.");
            return false;
        }

        if (!userNumberContainZeroChecker()) {
            System.out.println("0은 포함될 수 없습니다. 다시 입력하세요.");
            return false;
        }

        return true;
    }

    /** 플레이어가 입력한 숫자가 맞춰야할 숫자의 길이와 같은지 판단하는 메서드  */
    public static boolean userNumberLengthChecker() {
        return String.valueOf(userNumber).length() == NUMBER_LENGTH;
    }

    /** 플레이어가 입력한 숫자에 중복된 숫자가 있는지 판단하는 메서드  */
    public static boolean userNumberRepeatChecker() {
        ArrayList<Integer> repeatCheckList = IntegerToArrayList.integerToArrayList(userNumber);
        Set<Integer> repeatCheckHash = new HashSet<>(repeatCheckList);

        System.out.println("repeatCheckHash: "  + repeatCheckHash.size());
        if (repeatCheckHash.size() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    /** 플레이어가 입력한 숫자에 0이 포함되었는지 판단하는 메서드  */
    public static boolean userNumberContainZeroChecker() {
        ArrayList<Integer> repeatCheckList = IntegerToArrayList.integerToArrayList(userNumber);
        Set<Integer> repeatCheckHash = new HashSet<>(repeatCheckList);

        if (repeatCheckHash.contains(0)) {
            return false;
        }
        return true;
    }

    /** 사용자로부터 받은 입력을 정수로 저장하는 메서드  */
    public static int getInputNumber() {
        int inputNumber;
        Scanner scan = new Scanner(System.in);
        inputNumber = scan.nextInt();
        return inputNumber;
    }

}
