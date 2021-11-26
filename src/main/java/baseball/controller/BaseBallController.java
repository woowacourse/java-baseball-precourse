package baseball.controller;

import baseball.model.Balls;
import baseball.model.PlayType;
import baseball.model.PlayTypes;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.ScannerInputStrategy;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseBallController {

    private static final int BALL_ROUND = 3;

    public void run() {
        Balls computerBalls = getRandomBalls();
        Balls playerBalls;
        System.out.println("computerBalls = " + computerBalls);
        do {
            playerBalls = InputView.inputNumber(new ScannerInputStrategy());
            OutputView.printResult(computerBalls, playerBalls);
        } while (!isEndGame(computerBalls, playerBalls));
    }

    private Balls getRandomBalls() {
        int randomNumbers = Randoms.pickNumberInRange(100, 999);
        return new Balls(randomNumbers);
    }

    boolean isEndGame(Balls computerBalls, Balls playerBalls) {
        PlayTypes playTypes = computerBalls.play(playerBalls);
        List<PlayType> playTypeList = playTypes.getPlayType();
        long strikeCount = playTypeList.stream().filter(PlayType.STRIKE::equals).count();
        return strikeCount == BALL_ROUND;
    }
}
