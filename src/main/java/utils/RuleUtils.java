package utils;

import java.util.ArrayList;

public class RuleUtils {
    public static final int LOWERBOUND = 1;
    public static final int UPPERBOUND = 9;
    public static final int DIGITS = 3;
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    public static boolean isValidDigit(ArrayList<Integer> numbersList) {
        return numbersList.size() == DIGITS;
    }

    public static boolean isValidRange(ArrayList<Integer> numbersList) {
        ArrayList<Integer> inRangeList = makeInRangeList();
        for (int i : numbersList) {
            if(!inRangeList.contains(i))
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> makeInRangeList() {
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = LOWERBOUND; i <= UPPERBOUND; i++) {
            candidates.add(i);
        }
        return candidates;
    }
}
