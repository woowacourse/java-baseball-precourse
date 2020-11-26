package baseball;

import domain.BaseBall;

public class BallTypeChecker {
    private BaseBall randomBaseball;

    private BallTypeChecker(BaseBall randomBaseball){
        this.randomBaseball = randomBaseball;
    }

    public static BallTypeChecker ballTypeCheckWith(BaseBall randomBaseball){
        return new BallTypeChecker(randomBaseball);
    }

    public BaseballResult startChecking(BaseBall inputBaseball){
        BaseballResult baseballResult = new BaseballResult();
        compare(inputBaseball, baseballResult);
        return baseballResult;
    }

    private void compare(BaseBall inputBaseball, BaseballResult baseballResult) {
        for (int index = 0; index < inputBaseball.size(); index++) {
            if(isStrike(index, inputBaseball)){
                baseballResult.accumulateBallType(BallType.STRIKE);
                continue;
            }
            if(isBall(index, inputBaseball)){
                baseballResult.accumulateBallType(BallType.BALL);
                continue;
            }
        }
    }

    private boolean isStrike(int index, BaseBall inputBaseball){
        return randomBaseball.hasNumber(index, inputBaseball.getNumber(index));
    }

    private boolean isBall(int index, BaseBall inputBaseball){
        return randomBaseball.containsNumber(inputBaseball.getNumber(index));
    }

}
