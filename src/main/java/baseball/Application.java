package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static String getRandomNumber() {
        int firstNumber = Randoms.pickNumberInRange(1, 9);
//        System.out.println(firstNumber);
//        System.out.println();
        int secondNumber;
        int thirdNumber;

        do {
            secondNumber = Randoms.pickNumberInRange(1, 9);
//            System.out.println(secondNumber);
//            System.out.println();
        } while (secondNumber == firstNumber);

        do {
            thirdNumber = Randoms.pickNumberInRange(1, 9);
//            System.out.println(thirdNumber);
//            System.out.println();
        } while (thirdNumber == firstNumber || thirdNumber == secondNumber);

//        System.out.println(firstNumber);
//        System.out.println(secondNumber);
//        System.out.println(thirdNumber);

        String randomNumber = Integer.toString(firstNumber) + Integer.toString(secondNumber) + Integer.toString(thirdNumber);
//        System.out.println(randomNumber);

        return randomNumber;
    }

    public static void main(String[] args) {
        String randomNumber = getRandomNumber();
        System.out.println(randomNumber);
    }
}
