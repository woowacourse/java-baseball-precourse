package baseball.controller;

import baseball.constant.BallConstant;
import baseball.model.Balls;
import baseball.model.PlayType;
import baseball.model.PlayTypes;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.ScannerInputStrategy;

import java.util.List;

public class BaseBallController {

    private static final int EXIT = 2;

    public void run() {
        int inputContinueOrEnd;
        do {
            inputContinueOrEnd = play();
        } while (inputContinueOrEnd != EXIT);
    }

    private int play() {
        Balls computerBalls = InputView.getRandomBalls();
        Balls playerBalls;
        do {
            playerBalls = InputView.inputNumber(new ScannerInputStrategy());
            OutputView.printResult(computerBalls, playerBalls);
        } while (!isEndGame(computerBalls, playerBalls));

        OutputView.displayAfterEnd();
        return InputView.inputChoiceAfterEnd();
    }

    boolean isEndGame(Balls computerBalls, Balls playerBalls) {
        PlayTypes playTypes = computerBalls.compare(playerBalls);
        List<PlayType> playTypeList = playTypes.getPlayType();
        long strikeCount = playTypeList.stream().filter(PlayType.STRIKE::equals).count();
        return strikeCount == BallConstant.BALLS_LENGTH;
    }
}
