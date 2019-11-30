/**
 * IntegerToArrayList 클래스에서는 플레이어의 입력 숫자를 ArrayList로 바꾸어준다.
 */

import java.util.ArrayList;
import java.util.Collections;

public class IntegerToArrayList {
    private static ArrayList<Integer> numberList = new ArrayList<>();
    public static ArrayList<Integer> integerToArrayList(int userNumber) {
        int numberLength = String.valueOf(userNumber).length();

        for (int i = 0; i < numberLength; i++) {
            numberList.add(userNumber % 10);
            userNumber = userNumber / 10;
        }

        Collections.reverse(numberList);

        return numberList;
    }

}
