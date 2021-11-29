package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    private static final int NUMBER_SIZE = 3;
    private static final String END_SIGN = "2";
    private static final String REPLAY_SIGN = "1";
    private static final char ASCII_ZERO = '0';
    private ArrayList<Integer> randomNumber;
    private ArrayList<Integer> userNumber;
    private boolean endFlag = false;
    private boolean numberSameFlag;

    public Controller() {
    }

    public void run() {
        while (!isEnd()) {
            initGame();
            while (!isSameNumber()) {
                getUserNumber();
                compareNumbers();
            }
        }
    }

    private void createRandomNumber() {
        while (randomNumber.size() != NUMBER_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
    }

    public void getUserNumber() {
        Viewer.inputNumber();
        String userInput = Console.readLine();
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요!");
        }
        for (char num : userInput.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자를 입력해주세요!");
            } else if (userNumber.contains(num - ASCII_ZERO)) {
                throw new IllegalArgumentException("중복되지 않게 숫자를 입력해주세요!");
            }
            userNumber.add(num - ASCII_ZERO);
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

    public void initGame() {
        randomNumber = new ArrayList<>();
        createRandomNumber();
        userNumber = new ArrayList<>();
        System.out.println(randomNumber);
        numberSameFlag = false;
    }

    public void compareNumbers() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int randomNum = randomNumber.get(i);
            int userNum = userNumber.get(i);
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
