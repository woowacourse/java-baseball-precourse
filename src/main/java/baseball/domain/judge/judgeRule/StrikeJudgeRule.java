package baseball.domain.judge.judgeRule;

import baseball.domain.judge.Judgement;
import baseball.domain.pitching.Pitchings;

public class StrikeJudgeRule extends JudgeRule {

    private static class LazyHolder {
        public static final StrikeJudgeRule INSTANCE = new StrikeJudgeRule();
    }

    public static StrikeJudgeRule getInstance() {
        return StrikeJudgeRule.LazyHolder.INSTANCE;
    }

    private StrikeJudgeRule() {
        super(Judgement.STRIKE);
    }

    @Override
    public boolean judge(final Pitchings base, final Pitchings target, final int index) {
        return base.match(target, index);
    }
}
