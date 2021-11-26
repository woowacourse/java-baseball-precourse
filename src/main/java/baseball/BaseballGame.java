package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class BaseballGame {
    private final static String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String RESTART = "1";
    private final static String QUIT = "2";
    private Computer computer;
    private User user;
    private GameReferee gameReferee;
    private ArrayList<Integer> computerNumberList;
    private ArrayList<Integer> userNumberList;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.gameReferee = new GameReferee();
    }

    public void startGame() {
        while (this.playBaseBallGame()) {
            computerNumberList.clear();
            userNumberList.clear();
        }
    }

    private boolean playBaseBallGame() {
        computerNumberList = computer.createComputerNumber();
        userNumberList = user.inputUserNumber();

        while (!gameReferee.decideResult(computerNumberList, userNumberList)) {
            userNumberList = user.inputUserNumber();
        }

        return this.selectRestartOrQuit();
    }

    /* 재시작 및 종료 선택 함수 */
    private boolean selectRestartOrQuit() {
        System.out.println(RESTART_MSG);
        String userSelection = Console.readLine();

        return validateUserSelection(userSelection);
    }

    /* 입력값 검증 함수 */
    private boolean validateUserSelection(String userSelection) throws IllegalArgumentException {
        if (!userSelection.equals(RESTART) && !userSelection.equals(QUIT)) {
            throw new IllegalArgumentException("오류 : 잘못된 값 입력 (1과 2만 입력 가능)");
        }
        if (userSelection.equals(QUIT)) {
            return false;
        }
        return true;
    }
}
