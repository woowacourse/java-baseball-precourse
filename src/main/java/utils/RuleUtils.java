package utils;

public class RuleUtils {
    public static final int LOWERBOUND = 1;
    public static final int UPPERBOUND = 9;
    public static final int DIGITS = 3;

    public static boolean isValidDigit(ArrayList<Integer> numbersList) {
        return numbersList.size() == DIGITS;
    }

    public static boolean isValidRange(ArrayList<Integer> numbersList) {
        ArrayList<Integer> inRangeList = makeInRangeList();
        for (Integer i : numbersList) {
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
