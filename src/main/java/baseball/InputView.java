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
        String[] stringSplits = trimInput().split("");
        if (stringSplits.length != Constant.BALL_LIST_SIZE) {
            throw new IllegalArgumentException(Constant.INVALID_NUMBER_COUNT_MESSAGE);
        }
        List<Integer> inputStringToNumbers = new ArrayList<>();
        for (int i = 0; i < stringSplits.length; i++) {
            inputStringToNumbers.add(Integer.parseInt(stringSplits[i]));
        }
        Set<Integer> duplicateCheckSet = new HashSet<>(inputStringToNumbers);
        if (duplicateCheckSet.size() != Constant.BALL_LIST_SIZE) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
        return inputStringToNumbers;
    }
}
