package baseball.controller;

import baseball.model.QuizMaker;
import baseball.view.FinishView;
import baseball.view.InputView;
import baseball.view.ResultView;
import baseball.model.Answer;
import baseball.vo.ResultBall;
import baseball.vo.UserBall;

public class BaseballController {

    public static void startGame() {
        Answer answer = new Answer(QuizMaker.createNewQuiz());

        while (answer.isTrying()) {
            UserBall userBall = InputView.getUserBallByUserInput();
            ResultBall resultBall = answer.getResultBallByUserBall(userBall);
            ResultView.printResultByResultBall(resultBall);
        }

        if (FinishView.needMoreGame()) {
            startGame();
        }
    }

}
