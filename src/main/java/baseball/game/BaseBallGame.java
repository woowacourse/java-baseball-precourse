package baseball.game;

import baseball.hitter.Hitter;
import baseball.pitcher.Pitcher;
import baseball.pitcher.PitchingResult;

public class BaseBallGame {

    private Hitter hitter;
    private PitchingResult lastPitchingResult;

    public BaseBallGame() {
        resetHitter();
    }

    BaseBallGame(Hitter hitter) {
        if (hitter == null) {
            throw new IllegalArgumentException("hitter 가 null 입니다.");
        }
        this.hitter = hitter;
    }

    public boolean isGameEnd() {
        return lastPitchingResult != null && lastPitchingResult.isSuccess();
    }

    public PitchingResult getLastPitchingResult() {
        return lastPitchingResult;
    }

    public void restart() {
        resetHitter();
        lastPitchingResult = null;
    }

    public PitchingResult mount(Pitcher pitcher) {
        assertPitcher(pitcher);
        checkGameEnd();

        lastPitchingResult = pitcher.play(hitter);
        return lastPitchingResult;
    }

    private void resetHitter() {
        this.hitter = new Hitter();
    }

    public PitchingResult mount(String pitchingStr) {
        return mount(new Pitcher(pitchingStr));
    }

    private void checkGameEnd() {
        if (this.isGameEnd()) {
            throw new IllegalStateException("게임이 이미 종료되었습니다");
        }
    }

    private void assertPitcher(Pitcher pitcher) {
        if (pitcher == null) {
            throw new IllegalArgumentException("pitcher 가 null 입니다");
        }
    }
}
