package baseball.domain;

public enum GameType {
    START("1"), END("2");

    private String gameButton;

    GameType(String value) {
        this.gameButton = value;
    }

    public boolean equals(String input){
        return gameButton.equals(input);
    }
}
