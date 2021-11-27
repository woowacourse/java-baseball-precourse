package baseball.service;

import baseball.domain.BaseBall;
import baseball.domain.Number;
import baseball.utils.Parser;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallService {

    BaseBall baseBall = new BaseBall();
    Parser parser = new Parser();
    SystemMessage systemMessage = new SystemMessage();

    public void playGame(Number number, int size) {
        int strike = 0;
        while (strike != 3) {
            play(number, size);
            systemMessage.printScoreMessage(baseBall.getBallCount(), baseBall.getStrikeCount());
            strike = baseBall.getStrikeCount();
        }
    }

    public void play(Number number, int size) {
        baseBall.initBaseBall();
        number.setUserNumbers(getUserNumber(size));
        computeScore(number, size);
    }

    private int[] getUserNumber(int size) throws IllegalArgumentException{
        RequestInput.requestInputData();
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }

    private void computeScore(Number number, int size) {
        for (int i = 0; i < size; i++) {
            compute(number.getGameNumbers(), number.getUserNumbers(), i);
        }
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        incCount(index, temp);
    }

    private void incCount(int index, int temp) {
        if (temp != index && temp != -1) {
            baseBall.incBallCount();
        }
        if (temp == index) {
            baseBall.incStrikeCount();
        }
    }
}
