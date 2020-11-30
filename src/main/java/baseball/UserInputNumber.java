package baseball;

import java.util.*;

public class UserInputNumber {

    /*
     * 사용자가 입력한 숫자를 이용해 숫자를 만드는 클래스
     * */
    private static String userNumberString;
    private static String userInputNumberString;
    private static final int NUMBER_LENGTH = 3;

    public static ArrayList<Integer> userInputNumber() {
        ArrayList<Integer> userNumberList;
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                userNumberString = getUserInputNumber();
                if (userInputNumberCheck()) {
                    userNumberList = StringToArrayList.stringToArrayList(userNumberString);
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 문자가 입력되었습니다.");
                continue;
            }
        }
        return userNumberList;
    }

    /*
     * 사용자가 입력하는 값을 그대로 가지고오는 메서드
     * */
    public static String getUserInputNumber() {
        Scanner scan = new Scanner(System.in);
        userInputNumberString = scan.nextLine();

        return userInputNumberString;
    }

    /*
     * 사용자가 제대로 입력했는지 확인하는 메서드
     * */
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

    /*
     * 사용자가 입력한 것에 0이 포함되었는지 확인하는 메서드
     * */
    public static boolean userInputContainZero() {
        if (userInputNumberString.contains("0")) {
            return false;
        }
        return true;
    }

    /*
     * 사용자가 입력한 것이 3자리인지 확인하는 메서드
     * */
    public static boolean userInputLength() {
        if (userNumberString.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    /*
     * 사용자가 입력한 것이 중복되지 않는지 확인하는 메서드
     * */
    public static boolean userInputRepeat() {
        ArrayList<Character> repeatCheckList = new ArrayList<>();

        for (char c : userInputNumberString.toCharArray()) {
            repeatCheckList.add(c);
        }

        Set<Character> repeatCheckHash = new HashSet<>(repeatCheckList);

        if (repeatCheckHash.size() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

}