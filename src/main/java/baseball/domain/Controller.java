package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Controller {
    private String randomNumber;
    private String userNumber;
    private ArrayList<Character> ballNumbers;

    private String createRandomNumber() {
        return String.valueOf(Randoms.pickNumberInRange(100, 1000));
    }

    private String getUserNumber() {
        return Console.readLine();
    }

    private void setBallNumbers() {
        for (char number : randomNumber.toCharArray()) {
            ballNumbers.add(number);
        }
    }

    public void initGame() {
        randomNumber = createRandomNumber();
        userNumber = getUserNumber();
        setBallNumbers();
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
    }

}
