package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    public static String getInputNumber() {
        String input = Console.readLine();
        if (input.length() != 3) {
//            System.out.println("input error");
            throw new IllegalArgumentException();
        }
        if (input.contains("0")) {
//            System.out.println("contains zero");
            throw new IllegalArgumentException();
        }

        List<String> inputNumber = new ArrayList<String>(Arrays.asList(input.split("")));
//        System.out.println(inputNumber);
//        System.out.println(inputNumber.getClass());
//        System.out.println(inputNumber.size());

        HashSet<String> checkDuplicate = new HashSet<String>(inputNumber);
//        System.out.println(checkDuplicate);
//        System.out.println(checkDuplicate.getClass());
//        System.out.println(checkDuplicate.size());

        if (checkDuplicate.size() != inputNumber.size()) {
//            System.out.println("duplicate detected");
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static int[] compareValues(String randomNumber, String inputNumber) {
        char[] randomNumberArray = randomNumber.toCharArray();
        char[] inputNumberArray = inputNumber.toCharArray();

        int find = 0;
        int index = 0;
        int strike = 0;
        int ball = 0;

        for (int k = 0; k < 3; k++) {
            if (inputNumberArray[k] == randomNumberArray[0]) {
                index = 0;
                find = 1;
            }
            if (inputNumberArray[k] == randomNumberArray[1]) {
                index = 1;
                find = 1;
            }
            if (inputNumberArray[k] == randomNumberArray[2]) {
                index = 2;
                find = 1;
            }

            if (find == 1 && index == k) {
//                System.out.println("strike");
                strike += 1;
                find = 0;
            } else if (find == 1) {
//                System.out.println("ball");
                ball += 1;
                find = 0;
            }
        }
        if (strike + ball == 0) {
            System.out.println("out!");
        } else if (strike == 0) {
            System.out.println(ball + " Ball");
        } else if (ball == 0) {
            System.out.println(strike + " Strike");
        } else {
            System.out.println(strike + " Strike" + " " + ball + " Ball");
        }

        int[] result = {strike, ball};

        return result;
    }

    public static void main(String[] args) {
        String randomNumber = getRandomNumber();
        System.out.println(randomNumber);
        String inputNumber = getInputNumber();
        System.out.println(inputNumber);
    }
}
