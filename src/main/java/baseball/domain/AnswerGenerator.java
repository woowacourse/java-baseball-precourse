package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerGenerator {

    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public AnswerGenerator(int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    public List<Integer> generate() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < count) {
            result.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }
        return new ArrayList<>(result);
    }

}
