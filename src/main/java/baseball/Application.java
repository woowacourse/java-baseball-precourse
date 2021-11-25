package baseball;

import baseball.domain.AnswerGenerator;
import baseball.domain.Referee;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Application app = new Application();
        BaseballGameController gameController = app.baseballGameController();
        gameController.runGame();
    }

    public Referee referee() {
        return new Referee();
    }

    public AnswerGenerator answerGenerator() {
        return new AnswerGenerator();
    }

    public BaseballGameController baseballGameController() {
        return new BaseballGameController(referee(), answerGenerator());
    }
}
