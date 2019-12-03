/**
 * java-baseball-precourse
 * Player.java
 * Purpose: 일반적인 Player의 동작을 구현함.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */

import java.util.ArrayList;
import java.util.Arrays;

import utils.RuleUtils;

public abstract class Player {
    ArrayList<Integer> numbers;         // 입력받은 수를 십진 자릿수 순서대로 끊어 담는다.
    ArrayList<Integer> numberCounts;    // 입력받은 수에서 발생하는 수들의 발생조합을 담는다.

    /**
     * 입력받은 수에서 발생하는 발생빈도, 조합을 담는다.
     */
    public void makeNumbersCounts() {
        if (numbers == null) return;
        Integer counts[] = new Integer[RuleUtils.UPPERBOUND - RuleUtils.LOWERBOUND + 1];
        Arrays.fill(counts, 0);
        for (int i : numbers) {
            int idx = i - RuleUtils.LOWERBOUND;
            counts[idx] += 1;
        }
        numberCounts = new ArrayList<Integer>(Arrays.asList(counts));
    }

    /**
     * 수를 입력받아 십진 자릿수대로 끊는 조합을 만든다. 각 Player마다 동작이 다르다.
     */
    abstract public void makeNumbers();
}