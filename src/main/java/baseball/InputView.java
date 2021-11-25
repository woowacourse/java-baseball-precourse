package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static String trimInput() {
        return Console.readLine().trim();
    }

    public static List<Integer> StringChangeList() {
        String[] split = trimInput().split("");
        if (split.length != Constant.MAX_SIZE) {
            throw new IllegalArgumentException(Constant.INVALID_NUMBER_COUNT_MESSAGE);
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            numbers.add(Integer.parseInt(split[i]));
        }
        Set<Integer> validateNumberCheck = new HashSet<>(numbers);
        if(validateNumberCheck.size() != Constant.MAX_SIZE)
            throw new IllegalArgumentException(Constant.DUPLICATE_NUMBER_ERROR_MESSAGE);
        return numbers;
    }
}
