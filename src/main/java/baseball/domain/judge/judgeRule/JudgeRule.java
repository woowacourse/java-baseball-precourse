package baseball.domain.judge.judgeRule;

import baseball.domain.pitching.Pitchings;

public interface JudgeRule {

    boolean judge(Pitchings base, Pitchings target, int index);
}
