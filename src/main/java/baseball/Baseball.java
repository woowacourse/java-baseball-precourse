package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {

    public void startBaseball() {

        boolean retry;

        do {
            Game game = new Game();
            game.playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            retry = retryGame();
        } while (retry);
    }

    private boolean retryGame() {
        String retryInput;
        retryInput = Console.readLine();

        Validator validator = new Validator();
        validator.validateRetryInput(retryInput);

        return doesRetry(retryInput);
    }

    private boolean doesRetry(String retryInput) {

        return retryInput.equals("1");
    }
}
