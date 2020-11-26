package baseball.domain.game;

import baseball.domain.judge.Judge;
import baseball.domain.judge.JudgeResult;
import baseball.domain.judge.judgeRule.JudgeRuleFactory;
import baseball.domain.pitching.Pitchings;

public class Game {

    private final Pitchings base;
    private final Judge judge;
    private JudgeResult judgeResult;

    public Game(final Pitchings base, final Judge judge, final JudgeResult judgeResult) {
        this.base = base;
        this.judge = judge;
        this.judgeResult = judgeResult;
    }

    public static Game generate() {
        Judge judge = Judge.of(JudgeRuleFactory.getAll());

        return new Game(Pitchings.random(), judge, JudgeResult.empty());
    }

    public void start(final Pitchings target) {
        judgeResult = judge.judge(base, target);
    }

    public boolean isComplete() {
        return judgeResult.isComplete();
    }

    public JudgeResult getJudgeResult() {
        return this.judgeResult;
    }
}
