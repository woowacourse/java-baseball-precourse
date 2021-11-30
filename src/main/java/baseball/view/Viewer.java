package baseball.view;

import static baseball.util.Constant.*;

public class Viewer {
    public static void inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printStrikeBall(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball != ZERO) {
            sb.append(ball);
            sb.append(BALL_MESSAGE);
            sb.append(SPACE);
        }
        if (strike != ZERO) {
            sb.append(strike);
            sb.append(STRIKE_MESSAGE);
        }
        if (strike == NUMBER_SIZE) {
            sb.append(NEW_LINE);
            sb.append(GAME_END_MESSAGE);
        }
        if (strike == ZERO && ball == ZERO) {
            sb.append(NOTHING_MESSAGE);
        }
        System.out.println(sb.toString());
    }

    public static void printEndMessage() {
        System.out.println(GAME_REPLAY_FINISH_MESSAGE);
    }


}
