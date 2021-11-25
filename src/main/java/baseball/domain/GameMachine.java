package baseball.domain;

import java.util.List;

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
        start(new BaseballNumbers());
    }

    private void start(BaseballNumbers baseballNumbers) {
        while (true) {
            List<Integer> inputNumbers = inputView.getInputNumbers();
            BaseballState baseballState = baseballReferee.referee(baseballNumbers.getNumbers(), inputNumbers);
            outputView.outputRefereeResult(baseballState.getMessage());

            if (baseballState.isSuccess()) {
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