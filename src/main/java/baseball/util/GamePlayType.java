package baseball.util;

public enum GamePlayType {
    GAME_PLAY(0, "게임 플레이"),
    GAME_REPLAY(1, "게임 재시작"),
    GAME_OVER(2, "게임 종료");

    private final int value;
    private final String description;

    GamePlayType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }
}
