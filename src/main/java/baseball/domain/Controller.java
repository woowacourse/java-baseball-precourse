package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    private String randomNumber;
    private String userNumber;
    private ArrayList<Character> ballNumbers;
    private boolean endFlag = false;
    private boolean numberSameFlag;

    public Controller() {
    }

    private String createRandomNumber() {
        ArrayList<Integer> randomNum = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (randomNum.size() != 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(num)) {
                randomNum.add(num);
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public void getUserNumber() {
        Viewer.inputNumber();
        userNumber = Console.readLine();

        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요!");
        }
        for (char num : userNumber.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자를 입력해주세요!");
            }
        }
    }

    private void getEndByUser(){
        String userInput = Console.readLine();
        if (userInput.equals("2")) {
            endFlag = true;
        } else if (!userInput.equals("1")) {
            throw new IllegalArgumentException("재시작은 1, 종료는 2를 입력해주세요!");
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
