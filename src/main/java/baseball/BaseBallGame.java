package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private int answerNum;
    private int inputNum;
    private String[] answerNumStrArr;
    private String[] inputNumStrArr;
    private int ball;

    public BaseBallGame() {
        answerNum = 0;
        inputNum = 0;
    }

    public void start() {
        while(true) {
            makeAnswerNum();
            System.out.println(answerNum);
            answerNumStrArr = makeStringArrayFromInt(answerNum);

            play();
        }
    }

    private void play() {
        while(true) {
            getInputNumByConsole();
            if(!checkRangeOfInputNum()) {
                throw new IllegalArgumentException();
            }

            inputNumStrArr = makeStringArrayFromInt(inputNum);

            initializeScore();
            calculateBall();
            System.out.println(ball + "볼");
        }
    }

    private void initializeScore() {
        ball = 0;
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

    private String[] makeStringArrayFromInt(int num) {
        return Integer.toString(num).split("");
    }

    private void calculateBall() {
        for(String s : inputNumStrArr) {
            if(isContainedInAnswer(s)) {
                ball++;
            }
        }
    }

    private boolean isContainedInAnswer(String s) {
        for(String answerStr : answerNumStrArr) {
            if(s.equals(answerStr)) {
                return true;
            }
        }
        return false;
    }
}