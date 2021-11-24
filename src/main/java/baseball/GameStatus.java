package baseball;

public enum GameStatus {
    START("0")
    ,RESTART("1")
    ,STOP("2")
    ,PAUSE("3");

    private final String controlParam;

    GameStatus(String controlParam) {
        this.controlParam = controlParam;
    }

    public String getControlParam() {
        return controlParam;
    }
}
