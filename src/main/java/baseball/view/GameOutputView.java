package baseball.view;

import baseball.util.MessageType;

public class GameOutputView {

    public GameOutputView() {
    }

    public void outputAnswerResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(MessageType.OUTPUT_RESULT_NOTHING.getMessage());
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + MessageType.OUTPUT_RESULT_STRIKE.getMessage());
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + MessageType.OUTPUT_RESULT_BALL.getMessage());
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + MessageType.OUTPUT_RESULT_BALL.getMessage()
                    + " " + strike + MessageType.OUTPUT_RESULT_STRIKE.getMessage());
        }
    }

    public void outputCorrectAnswer() {
        System.out.println(MessageType.OUTPUT_CORRECT_ANSWER.getMessage());
    }
}
