package baseball.GameManager;

import baseball.Result.BallResult;
import baseball.Result.NothingResult;
import baseball.Result.ResultBase;
import baseball.Result.StrikeAndBallResult;
import baseball.Result.StrikeResult;
import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
    private static GameManager instance = null;

    public ResultBase result;

    private GameManager() {
        ResultBase strikeResult = new StrikeResult();
        ResultBase strikeAndBallResult = new StrikeAndBallResult();
        ResultBase ballResult = new BallResult();
        ResultBase nothingResult = new NothingResult();

        strikeResult.appendNext(strikeAndBallResult);
        strikeAndBallResult.appendNext(ballResult);
        ballResult.appendNext(nothingResult);

        this.result = strikeResult;
    }

    public static GameManager getInstance() {
        if (GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }

        return GameManager.instance;
    }
}
