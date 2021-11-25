package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private int answerNum;
    private int inputNum;

    public BaseBallGame() {
        answerNum = 0;
        inputNum = 0;
    }

    public void start() {
        while (true) {
            makeAnswerNum();
            getInputNumByConsole();
            System.out.println(answerNum);
            if(!checkRangeOfInputNum()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void makeAnswerNum() {
        answerNum = Randoms.pickNumberInRange(111, 999);
    }

    private void getInputNumByConsole() {
        System.out.print("숫자를 입력해주세요 : ");
        String strNum = Console.readLine();
        inputNum = Integer.parseInt(strNum);
    }

    private boolean checkRangeOfInputNum() {
        return (111 <= inputNum && inputNum <= 999);
    }
}