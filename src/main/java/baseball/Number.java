package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public static List<Integer> getUserNumber() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        if(!isValidInput(userInput)) {
            throw new IllegalArgumentException();
        }
        userInputToUserNumber(userInput);
        System.out.println(userNumber);

        return stringToList(userInput);
    }

    private static List<Integer> stringToList(String str) {
        return Arrays.stream(str.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void userInputToUserNumber(String userInput) {
        for (int i = 0; i < 3; i++) {
            userNumber.add(Character.getNumericValue(userInput.charAt(i)));
        }
    }
    private static boolean isValidInput(String userInput) {
        return userInput.length() == 3 && hasNoDuplicateDigits(userInput) && isNumeric(userInput);
    }

    private static boolean hasNoDuplicateDigits(String input) {
        Set<Character> digitSet = new TreeSet<>();
        for (char c : input.toCharArray()) {
            digitSet.add(c);
        }
        return digitSet.size() == 3;
    }

    private static boolean isThreeNumbers(String numbers) {
        if (numbers.length() != 3) {
            return false;
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        return str.matches("^[0-9]+$");
    }

    private static boolean isDuplicate(String userInput){
        Set<Character> set = new HashSet<>();
        for(char num : userInput.toCharArray()) {
            set.add(num);
        }
        return set.size() == userInput.length();
    }

    public static void start() {
        getRandomNumber();
        getUserNumber();
        System.out.println(randomNumber);
    }
}
