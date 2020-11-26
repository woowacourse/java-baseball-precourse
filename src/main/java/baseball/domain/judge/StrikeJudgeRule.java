package baseball.domain.judge;

import baseball.domain.pitching.Pitchings;

public class StrikeJudgeRule extends JudgeRule {

    public StrikeJudgeRule() {
        super(Judgement.STRIKE);
    }

    @Override
    boolean judge(final Pitchings base, final Pitchings target, final int index) {
        return base.match(target, index);
    }
}
