package resources;

/**
 * @author delf
 */
public enum GameMessage {
    STRIKE(" 스트라이크"),
    BALL(" 볼"),
    NO_STRIKE_NO_BALL("낫싱"),
    CORRECT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    YES("1"),
    NO("2");

    private final String message;

    public String value() {
        return message;
    }

    GameMessage(String message) {
        this.message = message;
    }
}
