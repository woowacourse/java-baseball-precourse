package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;
import static baseball.UtilityFunctions.generateAnswerArray;

public class BaseballGame {

    // 현재 게임의 정답을 저장해둘 곳
    private final BaseballNumbers answerNumbers;
    // 유저가 입력한 추측에 맞는 게임 결과를 저장해두는 곳
    private BaseballResult baseballResult;

    public BaseballGame() {
        this.answerNumbers = new BaseballNumbers(generateAnswerArray());
        this.baseballResult = new BaseballResult(0, 0);
    }

    // 입력받은 userGuessArray를 이용하여 경기를 진행하여 스트라이크/볼을 계산하는 메소드
    public void playBall(int[] userGuessArray) {
        BaseballNumbers userGuessNumbers = new BaseballNumbers(userGuessArray);

        final int countOfStrike = this.answerNumbers.getCountOfStrike(userGuessNumbers);
        final int countOfBall = this.answerNumbers.getCountOfBall(userGuessNumbers);

        this.baseballResult = new BaseballResult(countOfStrike, countOfBall);
    }

    // 저장중인 BaseballResult 를 반환하는 메소드
    public BaseballResult getBaseballResult() {
        return this.baseballResult;
    }

    // 경기가 끝나있는지를 boolean 으로 알려주는 메소드
    public boolean isFinished() {
        return this.baseballResult.getStrike() == GAME_MAX_BASEBALL_PITCH;
    }
}
