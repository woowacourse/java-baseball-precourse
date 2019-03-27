package me.bactoria.baseball;

import me.bactoria.baseball.domain.BaseballGame;
import me.bactoria.baseball.domain.Computer;
import me.bactoria.baseball.domain.Player;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer() {
            @Override
            public boolean isAnswer(int playerNumber) {
                return false;
            }

            @Override
            public String getHint(int playerNumber) {
                return "힌트";
            }
        };
        Player player= new Player() {
            @Override
            public void setPlayerNumber(int playerNumber) {
            }

            @Override
            public int getPlayerNumber() {
                return 789;
            }
        };

        BaseballGame baseballGame = new BaseballGame(computer, player);
        baseballGame.play();
    }
}
