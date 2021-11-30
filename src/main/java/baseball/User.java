package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class User {
    public static String getInputNumber() {
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0이 포함되지 않은 숫자를 입력해주세요.");
        }

        List<String> inputNumber = new ArrayList<String>(Arrays.asList(input.split("")));

        HashSet<String> checkDuplicate = new HashSet<String>(inputNumber);

        if (checkDuplicate.size() != inputNumber.size()) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }

        return input;
    }
    public static String pleaseInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = baseball.User.getInputNumber();

        return inputNumber;
    }
}
