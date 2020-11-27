package baseball;

import java.util.Scanner;

/**
 * GameController.java
 * 게임의 흐름 제어를 담당하는 클래스
 */
public class GameController {
    private Scanner scanner;
    private Player player;
    private Computer computer;

    public GameController(Scanner scanner, Player player) {
        this.scanner = scanner;
        this.player = player;
        this.computer = new Computer();
    }

    public void run() {

    }
}
