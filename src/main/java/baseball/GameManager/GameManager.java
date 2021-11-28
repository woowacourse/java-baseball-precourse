package baseball.GameManager;

import baseball.Result.BallResult;
import baseball.Result.NothingResult;
import baseball.Result.ResultBase;
import baseball.Result.StrikeAndBallResult;
import baseball.Result.StrikeResult;

public class GameManager {
    private static GameManager instance = null;

    public ResultBase result;

    private GameManager() {
        result = new StrikeResult();
        result.appendNext(
                new StrikeAndBallResult().appendNext(
                        new BallResult().appendNext(
                                new NothingResult()
                        )
                )
        );
    }

    public static GameManager getInstance() {
        if(GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }

        return GameManager.instance;
    }
}
