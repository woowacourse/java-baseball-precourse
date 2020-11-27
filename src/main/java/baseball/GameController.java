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
        do {
            startRound();
        } while (checkRestart());
    }

    public void startRound() {
        Number playerNumber;

        computer.pickNumber();
        do {
            playerNumber = requestPlayerNumber(scanner);

        } while (checkAnswer());
    }

    private boolean checkRestart() {
        // TODO: 플레이어의 입력에 따른 재시작 여부 결정
        return false;
    }

    private Number requestPlayerNumber(Scanner scanner) {
        // TODO: 플레이어의 입력을 받아와 Number로 변환
        return null;
    }

    private boolean checkAnswer() {
        // TODO: 컴퓨터와 플레이어의 숫자를 비교하여 정답 여부 결정
        return false;
    }
}
