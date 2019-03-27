package me.bactoria.baseball.domain;

import me.bactoria.baseball.UserInterface;

public class BaseballGame {
    private final Computer computer;
    private final Player player;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void play() {
        boolean isCorrectNumber = false;

        while (!isCorrectNumber) {

            int playerNumber = UserInterface.getPlayerNumber();
            player.setPlayerNumber(playerNumber);

            if (computer.isAnswer(player.getPlayerNumber())) {
                isCorrectNumber = true;
            } else {
                UserInterface.printHint(computer.getHint(player.getPlayerNumber()));
            }
        }
    }
}
