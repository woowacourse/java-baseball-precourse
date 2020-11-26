package baseball.domain.judge.judgeRule;

import java.util.Arrays;
import java.util.List;

public class JudgeRuleFactory {

    public static List<JudgeRule> getAll() {
        return Arrays.asList(
            BallJudgeRule.getInstance(),
            StrikeJudgeRule.getInstance(),
            NothingJudgeRule.getInstance()
        );
    }
}
