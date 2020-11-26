package baseball.domain.judge.judgeRule;

import baseball.domain.judge.Judgement;
import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;

public class BallJudgeRule extends JudgeRule {

    private static class LazyHolder {
        public static final BallJudgeRule INSTANCE = new BallJudgeRule();
    }

    public static BallJudgeRule getInstance() {
        return LazyHolder.INSTANCE;
    }

    private BallJudgeRule() {
        super(Judgement.BALL);
    }

    @Override
    public boolean judge(final Pitchings base, final Pitchings target, final int index) {
        Pitching targetPitching = target.getPitching(index);
        return !base.match(target, index) && base.contains(targetPitching);
    }
}
