package baseball.domain.judge;

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
    boolean judge(final Pitchings base, final Pitchings target, final int index) {
        return base.match(target, index);
    }
}
