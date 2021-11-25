package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerGenerator {

    private static final int START_INCLUSIVE = Rule.START_INCLUSIVE.value();
    private static final int END_INCLUSIVE = Rule.END_INCLUSIVE.value();
    private static final int COUNT = Rule.COUNT.value();

    public List<Integer> generate() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < COUNT) {
            result.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return new ArrayList<>(result);
    }

}
