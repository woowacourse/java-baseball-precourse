package baseball.domain.judge;

import java.util.Arrays;
import java.util.List;

public class JudgeRuleFactory {

    public static List<JudgeRule> getAll() {
        return Arrays.asList(new StrikeJudgeRule(), new BallJudgeRule(), new NothingJudgeRule());
    }
}
