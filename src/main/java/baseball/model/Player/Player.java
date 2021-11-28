package baseball.model.Player;

public class Player {
    private PlayerNumber playerNumber;

    public void setPlayerNumber(String number) {
        playerNumber = new PlayerNumber(number);
    }

    public String getPlayerNumber() {
        return this.playerNumber.getPlayerNumber();
    }
}
