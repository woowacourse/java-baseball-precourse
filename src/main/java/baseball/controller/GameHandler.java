package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class GameHandler {
    private static GameHandler instance;
    private final int KEEP_GOING = 0;
    private final int RESTART = 1;
    private final int PROGRAM_EXIT = 2;
    private final int GAME_EXIT = 3;
    private int mode;
    private Player player;
    private Computer computer;

    private GameHandler() {
    }

    public static GameHandler getInstance() {
        if (instance == null) {
            return new GameHandler();
        }

        return instance;
    }

    public int start() {
        init();

        while (mode == KEEP_GOING) {
            mode = playing();
        }

        return isRestart();
    }

    private void init() {
        mode = KEEP_GOING;
        player = Player.getInstance();
        computer = Computer.getInstance();
    }

    private int isRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!checkIsNumbers(input) || input.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == 49) {
            return RESTART;
        }
        return PROGRAM_EXIT;
    }

    private boolean isAnswer(int[] hint) {
        return hint[1] == 3;
    }

    private int playing() {
        try {
            String playerInput = getPlayerInput();
            checkValidInput(playerInput);
            player.playerInput(playerInput);
            int[] hint = computer.generateHint(player.submitTryNumber());
            showHint(hint);
            if (isAnswer(hint)) {
                return GAME_EXIT;
            }
        } catch (Exception e) {
            System.exit(1);
        }

        return KEEP_GOING;
    }

    private String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * @param hint hint[0] : Ball 개수
     *             hint[1] : Strike 개수
     */
    private void showHint(int[] hint) {
        if (hint[0] + hint[1] == 0) {
            System.out.println("낫싱");
        }

        if (hint[0] == 0 && hint[1] != 0) {
            System.out.println(hint[1] + "스트라이크");
        }

        if (hint[0] != 0 && hint[1] == 0) {
            System.out.println(hint[0] + "볼");
        }

        if (hint[0] != 0 && hint[1] != 0) {
            System.out.println(hint[0] + "볼 " + hint[1] + "스트라이크");
        }
    }

    private void checkValidInput(String playerInput) {
        if (checkDuplicated(playerInput) || playerInput.length() != 3 || !checkIsNumbers(playerInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkIsNumbers(String playerInput) {
        for (String input : playerInput.split("")) {
            if (!(48 < input.charAt(0) && input.charAt(0) < 58)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicated(String playerInput) {
        return playerInput.charAt(0) == playerInput.charAt(1) || playerInput.charAt(0) == playerInput.charAt(2) || playerInput.charAt(1) == playerInput.charAt(2);
    }
}
