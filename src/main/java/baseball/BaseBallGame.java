package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGame {
    private int answerNum;
    private int inputNum;
    private String[] answerNumStrArr;
    private String[] inputNumStrArr;
    private int ball;
    private int strike;

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
            if(!checkRangeOfGameNum(inputNum)) {
                throw new IllegalArgumentException();
            }

            inputNumStrArr = makeStringArrayFromInt(inputNum);

            initializeScore();
            calculateBall();
            System.out.println(ball + "볼");
            calculateStrike();
            System.out.println(strike + "스트라이크");
        }
    }

    private void initializeScore() {
        ball = 0;
        strike = 0;
    }

    private void makeAnswerNum() {
        int randomNum = 0;
        while (true) {
            randomNum = Randoms.pickNumberInRange(123, 987);
            System.out.println("random " + randomNum);
            if(checkRangeOfGameNum(randomNum)) {
                break;
            }
        }
        answerNum = randomNum;
    }

    private boolean checkRangeOfGameNum(int num) {
        String str = Integer.toString(num);
        if(str.length() != 3) {
            return false;
        }
        if(str.contains("0")) {
            return false;
        }

        Set set = new HashSet();
        for(int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if(set.size() != 3) {
            return false;
        }

        return true;
    }

    private void getInputNumByConsole() {
        System.out.print("숫자를 입력해주세요 : ");
        String strNum = Console.readLine();
        inputNum = Integer.parseInt(strNum);
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

    private void calculateStrike() {
        for(int i = 0; i < answerNumStrArr.length; i++) {
            if(answerNumStrArr[i].equals(inputNumStrArr[i])) {
                strike++;
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