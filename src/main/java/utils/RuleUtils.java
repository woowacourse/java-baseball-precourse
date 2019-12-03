/**
 * java-baseball-precourse
 * RuleUtils.java
 * Purpose: 게임 규칙의 정보와 그를 준수하는지 확인하는 Method들을 모은다.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */
package utils;

import java.util.ArrayList;
import java.util.HashSet;

public class RuleUtils {
    public static final int LOWERBOUND = 1;
    public static final int UPPERBOUND = 9;
    public static final int DIGITS = 3;
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    /**
     * 자릿수 확인을 위한 Method, 규칙에서 정한 자리수인지 확인한다.
     *
     * @param numbersList 지정된 숫자를 십진 자릿수별로 끊어 담은 ArrayList.
     * @return 규칙에서 정한 자리수인지의 여부.
     */
    public static boolean isValidDigit(ArrayList<Integer> numbersList) {
        return numbersList.size() == DIGITS;
    }

    /**
     * 범위 확인을 위한 Method, 규칙에서 정한 범위 이내인지 확인한다.
     *
     * @param numbersList 확인할 수들의 ArrayList
     * @return numbersList 전체가 범위 이내인지의 여부.
     */
    public static boolean isValidRange(ArrayList<Integer> numbersList) {
        ArrayList<Integer> inRangeList = makeInRangeList();
        for (int i : numbersList) {
            if (!inRangeList.contains(i))
                return false;
        }
        return true;
    }

    /**
     * 중복 확인을 위한 Method.
     * Hashset과 원본의 크기비교를 통해 중복을 확인한다.
     *
     * @param numbersList 확인할 수들의 ArrayList
     * @return numbersList 에 중복이 발생했는지 여부 .
     */
    public static boolean isUnique(ArrayList<Integer> numbersList) {
        HashSet<Integer> numbersSet = new HashSet<>(numbersList);
        return numbersSet.size() == numbersList.size();
    }

    /**
     * 규칙에서 정한 구간의 연속된 숫자들을 만드는 Method,
     * 시작과 끝을 포함한다.
     *
     * @return 시작수부터 마지막 수까지 하나씩 증가하는 ArrayList
     */
    public static ArrayList<Integer> makeInRangeList() {
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = LOWERBOUND; i <= UPPERBOUND; i++) {
            candidates.add(i);
        }
        return candidates;
    }
}
