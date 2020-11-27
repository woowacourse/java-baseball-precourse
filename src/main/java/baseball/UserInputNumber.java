package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInputNumber {

    private static String userNumberString;
    private static String userinputNumberString;
    private static final int NUMBER_LENGTH = 3;

    public static int userInputNumber() {
        int userNumber;
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                userNumberString = getUserInputNumber();
                if (userInputNumberCheck()) {
                    userNumber = Integer.parseInt(userinputNumberString);
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 문자가 입력되었습니다.");
                continue;
            }
        }
        return userNumber;
    }

    public static String getUserInputNumber() {
        Scanner scan = new Scanner(System.in);
        userinputNumberString = scan.nextLine();

        return userinputNumberString;
    }

    public static boolean userInputNumberCheck() {
        if (!userInputContainZero()) {
            System.out.println("1부터 9사이의 숫자를 입력해주세요.");
            return false;
        }

        if (!userInputLength()) {
            System.out.println("입력하시는 숫자는 세자리여야합니다.");
            return false;
        }

        if (!userInputRepeat()) {
            System.out.println("숫자가 중복으로 입력이 될 수 없습니다.");
            return false;
        }
        return true;

    }

    public static boolean userInputContainZero() {
        if (userinputNumberString.contains("0")) {
            return false;
        }
        return true;
    }

    public static boolean userInputLength() {
        if (userNumberString.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    public static boolean userInputRepeat() {
        ArrayList<Character> repeatCheckList = new ArrayList<>();

        for (char c : userinputNumberString.toCharArray()) {
            repeatCheckList.add(c);
        }

        Set<Character> repeatCheckHash = new HashSet<>(repeatCheckList);

        if (repeatCheckHash.size() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }
}
