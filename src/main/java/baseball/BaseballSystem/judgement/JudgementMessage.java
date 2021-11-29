package baseball.BaseballSystem.judgement;

public enum JudgementMessage {

    CORRECT_ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING_MESSAGE("낫싱");

    private final String message;

    JudgementMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String fullStrikeMessage(int strike) {
        return strikeMessage(strike) + "\n" + CORRECT_ANSWER_MESSAGE.getMessage();
    }

    public static String notThingMessage() {
        return NOTHING_MESSAGE.getMessage();
    }

    public static String strikeMessage(final int strike) {
        return strike + "스트라이크";
    }

    public static String ballMessage(final int ball) {
        return ball + "볼";
    }

    public static String ballAndStrikeMessage(final int ball, final int strike) {
        return ball + "볼 " + strike + "스트라이크";
    }
}
