package baseball;

public class BaseballCompare {

    public static BaseballCounter compare(BaseballNumber randomNum, BaseballNumber playerNum) {
        BaseballCounter baseballCounter = new BaseballCounter();

        for (int i = 0; i < randomNum.size(); i++) {
            if (randomNum.getIndexValue(i).equals(playerNum.getIndexValue(i))) {
                baseballCounter.strikeIncreaseCounter();
            } else if (playerNum.contains(randomNum.getIndexValue(i))) {
                baseballCounter.ballIncreaseCounter();
            }
        }
        return baseballCounter;
    }
}

