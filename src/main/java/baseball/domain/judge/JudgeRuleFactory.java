package baseball.domain.judge;

import java.util.Arrays;
import java.util.List;

public class JudgeRuleFactory {

    public static List<JudgeRule> getAll() {
        return Arrays.asList(
            StrikeJudgeRule.getInstance(),
            BallJudgeRule.getInstance(),
            NothingJudgeRule.getInstance()
        );
    }
}
