package baseball;

import baseball.domain.Number;
import baseball.service.BaseBallService;
import baseball.utils.RandomUtils;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final int SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;

    BaseBallService baseBallService = new BaseBallService();
    Number number = new Number(SIZE);

    public void run() throws IllegalArgumentException{
        gameSet();
        gameStart();
        gameOver();
        askRetry();
    }

    private void gameSet() {
        number.setGameNumbers(RandomUtils.getRandomNumbers(SIZE, START_INCLUSIVE, END_INCLUSIVE));
    }

    // TODO: 제출전에 println 제거하기
    private void gameStart() throws IllegalArgumentException{
        System.out.println(number.getGameNumbers()[0]+""+number.getGameNumbers()[1]+""+number.getGameNumbers()[2]);
        baseBallService.playGame(number, SIZE);
    }

    private void gameOver() throws IllegalArgumentException{
        SystemMessage.printGameOverMessage();
        RequestInput.printRetryMessage();
    }

    /**
     * 유저입력이 (문자 or 0 or 3 이상)  : Exception
     * 유저입력이 (1)                  : 재시작
     * 유저입력이 (2)                  : 종료
     */
    private void askRetry() throws IllegalArgumentException{
        String input = Console.readLine();
        int inputNum = Integer.parseInt(input);

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }

        if (inputNum == RETRY) {
            run();
        }
    }
}
