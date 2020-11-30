package baseball;

import java.util.Scanner;

public class Game {
    private static final int NUMBER_LEN = 3;
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    private static final String VICTORY_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Computer computer;
    private User user;
    private Hint hint;
    private boolean running;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.computer = new Computer();
        this.user = new User();
        this.hint = new Hint(0, 0);
        this.running = true;
        this.scanner = scanner;
    }

    public void start() {
        do {
            startGame();
        } while (isRestart());
    }

    private void startGame() {
        while (running) {
            user.enterNumber(scanner);
            hint.countHint(computer.answer, user.userNumber);
            hint.printHint();

            if (hint.getStrike() == NUMBER_LEN) {
                System.out.println(VICTORY_MESSAGE);
                running = false;
            }
        }
    }

    private boolean isRestart() {
        System.out.println(RESTART_MESSAGE);

        int restart = scanner.nextInt();

        if (restart == RESTART) {
            computer = new Computer();
            running = true;
            return true;
        } else if (restart == EXIT) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
