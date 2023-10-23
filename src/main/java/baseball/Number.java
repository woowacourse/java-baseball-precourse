package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static String userNumber;
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

    public static void getUserNumber() {
        userNumber = Console.readLine();
    }

    public static void isValidLength(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }

    public static void printNumber() {
        getRandomNumber();
        getUserNumber();
        isValidLength(userNumber);
        System.out.println(randomNumber);
        System.out.println(userNumber);
    }
}
