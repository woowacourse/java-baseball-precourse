package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public static String getRandomNumber() {
        int firstNumber = Randoms.pickNumberInRange(1, 9);
        int secondNumber;
        int thirdNumber;

        do {
            secondNumber = Randoms.pickNumberInRange(1, 9);
        } while (secondNumber == firstNumber);

        do {
            thirdNumber = Randoms.pickNumberInRange(1, 9);
        } while (thirdNumber == firstNumber || thirdNumber == secondNumber);

        String randomNumber = Integer.toString(firstNumber) + Integer.toString(secondNumber) + Integer.toString(thirdNumber);

        return randomNumber;
    }
}
