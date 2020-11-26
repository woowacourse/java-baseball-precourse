package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseballResult {
    private static final int ANSWER_COUNT = 3;
    private static final int ZERO = 0;
    private Map<BallType, Integer> result;

    public BaseballResult() {
        initResult();
    }

    private void initResult() {
        Map<BallType, Integer> result = new HashMap<>();
        for (BallType value : BallType.values()) {
            result.put(value, 0);
        }
        this.result = result;
    }

    public void accumulateBallType(BallType ballType){
        result.put(ballType, result.get(ballType)+1);
    }

    public void printResult(){
        if(isNothing()){
            System.out.println("낫싱");
            return;
        }
        printBallAndStrike();
    }

    private boolean isNothing() {
        int ballCount = result.get(BallType.BALL);
        int strikeCount = result.get(BallType.STRIKE);
        return ballCount == ZERO && strikeCount == ZERO;
    }

    private void printBallAndStrike() {
        Set<BallType> ballTypes = result.keySet();
        ballTypes.stream()
                .filter(ballType -> countFor(ballType) > ZERO)
                .forEach(ballType -> ballType.printNameWith(countFor(ballType)));
    }
    //test에도 사용되어 public으로 선언
    public int countFor(BallType ballType){
        return result.get(ballType);
    }

    public boolean isAnswer(){
        return result.get(BallType.STRIKE) == ANSWER_COUNT;
    }

}
