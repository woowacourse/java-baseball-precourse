/**
 * java-baseball-precourse
 * PlayerBot.java
 * Purpose: 로봇, 컴퓨터 Player의 동작을 구현함.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */

import java.util.ArrayList;
import java.util.Random;

import utils.RuleUtils;

public class PlayerBot extends Player {
    /**
     * 규칙이 정한 범위의 수들을 만들고,
     * 이를 규칙이 정한 자릿수만큼 임의로 선택해서 자릿수별로 끊어진 수를 만든다.
     */
    public void makeNumbers() {
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        ArrayList<Integer> candidates = RuleUtils.makeInRangeList();
        Random random = new Random();
        for (int i = 0; i < RuleUtils.DIGITS; i++) {
            int randomIndex = random.nextInt(candidates.size());      // 임의로 가져오는건 구간에서 선택할 index이다.
            inputNumbers.add(candidates.get(randomIndex));
            candidates.remove(randomIndex);
        }
        super.numbers = inputNumbers;
        makeNumbersCounts();
    }
}