package utils;

import java.util.ArrayList;

public class StringHandler {
    public static boolean checkDuplication(String userInput) {
        int length = userInput.length();
        boolean[] check = new boolean[length];

        for (int i = 0; i < length; i++) {
            int index = userInput.indexOf(userInput.charAt(i));
            if (check[index]) {
                return true;
            }
            check[index] = true;
        }
        return false;
    }

    public static ArrayList<Integer> stringToArrayList(String userInput) {
        ArrayList<Integer> userNumberList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            userNumberList.add(userInput.charAt(i) - '0');
        }
        return userNumberList;
    }
}
