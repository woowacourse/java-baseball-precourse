package baseball.game;

import baseball.domain.BaseballType;

import java.util.List;
import java.util.Set;

public class BaseballGameRule {
    public BaseballResult guessRandomAndPlayerBaseball(List<Integer> playerBaseballList, List<Integer> randomBaseballList,
                                                       Set<Integer> randomBaseBallSet) {
        BaseballResult baseballResult = new BaseballResult(playerBaseballList.size());
        for (int indexOfBaseball = 0; indexOfBaseball < playerBaseballList.size(); indexOfBaseball += 1) {
            int playerNowBaseballData = playerBaseballList.get(indexOfBaseball);
            if (playerNowBaseballData == randomBaseballList.get(indexOfBaseball)) {
                baseballResult.addBaseballTypeFrequency(BaseballType.STRIKE);
            } else if (randomBaseBallSet.contains(playerNowBaseballData)) {
                baseballResult.addBaseballTypeFrequency(BaseballType.BALL);
            }
        }

        return baseballResult;
    }
}
