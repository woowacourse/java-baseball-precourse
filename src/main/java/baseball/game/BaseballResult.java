package baseball.game;

import baseball.domain.BaseballType;

import java.util.HashMap;
import java.util.Map;

public class BaseballResult {
    private final static int ZERO_FREQUENCY = 0;

    private final Map<BaseballType, Integer> baseballResult;
    private final int sizeOfBaseball;

    public BaseballResult(int sizeOfBaseball) {
        this.sizeOfBaseball = sizeOfBaseball;
        this.baseballResult = new HashMap<>();
        for (BaseballType baseballType : BaseballType.values()) {
            this.baseballResult.put(baseballType, ZERO_FREQUENCY);
        }
    }

    public boolean isNothing() {
        for (BaseballType baseballType : BaseballType.values()) {
            Integer eachBaseballTypeFrequency = this.baseballResult.get(baseballType);
            if (eachBaseballTypeFrequency != null && eachBaseballTypeFrequency != ZERO_FREQUENCY) {
                return false;
            }
        }

        return true;
    }

    public int getBaseballTypeFrequency(BaseballType baseballType) {
        return this.baseballResult.get(baseballType);
    }

    public boolean isAllStrike() {
        return this.baseballResult.get(BaseballType.STRIKE) == this.sizeOfBaseball;
    }

    void addBaseballTypeFrequency(BaseballType baseballType) {
        this.baseballResult.put(baseballType, this.baseballResult.get(baseballType) + 1);
    }
}
