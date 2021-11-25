package baseball.domain;

import java.util.List;

import baseball.view.InputView;

public class GameMachine {
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final BaseballReferee baseballReferee;
    private final InputView inputView;

    public GameMachine(BaseballReferee baseballReferee, InputView inputView) {
        this.baseballReferee = baseballReferee;
        this.inputView = inputView;
    }

    public void run() {
        start(new BaseballNumbers());
    }

    private void start(BaseballNumbers baseballNumbers) {
        System.out.println(baseballNumbers.getNumbers());
        while (true) {
            List<Integer> inputNumbers = inputView.getInputNumbers();
            BaseballState baseballState = baseballReferee.referee(baseballNumbers.getNumbers(), inputNumbers);

            System.out.println(baseballState.getMessage());

            if (baseballState.isSuccess()) {
                System.out.println(END_MESSAGE);
                break;
            }
        }
    }
}