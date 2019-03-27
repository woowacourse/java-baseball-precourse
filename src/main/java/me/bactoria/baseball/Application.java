package me.bactoria.baseball;

import me.bactoria.baseball.domain.BaseballGame;
import me.bactoria.baseball.domain.Computer;
import me.bactoria.baseball.domain.Player;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer() {};
        Player player= new Player() {};

        BaseballGame baseballGame = new BaseballGame(computer, player);
        baseballGame.play();
    }
}
