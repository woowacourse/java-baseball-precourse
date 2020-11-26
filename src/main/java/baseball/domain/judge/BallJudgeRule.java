package baseball.domain.judge;

import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;

public class BallJudgeRule extends JudgeRule {

    public BallJudgeRule() {
        super(Judgement.BALL);
    }

    @Override
    boolean judge(final Pitchings base, final Pitchings target, final int index) {
        Pitching targetPitching = target.getPitching(index);
        return !base.match(target, index) && base.contains(targetPitching);
    }
}
