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
        Hint hint;

        computer.pickNumber();

        do {
            System.out.print(Message.REQUEST_NUMBER_INPUT);
            playerNumber = requestPlayerNumber(scanner);
            hint = Comparator.extractHint(computer.getNumber(), playerNumber);
            System.out.println(hint.toMessage());
        } while (!checkAnswer(hint));

        System.out.println(Message.GAME_CLEAR);
    }

    private boolean checkRestart() {
        // TODO: 플레이어의 입력에 따른 재시작 여부 결정
        System.out.println(Message.REQUEST_RESTART_INPUT);
        return false;
    }

    private Number requestPlayerNumber(Scanner scanner) {
        String playerInput = player.requestInput(scanner);
        if (!Number.checkValidation(playerInput)) {
            throw new IllegalArgumentException();
        }
        return new Number(playerInput);
    }

    private boolean checkAnswer(Hint hint) {
        return hint.checkStrikeAll();
    }
}
