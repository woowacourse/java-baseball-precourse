package com.woowa.baseball;

public class Main {

    public static void main(String[] args) {
        Game game = new BaseballGame();

        while(game.run());
        game.exit();
    }
}
