package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.resource.GameMessage;
import baseball.resource.GameRule;

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
        return (this.strikes == GameRule.NUMBERS_DIGITS);
    }

    public String toString() {
        List<String> resultDatas = new ArrayList<>();

        if (balls != 0) {
            resultDatas.add(balls + GameMessage.BALL);
        }

        if (strikes != 0) {
            resultDatas.add(strikes + GameMessage.STRIKE);
        }

        int resultDataSize = resultDatas.size();

        if (resultDataSize == 2) {
            return String.join(" ", resultDatas);
        } else if (resultDataSize == 1) {
            return resultDatas.get(0);
        }
        return GameMessage.NOTHING;
    }

}
