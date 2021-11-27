package baseball.domain;

import baseball.resource.GameMessage;
import baseball.resource.GameRule;

import java.util.ArrayList;
import java.util.List;

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

        String result = GameMessage.NOTHING;
        int resultDataSize = resultDatas.size();

        if (resultDataSize == 2) {
            result = String.join(" ", resultDatas);

        } else if (resultDataSize == 1) {
            result = resultDatas.get(0);
        }

        return result;
    }

}
