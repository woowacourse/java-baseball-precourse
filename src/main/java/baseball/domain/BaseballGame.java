package baseball.domain;

public class BaseballGame {
    private boolean playing;
    private BaseballNumbers baseballNumbers;

    private BaseballGame(boolean playing, BaseballNumbers baseballNumbers) {
        this.playing = playing;
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballGame play(BaseballNumbersGenerator baseballNumbersGenerator) {
        return new BaseballGame(true, BaseballNumbers.createAnswerBaseballNumbers(baseballNumbersGenerator));
    }

    public int countStrike(BaseballNumbers baseballNumbers) {
        return this.baseballNumbers.compareStrike(baseballNumbers);
    }

    public int countBall(BaseballNumbers baseballNumbers) {
        return this.baseballNumbers.compareBall(baseballNumbers);
    }

    public boolean isCorrectTo(BaseballNumbers baseballNumbers) {
        return this.baseballNumbers.isEqualTo(baseballNumbers);
    }

    public void stop() {
        playing = false;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void restart(RestartManager restartManager, BaseballNumbersGenerator baseballNumbersGenerator) {
        if (restartManager.canRestart()) {
            playing = true;
            baseballNumbers = BaseballNumbers.createAnswerBaseballNumbers(baseballNumbersGenerator);
            return;
        }

        playing = false;
    }
}
