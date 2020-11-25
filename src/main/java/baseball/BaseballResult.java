package baseball;

import domain.BaseBall;

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
        printBallAndCount();
    }

    private boolean isNothing() {
        int ballCount = result.get(BallType.BALL);
        int strikeCount = result.get(BallType.STRIKE);
        return ballCount == ZERO && strikeCount == ZERO;
    }

    private void printBallAndCount() {
        Set<BallType> ballTypes = result.keySet();
        ballTypes.stream()
                .filter(ballType -> this.getCount(ballType) > ZERO)
                .forEach(ballType -> ballType.printNameWith(this.getCount(ballType)));
    }

    public int getCount(BallType ballType){
        return result.get(ballType);
    }

    public boolean isAnswer(){
        return result.get(BallType.STRIKE) == ANSWER_COUNT;
    }

}
