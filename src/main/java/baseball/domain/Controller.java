package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    private static final int NUMBER_SIZE = 3;
    private static final String END_SIGN = "2";
    private static final String REPLAY_SIGN = "1";
    private RandomNumber randomNumber;
    private UserNumber userNumber;
    private boolean endFlag = false;
    private boolean numberSameFlag;

    public Controller() {
        randomNumber = new RandomNumber();
        userNumber = new UserNumber();
    }

    public void run() {
        while (!isEnd()) {
            randomNumber.init();
//            randomNumber.showRandomNumber();
            numberSameFlag = false;
            while (!isSameNumber()) {
                userNumber.init();
                compareNumbers();
            }
        }
    }


    private void getEndByUser(){
        String userInput = Console.readLine();
        if (userInput.equals(END_SIGN)) {
            endFlag = true;
        } else if (!userInput.equals(REPLAY_SIGN)) {
            throw new IllegalArgumentException("재시작은 1, 종료는 2를 입력해주세요!");
        }
    }

    public void compareNumbers() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int randomNum = randomNumber.getByIndex(i);
            int userNum = userNumber.getByIndex(i);
            if (randomNum == userNum) {
                strike++;
            } else if (randomNumber.contains(userNum)) {
                ball++;
            }
        }
        Viewer.printStrikeBall(strike, ball);
        if (checkAnswer(strike)) {
            Viewer.printEndMessage();
            numberSameFlag = true;
            getEndByUser();
        }
    }

    private boolean checkAnswer(int strike){
        return strike == NUMBER_SIZE;
    }

    public boolean isEnd() {
        return endFlag;
    }

    public boolean isSameNumber() {
        return numberSameFlag;
    }
}
