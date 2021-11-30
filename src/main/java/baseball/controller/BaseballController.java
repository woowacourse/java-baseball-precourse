package baseball.controller;

import baseball.model.QuizMaker;
import baseball.view.FinishView;
import baseball.view.InputView;
import baseball.view.ResultView;
import baseball.vo.AnswerBall;
import baseball.vo.ResultBall;
import baseball.vo.UserBall;

public class BaseballController {

    public static void startGame() {
        AnswerBall answerBall = new AnswerBall(QuizMaker.createNewQuiz());

        while (answerBall.isTrying()) {
            UserBall userBall = InputView.getUserBallByUserInput();
            ResultBall resultBall = answerBall.getResultBallByUserBall(userBall);
            ResultView.printResultByResultBall(resultBall);
        }

        if (FinishView.needMoreGame()) {
            startGame();
        }
    }

}
