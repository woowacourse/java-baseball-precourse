package baseball;

import static baseball.UtilityFunctions.generateAnswerArray;

public class BaseballGame {

    // 현재 게임의 정답을 저장해둘 곳
    private final BaseballNumbers answerNumbers;

    public BaseballGame() {
        this.answerNumbers = new BaseballNumbers(generateAnswerArray());
    }

    // 입력받은 userGuessArray를 이용하여 경기를 진행하여 경기 결과를 반환하는 메소드
    public BaseballResult playBall(int[] userGuessArray) {
        final BaseballNumbers userGuessNumbers = new BaseballNumbers(userGuessArray);

        return new BaseballResult(this.answerNumbers, userGuessNumbers);
    }
}
