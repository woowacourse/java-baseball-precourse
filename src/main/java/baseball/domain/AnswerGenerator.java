package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerGenerator {

    private static final int startInclusive = 1;
    private static final int endInclusive = 9;
    private static final int count = 3;

    public List<Integer> generate() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < count) {
            result.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }
        return new ArrayList<>(result);
    }

}
