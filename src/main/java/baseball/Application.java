package baseball;

import baseball.runner.GameRunner;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        getGameRunner().run();
    }

    public static GameRunner getGameRunner() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new GameRunner(inputView, outputView);
    }
}
