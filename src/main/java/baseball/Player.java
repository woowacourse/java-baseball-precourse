package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Player {

    private static final String INPUT = "숫자를 입력해주세요: ";
    private static final String ERR_MSG = "올바르지 않은 형식의 숫자를 입력하셨습니다. (1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력하세요.)";

    public String scanNumber() {
        System.out.print(INPUT);
        String number = Console.readLine();

        if(checkNumber(number)) {
            return number;
        } else {
            throw new IllegalArgumentException(ERR_MSG);
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
