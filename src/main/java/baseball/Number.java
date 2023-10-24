package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static constants.BaseballMessage.USER_INPUT_MESSAGE;


public class Number {


    public static List<Integer> setComputerRandomNumbers() {
        Set<Integer> NumberSet = new HashSet<>();
        while (NumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            NumberSet.add(randomNumber);
        }
        return new ArrayList<>(NumberSet);
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


    private static boolean isNumeric(String str) {
        return str.matches("^[0-9]+$");
    }

}
