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
            if(!checkRangeOfInputNum()) {
                System.out.println("입력값이 잘못되었습니다.");
                break;
            }
        }
    }

    private void makeAnswerNum() {
        answerNum = Randoms.pickNumberInRange(111, 999);
    }

    private void getInputNumByConsole() {
        System.out.print("숫자를 입력해주세요 : ");
        String strNum = Console.readLine();
        try {
            inputNum = Integer.parseInt(strNum);
        } catch (IllegalArgumentException e) {
            System.out.println("입력값이 잘못되었습니다.");
        }
    }

    private boolean checkRangeOfInputNum() {
        return (111 <= inputNum && inputNum <= 999);
    }
}