/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Game.java
 * 게임을 진행하기 위한 클래스
 *
 * @author		Sorin Jin
 * @version		1.0
 * @date		03 Dec 2019
 *
 */
public class Game {
    static final int THREE_STRIKE = 3;
    static final int REPLAY = 1;
    static final int EXIT_GAME = 2;

    Computer computer;
    Player player;

    private void init(){
        computer = new Computer();
        player = new Player();
    }

    private void play(){
        Result result;
        computer.generateRandomNumber();
        do {
            result = computer.checkAnswer(player.getInput());
            computer.printScore();
        } while (result.getNumberOfStrike() != THREE_STRIKE);
        System.out.println(Message.GAME_IS_END);
        restartOrExit();
    }

    private void restartOrExit(){
        int answer = player.wantReplay();
        if (answer == REPLAY) {
            play();
        } else {
            System.exit(0);
        }
    }

    public void run(){
        init();
        play();
    }
}
