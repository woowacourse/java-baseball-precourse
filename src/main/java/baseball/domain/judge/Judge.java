package baseball.domain.judge;

import baseball.domain.judge.exception.JudgeMultipleJudgementException;
import baseball.domain.judge.judgeRule.JudgeRule;
import baseball.domain.pitching.Pitching;
import baseball.domain.pitching.Pitchings;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    public static final int JUDGEMENT_BOUNDARY = 1;

    private final List<JudgeRule> judgeRules;

    public Judge(final List<JudgeRule> judgeRules) {
        this.judgeRules = judgeRules;
    }

    public static Judge of(final List<JudgeRule> judgeRules) {
        return new Judge(judgeRules);
    }

    public static Judge of(final JudgeRule... judgeRules) {
        return new Judge(Arrays.asList(judgeRules));
    }

    public JudgeResult judge(final Pitchings base, final Pitchings target) {
        JudgeResult judgeResult = JudgeResult.empty();

        List<Pitching> pitchings = target.getPitchings();
        pitchings.forEach((targetPitching) -> {
            Judgement judgement = judgeOne(base, target, pitchings.indexOf(targetPitching));
            judgeResult.increment(judgement);
        });

        return judgeResult;
    }

    public Judgement judgeOne(final Pitchings base, final Pitchings target, final int index) {
        List<Judgement> judgements = judge(base, target, index);

        if (judgements.size() != JUDGEMENT_BOUNDARY) {
            throw new JudgeMultipleJudgementException(judgements);
        }

        return judgements.get(0);
    }

    private List<Judgement> judge(final Pitchings base, final Pitchings target, final int index) {
        return judgeRules.stream()
            .filter(judgeRule -> judgeRule.judge(base, target, index))
            .map(JudgeRule::getJudgement)
            .collect(Collectors.toList());
    }
}
