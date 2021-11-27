package baseball.view;

import baseball.model.Balls;
import baseball.model.PlayTypes;

import static java.lang.System.out;

public class OutputView {

    private static final String CONGRATULATION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHOICE_CONTINUE_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printResult(Balls computerBalls, Balls balls) {
        PlayTypes playTypes = computerBalls.play(balls);
        String playResult = playTypes.getPlayResult();
        System.out.println(playResult);
    }

    public static void displayAfterEnd() {
        out.println(CONGRATULATION_MESSAGE);
        out.println(CHOICE_CONTINUE_OR_EXIT_MESSAGE);
    }
}
