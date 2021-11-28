package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomAnswer {

    public List<Integer> generate() {
        final int startInclusive = 1;
        final int endInclusive = 9;
        final int count = 3;
        List<Integer> answer = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return answer;
    }
}