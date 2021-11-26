package baseball;

import baseball.repository.BaseBall;
import baseball.repository.Number;
import baseball.service.Compute;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final int SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;

    Parser parser = new Parser();
    Compute compute = new Compute();
    SystemMessage systemMessage = new SystemMessage();
    Number number = new Number(SIZE);

    public void run() throws IllegalArgumentException{
        gameSet();
        gameStart();
    }

    private void gameSet() {
        number.setGameNumbers(RandomUtils.getRandomNumbers(SIZE, START_INCLUSIVE, END_INCLUSIVE));
    }

    private void gameStart() throws IllegalArgumentException{
        System.out.println(number.getGameNumbers()[0]+""+number.getGameNumbers()[1]+""+number.getGameNumbers()[2]);
        play();
        gameOver();
    }

    private void play() throws IllegalArgumentException{
        int strike = 0;
        while (strike != 3) {
            number.setUserNumbers(getUserNumber());
            BaseBall baseBall = compute.computeScore(number.getGameNumbers(), number.getUserNumbers(), SIZE);
            systemMessage.scoreMessage(baseBall.getBallCount(), baseBall.getStrikeCount());
            strike = baseBall.getStrikeCount();
        }
    }

    private int[] getUserNumber() throws IllegalArgumentException{
        RequestInput.requestInputData();

        String input = Console.readLine();
        int inputNum[] = parser.userInputParser(input);

        return inputNum;
    }

    private void gameOver() throws IllegalArgumentException{
        systemMessage.gameSetMessage();
        RequestInput.retryMessage();
        askRetry();
    }

    /**
     * 유저입력이 (문자 or 0 or 3 이상)  : Exception
     * 유저입력이 (1)                  : 재시작
     * 유저입력이 (2)                  : 종료
     */
    private void askRetry() throws IllegalArgumentException{
        String input = Console.readLine();
        int inputNum = Integer.parseInt(input);
        if (inputNum == 0 || inputNum > 2) {
            throw new IllegalArgumentException();
        }
        if (inputNum == 1) {
            run();
        }
    }
}
