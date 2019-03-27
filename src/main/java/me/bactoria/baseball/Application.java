package me.bactoria.baseball;

import me.bactoria.baseball.domain.BaseballGame;
import me.bactoria.baseball.domain.Computer;
import me.bactoria.baseball.domain.Player;
import me.bactoria.baseball.domain.State;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer() {
            @Override
            public boolean isAnswer(int playerNumber) {
                return true;
            }

            @Override
            public String getHint(int playerNumber) {
                return "힌트";
            }
        };
        Player player = new Player() {
            @Override
            public void setPlayerNumber(int playerNumber) {
            }

            @Override
            public int getPlayerNumber() {
                return 789;
            }
        };

        State state = State.PLAY_CONTINUE;

        while (state == State.PLAY_CONTINUE) {
            BaseballGame baseballGame = new BaseballGame(computer, player);
            baseballGame.play();
            state = getState();
        }
    }

    private static State getState() {
        return State.findState(UserInterface.getState());
    }
}
