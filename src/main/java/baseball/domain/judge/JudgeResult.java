package baseball.domain.judge;

import baseball.domain.pitching.Pitchings;
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

    public boolean isComplete() {
        return get(Judgement.STRIKE) == Pitchings.SIZE;
    }

    public boolean isNothing() {
        return get(Judgement.NOTHING) == Pitchings.SIZE;
    }

    public boolean has(Judgement judgement) {
        return get(judgement) > DEFAULT_COUNT;
    }
}
