package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

import static baseball.Message.ERR_MSG;
import static baseball.Message.INPUT;

public class Player {

    public String scanNumber() {
        System.out.print(INPUT);
        String number = Console.readLine();

        if(checkNumber(number)) {
            return number;
        } else {
            System.out.println(ERR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumber(String number) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if(number.length() != 3) {
            return false;
        }

        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) < '0' || number.charAt(i) > '9') {
                return false;
            }

            if(hashMap.containsKey(number.charAt(i))) {
                return false;
            }

            hashMap.put(number.charAt(i), 1);
        }

        return true;
    }
}
