package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static boolean EXIT = false;
    static boolean REPLAY = true;

    public static void main(String[] args) {
        while (true) {
            boolean gameResult = PlayGame();
            boolean replayOrExit = DecideReplayOrExit(gameResult);

            if (replayOrExit == EXIT) {
                break;
            }
        }
    }

}
