package baseball;

import java.util.Scanner;
import interfaces.IGame;

public class Game implements IGame {

    public static final int INPUT_RESTART = 1;
    public static final int INPUT_STOP = 2;

    private boolean isPlaying = true;

    private Computer computer;
    private Player player;
    private Hint hint;

    public Game() {
        computer = new Computer();
        player = new Player();
        hint = new Hint();
    }

    @Override
    public void startGame(Scanner scanner) {
        // TODO Auto-generated method stub
        computer.makeRandomNumber();

        while (true) {
            printInputMessage();
            player.inputThreeNumber(scanner);
            printHint();
            if (hint.isCorrectAnswer(player.getBaseballGameNumber(),
                    computer.getBaseballGameNumber())) {
                break;
            }
        }

        printGameEndMessage();
        inputForRestartFromPlayer(scanner);
    }

    private void inputForRestartFromPlayer(Scanner scanner) {
        int input = player.inputForRestart(scanner);
        isPlaying = input == INPUT_RESTART;
    }

    private void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void printHint() {
        String hintMessage =
                hint.getHint(player.getBaseballGameNumber(), computer.getBaseballGameNumber());
        System.out.println(hintMessage);
    }

    @Override
    public boolean isGamePlaying() {
        return isPlaying;
    }

}
