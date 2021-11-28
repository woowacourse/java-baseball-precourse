package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

import static baseball.InitialSetting.*;

public class Player {
    public String scanNumber() {
        System.out.print(INPUT);
        String number = Console.readLine();

        if (checkNumber(number)) {
            return number;
        } else {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    private boolean checkNumber(String number) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if (number.length() != NUM_SIZE) {
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if (Character.getNumericValue(number.charAt(i)) < MIN_NUM_VALUE) {
                return false;
            }

            if (Character.getNumericValue(number.charAt(i)) > MAX_NUM_VALUE) {
                return false;
            }

            if (hashMap.containsKey(number.charAt(i))) {
                return false;
            }

            hashMap.put(number.charAt(i), 1);
        }

        return true;
    }
}
