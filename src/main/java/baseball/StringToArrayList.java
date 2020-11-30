package baseball;

import java.util.ArrayList;

public class StringToArrayList {

    public static ArrayList<Integer> stringToArrayList(String userNumberString) {
        ArrayList<Integer> userinputNumberList = new ArrayList<>();  // 새로 해줘야 char number를 입력할 때 null가능할수도있다고 뜨지 않는다.
        char[] changeList = userNumberString.toCharArray();

        for (char number : changeList) {
            int numberInt = Integer.parseInt(String.valueOf(number));
            userinputNumberList.add(numberInt);
        }
        return userinputNumberList;
    }
}