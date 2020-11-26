package baseball.domain.judge;

import java.util.HashMap;
import java.util.Map;

public class JudgeResult {

    private static final int DEFAULT_COUNT = 0;
    private static final int INCREMENT_COUNT = 1;

    private final Map<Judgement, Integer> value;

    private JudgeResult() {
        this.value = new HashMap<>();
    }

    public static JudgeResult empty() {
        return new JudgeResult();
    }

    public void increment(final Judgement judgement) {
        set(judgement, get(judgement) + INCREMENT_COUNT);
    }

    public void set(final Judgement judgement, int count) {
        value.put(judgement, count);
    }

    public int get(final Judgement judgement) {
        return value.getOrDefault(judgement, DEFAULT_COUNT);
    }
}
