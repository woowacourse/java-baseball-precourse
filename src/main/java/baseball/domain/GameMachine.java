package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameMachine {
    private final BaseballReferee baseballReferee;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine(BaseballReferee baseballReferee, InputView inputView, OutputView outputView) {
        this.baseballReferee = baseballReferee;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        while (true) {
            BaseballState state = baseballReferee.referee(baseballNumbers.getNumbers(), inputView.getInputNumbers());
            outputView.outputRefereeResult(state.getMessage());

            if (state.isSuccess()) {
                outputView.outputSuccess();
                restart();
                break;
            }
        }
    }

    private void restart() {
        if (inputView.isRestart()) {
            run();
        }
    }
}