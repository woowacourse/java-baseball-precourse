package baseball;

import java.util.Scanner;

public class Game {

    private Answer answer;
    private Player player;
    private Checker checker;
    private Result result;

    public Game(Scanner scanner) {
        player = new Player(scanner);
        result = new Result();
    }


    public void start() {
        while (player.isRepeat()) {
            answer = new Answer();
            play();
            player.updateRepeat();
        }
    }

    private void play() {
        do {
            result.init();
            player.guess();
            checker = new Checker(answer.getAnswers(), player.getNums(), result);
            result.printHint();
        } while (result.strike < 3);
        printFinished();
    }

    private void printFinished() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
    }
}
