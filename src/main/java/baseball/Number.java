package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constants.BaseballMessage.USER_INPUT_MESSAGE;


public class Number {
    private static List<Integer> randomNumber = new ArrayList<>();
    private static Integer continueOrNot;
    private static Integer strike;
    private static Integer ball;
    private static Integer num;

    private static void getRandomNumber() {
        while (randomNumber.size() < 3) {
            num = Randoms.pickNumberInRange(1, 9);
            numberDuplication(num);
        }
    }

    public static void numberDuplication(Integer num) {
        if (!randomNumber.contains(num)) {
            randomNumber.add(num);
        }
    }

    private static List<Integer> userNumber = new ArrayList<>();

    public static void getUserNumber() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        isThreeNumbers(userInput);
        userInputToUserNumber(userInput);
        System.out.println(userNumber);
    }
    private static void userInputToUserNumber(String userInput) {
        for (int i = 0; i < 3; i++) {
            userNumber.add(Character.getNumericValue(userInput.charAt(i)));
        }
    }

    private static boolean isThreeNumbers(String numbers) {
        if (numbers.length() != 3) {
            return false;
        }
        return true;
    }


    public static void start() {
        getRandomNumber();
        getUserNumber();
        System.out.println(randomNumber);
    }
}
