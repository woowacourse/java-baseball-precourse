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

    public static void main(String[] args) {
        String randomNumber = getRandomNumber();
        System.out.println(randomNumber);
        String inputNumber = getInputNumber();
        System.out.println(inputNumber);
    }
}
