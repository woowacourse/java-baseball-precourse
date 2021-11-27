package baseball.controller;

import baseball.model.Balls;
import baseball.model.PlayType;
import baseball.model.PlayTypes;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.ScannerInputStrategy;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.ref.PhantomReference;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class BaseBallController {

    private static final int BALL_ROUND = 3;

    public void run() {
        Balls computerBalls = InputView.getRandomBalls();
        Balls playerBalls;
//        out.println("컴퓨터 입력값:  " + computerBalls);
        do {
            playerBalls = InputView.inputNumber(new ScannerInputStrategy());
            OutputView.printResult(computerBalls, playerBalls);
        } while (!isEndGame(computerBalls, playerBalls));

        OutputView.displayAfterEnd();
        int inputContinueOrEnd = InputView.inputChoiceAfterEnd();

        if (inputContinueOrEnd == 1) {
            run();
        }
    }



    boolean isEndGame(Balls computerBalls, Balls playerBalls) {
        PlayTypes playTypes = computerBalls.play(playerBalls);
        List<PlayType> playTypeList = playTypes.getPlayType();
        long strikeCount = playTypeList.stream().filter(PlayType.STRIKE::equals).count();
        return strikeCount == BALL_ROUND;
    }
}
