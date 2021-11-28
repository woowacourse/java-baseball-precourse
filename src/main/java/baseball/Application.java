package baseball;

import baseball.constant.Constant;
import baseball.controller.BaseballGame;
import baseball.model.RetryNumber;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.getRetryNumber());

        if (retryNumber.getRetryNumber() == Constant.GAME_RETRY_NUMBER) {
            return true;
        }
        return false;
    }
}
