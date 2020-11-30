package baseball;

import utils.*;

import java.util.Scanner;

import static utils.Constant.*;

public class BaseballGame {


    private Player player;
    private Computer computer;
    private int strike;
    private int ball;

    public BaseballGame(Scanner scanner) {
        computer = new Computer();
        player = new Player(scanner);
        strike = 0;
        ball = 0;
    }

    public void initialBalls(){
        computer.setBalls();
        player.inputBalls();
    }

    public void compareBalls(){
        
    }

}
