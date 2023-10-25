package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
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



    public static List<Integer> getUserNumber() {
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        if(!isValidInput(userInput)) {
            throw new IllegalArgumentException();
        }

        return stringToList(userInput);
    }

    private static List<Integer> stringToList(String str) {
        return Arrays.stream(str.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }


    private static boolean isValidInput(String userInput) {
        if(!hasNoDuplicateDigits(userInput) || !isNumeric(userInput) || !isThreeDigits(userInput)) {
            return false;
        }
        return true;
    }

    private static boolean hasNoDuplicateDigits(String input) {
        Set<Character> set = new HashSet<>();
        for(char num : input.toCharArray()) {
            set.add(num);
        }
        return set.size() == input.length();
    }


    private static boolean isNumeric(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }
    private static boolean isThreeDigits(String input) {
        if(input.length() != 3) {
            return false;
        }
        return true;
    }
}
