package com.github.callmewaggs.javabaseballprecourse;

public class Game {
    Computer computer;
    User user;
    Score score;

    public Game() {
        computer = new Computer();
        user = new User();
        score = new Score();
    }

    public void gameStart() {
        computer.generateRandomBall();
        score.init();

        while(true) {
            user.generateInputBall();

            score.calculate(computer.getBall(), user.getBall());

            if(score.getStrike() == 3) {
                if(gameAgain()) {
                    computer.generateRandomBall();
                    score.init();
                } else {
                    break;
                }
            }
        }
    }
}
