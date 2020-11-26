package baseball.domain.judge.judgeRule;

import baseball.domain.judge.Judgement;
import baseball.domain.pitching.Pitchings;

public abstract class JudgeRule {

    private final Judgement judgement;

    JudgeRule(Judgement judgement) {
        this.judgement = judgement;
    }

    public abstract boolean judge(Pitchings base, Pitchings target, int index);

    public Judgement getJudgement() {
        return this.judgement;
    }
}
