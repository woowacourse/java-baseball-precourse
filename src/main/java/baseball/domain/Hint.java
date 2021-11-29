package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.resource.rule.NumberDigit;
import baseball.resource.text.HintText;

public class Hint {

    private int balls;
    private int strikes;

    public Hint() {
        this.balls = 0;
        this.strikes = 0;
    }

    public void increaseBall() {
        this.balls++;
    }

    public void increaseStrike() {
        this.strikes++;
    }

    public boolean isAllStrikes() {
        return NumberDigit.isMatch(this.strikes);
    }

    public String toString() {
        List<String> resultDatas = new ArrayList<>();

        if (isBallExist()) {
            resultDatas.add(getStringBalls());
        }
        if (isStrikeExist()) {
            resultDatas.add(getStringStrikes());
        }

        int resultDataSize = resultDatas.size();

        if (resultDataSize > 1) {
            return String.join(" ", resultDatas);
        } else if (resultDataSize == 1) {
            return resultDatas.get(0);
        }
        return HintText.NOTHING;
    }

    private boolean isBallExist() {
        return (balls != 0);
    }

    private boolean isStrikeExist() {
        return (strikes != 0);
    }

    private String getStringBalls() {
        return balls + HintText.BALL;
    }

    private String getStringStrikes() {
        return strikes + HintText.STRIKE;
    }

}
