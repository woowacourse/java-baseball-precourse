package numberBaseball;

import numberBaseball.player.*;

public class NumberBaseball {
    private String gameMode = "시작 모드";

    public String getGameMode() {
        return this.gameMode;
    }

    public void setGameMode() {

    }

    public void startGame(Player guesser, Player answerer) {

    }

    public static void main(String args[]) {
        NumberBaseball numberBaseball =  new NumberBaseball();
        Player player = new User();
        Player playerBot = new PlayerBot();

        while (numberBaseball.getGameMode() != "게임 종료") {
            numberBaseball.setGameMode();
            numberBaseball.startGame(player, playerBot);
        }
    }
}