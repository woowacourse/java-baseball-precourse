package baseball.domain;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String STOP = "2";
    private static final String RESTART_OR_STOP_REQUEST_ERROR_MESSAGE = "1 또는 2만 입력해주세요!";
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

    public void restart(String restartOrStopRequest, BaseballNumbersGenerator baseballNumbersGenerator) {
        if (restartOrStopRequest.equals(RESTART)) {
            playing = true;
            baseballNumbers = BaseballNumbers.createAnswerBaseballNumbers(baseballNumbersGenerator);
            return;
        }

        if (restartOrStopRequest.equals(STOP)) {
            playing = false;
            return;
        }

        throw new IllegalArgumentException(RESTART_OR_STOP_REQUEST_ERROR_MESSAGE);
    }
}
