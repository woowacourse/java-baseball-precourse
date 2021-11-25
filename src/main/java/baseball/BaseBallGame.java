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
            if(isFinishedGame()) {
                break;
            }
        }
    }

    private void play() {
        while(true) {
            getInputNumByConsole();
            if(!checkRangeOfGameNum(inputNum)) {
                throw new IllegalArgumentException();
            }
            if(isAnswer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
            inputNumStrArr = makeStringArrayFromInt(inputNum);

            initializeScore();
            calculateBall();
            calculateStrike();
            printScore();
        }
    }

    private void initializeScore() {
        ball = 0;
        strike = 0;
    }

    private void makeAnswerNum() {
        int randomNum;
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

        Set<Character> s = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            s.add(str.charAt(i));
        }
        if(s.size() != 3) {
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

    private boolean isAnswer() {
        return answerNum == inputNum;
    }

    private void printScore() {
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if(ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if(ball > 0) {
            System.out.println(ball + "볼");
            return;
        }
        if(strike > 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    private boolean isFinishedGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = Console.readLine();
        if(str.equals("2")) {
            return true;
        }
        return false;
    }
}