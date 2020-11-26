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
}
