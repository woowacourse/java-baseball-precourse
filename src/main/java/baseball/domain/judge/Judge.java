package baseball.domain.judge;

import baseball.domain.judge.judgeRule.JudgeRule;
import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private final List<JudgeRule> judgeRules;

    public Judge(final List<JudgeRule> judgeRules) {
        this.judgeRules = judgeRules;
    }

    public static Judge of(final List<JudgeRule> judgeRules) {
        return new Judge(judgeRules);
    }

    public JudgeResult judge(final Pitchings base, final Pitchings target) {
        JudgeResult judgeResult = JudgeResult.empty();

        List<Pitching> pitchings = target.getPitchings();
        for (Pitching targetPitching : pitchings) {
            int index = pitchings.indexOf(targetPitching);
            getPossibleJudgements(base, target, index)
                .forEach(judgeResult::increment);
        }

        return judgeResult;
    }

    public List<Judgement> getPossibleJudgements(final Pitchings base, final Pitchings target, final int index) {
        return judgeRules.stream()
            .filter(judgeRule -> judgeRule.judge(base, target, index))
            .map(Judgement::get)
            .collect(Collectors.toList());
    }
}
