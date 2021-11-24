package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Game {

    private static final int NUMBER_LENGTH = 3;
    private static final String INPUT_CHECK_REGEX = "[1-9][1-9][1-9]";
    private String randomNumber;
    private String userNumber;

    public void init() {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();

        while (hashSet.size() < NUMBER_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            hashSet.add(pickedNumber);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : hashSet) {
            stringBuilder.append(number);
        }

        randomNumber = stringBuilder.toString();
    }

    private void takeInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }

        userNumber = input;
    }

    private boolean isValid(String input) {
        if (!input.matches(INPUT_CHECK_REGEX)) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            hashSet.add(input.charAt(i) - '0');
        }

        if (hashSet.size() != NUMBER_LENGTH) {
            return false;
        }

        return true;
    }
}
