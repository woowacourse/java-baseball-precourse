package baseball;

import java.util.Scanner;

/**
 * GameController.java
 * 게임의 흐름 제어를 담당하는 클래스
 */
public class GameController {
    private final Scanner scanner;
    private final Player player;
    private final Computer computer;

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

    private void startRound() {
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

    private Number requestPlayerNumber(Scanner scanner) {
        String playerInput = player.requestInput(scanner);
        Number playerNumber;

        try {
            playerNumber = new Number(playerInput);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            /*
             * 재귀로 처리해도 되는지 의문이 든다. 성장하고 다시 보자.
             */
            return requestPlayerNumber(scanner);
        }

        return playerNumber;
    }

    private boolean checkAnswer(Hint hint) {
        return hint.checkStrikeAll();
    }

    private boolean checkRestart() {
        System.out.println(Message.REQUEST_COMMAND_TYPE_INPUT);
        CommandType playerCommandType = requestCommandNumber(scanner);
        return playerCommandType.equals(CommandType.RESTART);
    }

    private CommandType requestCommandNumber(Scanner scanner) {
        String playerInput = player.requestInput(scanner);
        CommandType playerCommandType;

        try {
            playerCommandType = CommandType.convert(playerInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return requestCommandNumber(scanner);
        }

        return playerCommandType;
    }
}
