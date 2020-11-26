package baseball.domain.judge;

import baseball.domain.judge.exception.JudgeNotExistException;
import baseball.domain.judge.judgeRule.BallJudgeRule;
import baseball.domain.judge.judgeRule.JudgeRule;
import baseball.domain.judge.judgeRule.NothingJudgeRule;
import baseball.domain.judge.judgeRule.StrikeJudgeRule;

public enum Judgement {

    STRIKE("스트라이크", StrikeJudgeRule.getInstance()),
    BALL("볼", BallJudgeRule.getInstance()),
    NOTHING("낫싱", NothingJudgeRule.getInstance());

    private final String koreanName;
    private final JudgeRule judgeRule;

    Judgement(String koreanName, JudgeRule judgeRule) {
        this.koreanName = koreanName;
        this.judgeRule = judgeRule;
    }

    public static Judgement get(JudgeRule value) {
        for (Judgement judgement : values()) {
            if (judgement.judgeRule == value) {
                return judgement;
            }
        }

        throw new JudgeNotExistException(value);
    }

    public String getKoreanName() {
        return this.koreanName;
    }
}
