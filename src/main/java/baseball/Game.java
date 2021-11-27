package baseball;

import utils.Judge;
import utils.Result;


public class Game {

    private Computer computer;
    private Player player;
    private Result result;
    private int[] answer;
    private int[] input;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
        this.result = new Result();
    }

    public void setAnswer() {
        answer = computer.generateAnswer();
    }

    public void input() {
        input = player.getInput();
    }

    public void start() {
        boolean end = false;
        while (!end) {
            input();
            Judge judge = new Judge();
            judge.checkNum(answer, input);
            end = result.printResult(judge.getStrike(), judge.getBall());
        }
    }

    public boolean quitOrNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int response = player.getQuitOrNewGameInput();
        if (response == 1) {
            return true;
        }
        return false;
    }
}

