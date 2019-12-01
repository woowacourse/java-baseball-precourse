package mypackage.minuyim.baseball;

import mypackage.minuyim.baseball.util.*;

public class MainGame {
    private static final int TARGET_NUMBER = 3;
    private static final int ENDGAME_NUMBER = 2;

    private void oneGame(int[] answerNumbers) {
        int userNumber;
        int[] userNumbers;

        while (true) {
            userNumber = NumberInput.inputNumber();
            userNumbers = ArrayConverter.convertToArray(userNumber);

            HintMaker hint = new HintMaker(answerNumbers, userNumbers);
            HintPrinter.printHint(hint.strike, hint.ball);

            if (hint.strike == TARGET_NUMBER) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        return;
    }

    public void start() {
        int[] answerNumbers;

        while (true) {
            answerNumbers = RandomNumberMaker.makeRandom();
            oneGame(answerNumbers);
            if (Repeater.askAgain() == ENDGAME_NUMBER) {
                break;
            }
        }

        return;
    }
}