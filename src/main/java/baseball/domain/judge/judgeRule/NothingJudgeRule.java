package baseball.domain.judge.judgeRule;

import baseball.domain.judge.Judgement;
import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;

public class NothingJudgeRule extends JudgeRule {

    private static class LazyHolder {
        public static final NothingJudgeRule INSTANCE = new NothingJudgeRule();
    }

    public static NothingJudgeRule getInstance() {
        return NothingJudgeRule.LazyHolder.INSTANCE;
    }

    private NothingJudgeRule() {
        super(Judgement.NOTHING);
    }

    @Override
    public boolean judge(final Pitchings base, final Pitchings target, final int index) {
        Pitching targetPitching = target.getPitching(index);
        return !base.contains(targetPitching);
    }
}
