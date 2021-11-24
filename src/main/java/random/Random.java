package random;

import camp.nextstep.edu.missionutils.Randoms;


public class Random {

    public static String createAnswer() {

        int firstNumber = Randoms.pickNumberInRange(1, 9);
        int secondNumber;
        int thirdNumber;

        do {
            secondNumber = Randoms.pickNumberInRange(1, 9);
        }while (secondNumber == firstNumber);

        do {
            thirdNumber = Randoms.pickNumberInRange(1, 9);
        }while (thirdNumber == secondNumber || thirdNumber == firstNumber);

        return firstNumber + "" + secondNumber + thirdNumber;
    }

}
