package baseball.vo;

import java.util.List;

public class AnswerBall {

    private List<Integer> answer;
    private boolean isTrying = true;

    public AnswerBall(List<Integer> newQuiz) {
        this.answer = newQuiz;
    }

    public boolean isTrying() {
        return isTrying;
    }

    public ResultBall getResultBallByUserBall(UserBall userBall) {
        List<Integer> userInputList = userBall.getUserInputList();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            Integer answerNumber = answer.get(i);
            Integer userInputNumber = userInputList.get(i);

            if (answerNumber == userInputNumber) {
                strike++;
            } else if (answer.contains(userInputNumber)) {
                ball++;
            }
        }

        setIsTryingByStrike(strike);
        return new ResultBall(strike, ball);
    }

    private void setIsTryingByStrike(int strike) {
        if (strike == 3) {
            isTrying = false;
        }
    }

}
