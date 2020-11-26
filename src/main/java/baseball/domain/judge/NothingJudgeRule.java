package baseball.domain.judge;

import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;

public class NothingJudgeRule extends JudgeRule {

    public NothingJudgeRule() {
        super(Judgement.NOTHING);
    }

    @Override
    boolean judge(final Pitchings base, final Pitchings target, final int index) {
        Pitching targetPitching = target.getPitching(index);
        return !base.contains(targetPitching);
    }
}
