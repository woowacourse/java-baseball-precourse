package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int LENGTH = 3;
    private static final char MAX = '9';
    private static final char MIN = '1';
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";
    private static String inputNumber;
    private static ArrayList<Integer> userNumberList;

    public ArrayList<Integer> inputUserNumber() {
        System.out.print(INPUT_MSG);
        inputNumber = Console.readLine();
        String[] inputNumberList = inputNumber.split("");
        if (this.validateInputNumber(inputNumberList)) {
            this.changeArrayList(inputNumberList);
        }
        return userNumberList;
    }

    private void changeArrayList(String[] inputNumberList) {
        userNumberList = new ArrayList<Integer>();
        for (String number : inputNumberList) {
            userNumberList.add(Integer.parseInt(number));
        }
    }

    private boolean validateInputNumber(String[] inputNumberList) throws IllegalArgumentException {
        /*
         * Case 1. 입력한 문자열이 3자리가 아닐 경우
         * Case 2. 1~9가 아닌 값이 들어간 경우
         * Case 3. 중복되는 숫자가 존재할 경우
         */
        if (!this.validateNumberLength(inputNumberList)
                || !this.validateOnlyNumberInString(inputNumberList)
                || !this.checkDuplicateNumberInString(inputNumberList)) {
            throw new IllegalArgumentException("오류 : 잘못된 값 입력 (중복되지 않는 3자리의 정수만 입력)");
        }

        return true;
    }

    /* Case 1. 입력한 문자열이 3자리가 아닐 경우 */
    private boolean validateNumberLength(String[] inputNumberList) {
        if (inputNumberList.length == LENGTH) {
            return true;
        }
        return false;
    }

    /* Case 2. 1~9가 아닌 값이 들어간 경우 */
    private boolean validateOnlyNumberInString(String[] inputNumberList) {
        for (String userNumber : inputNumberList) {
            if (userNumber.charAt(0) < MIN || userNumber.charAt(0) > MAX) {
                return false;
            }
        }
        return true;
    }

    /* Case 3. 중복되는 숫자가 존재할 경우 */
    private boolean checkDuplicateNumberInString(String[] inputNumberList) {
        Set<String> numberSet = new HashSet<String>();
        for (String userNumber : inputNumberList) {
            numberSet.add(userNumber);
        }
        if (numberSet.size() == LENGTH) {
            return true;
        }
        return false;
    }

}
