package baseball;

import baseball.runner.BaseBallGame;
import baseball.runner.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

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
