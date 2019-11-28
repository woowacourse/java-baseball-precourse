/*
 * StringHandler.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */


package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class StringHandler {
    public static boolean isDuplicated(String string) {
        String[] strings = string.split("");
        Arrays.sort(strings);
        for(int i = 0; i < strings.length - 1; i++) {
            if(strings[i].equals(strings[i+1])) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> addToList(String string) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = 0 ; i < string.length(); i++) {
            numberList.add((int)string.charAt(i) - '0');
        }
        return numberList;
    }
}
