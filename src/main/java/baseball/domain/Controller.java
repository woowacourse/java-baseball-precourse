package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Controller {
    private String randomNumber;
    private String userNumber;
    private ArrayList<Character> ballNumbers;
    private boolean endFlag = false;
    private boolean numberSameFlag;

    public Controller() {
    }

    private String createRandomNumber() {
        return String.valueOf(Randoms.pickNumberInRange(100, 1000));
    }

    public void getUserNumber() {
        Viewer.inputNumber();
        userNumber = Console.readLine();
    }

    private void getEndByUser(){
        String userInput = Console.readLine();
        if (userInput.equals("2")) {
            endFlag = true;
        }
    }

    private void setBallNumbers() {
        ballNumbers = new ArrayList<>();
        for (char number : randomNumber.toCharArray()) {
            ballNumbers.add(number);
        }
    }

    public void initGame() {
        randomNumber = createRandomNumber();
        System.out.println(randomNumber);
        setBallNumbers();
        numberSameFlag = false;
    }

    public void compareNumbers() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            char randomNum = randomNumber.charAt(i);
            char userNum = userNumber.charAt(i);
            if (randomNum == userNum) {
                strike++;
            } else if (ballNumbers.contains(userNum)) {
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
        return strike == 3;
    }

    public boolean isEnd() {
        return endFlag;
    }

    public boolean isSameNumber() {
        return numberSameFlag;
    }
}
