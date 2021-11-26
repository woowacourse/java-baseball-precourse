package baseball.view;

import baseball.model.Balls;
import baseball.model.PlayTypes;

public class OutputView {
    public static void printResult(Balls computerBalls, Balls balls) {
        PlayTypes playTypes = computerBalls.play(balls);
        String playResult = playTypes.getPlayResult();
        System.out.println(playResult);
    }
}
