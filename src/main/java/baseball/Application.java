package baseball;

import baseball.application.runner.BaseBallGame;
import baseball.application.service.Referee;
import baseball.application.view.InputValidation;
import baseball.application.view.InputView;
import baseball.application.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputValidation inputValidator = new InputValidation();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();
        Referee referee = new Referee();
        BaseBallGame game = new BaseBallGame(inputView, outputView, referee);
        game.start();
    }

}
