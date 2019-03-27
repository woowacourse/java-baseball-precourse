package com.nekisse.baseball;

public class App {
    public static final int GAME_END_COMMAND = 1;
    private BaseBallGame baseBallGame;

    public App() {
        this.baseBallGame = new BaseBallGame();
    }

    public void start() {
        int command = GAME_END_COMMAND;

        while (command == GAME_END_COMMAND) {
            baseBallGame.startGame();
            command = InputView.printReGame();
        }
    }
}
