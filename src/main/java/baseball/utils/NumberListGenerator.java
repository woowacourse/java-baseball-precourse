package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberListGenerator {

    public static List<Integer> generateNonDuplicateNumbers(
        final int size,
        final int lowInclusive,
        final int highInclusive) {
        List<Integer> pickedList = new ArrayList<>();

        while (pickedList.size() < size) {
            int number = pickUniqueNumber(pickedList, lowInclusive, highInclusive);
            pickedList.add(number);
        }
        return pickedList;
    }

    private static int pickUniqueNumber(
        List<Integer> pickedList,
        int lowInclusive,
        int highInclusive) {
        int number;

        number = Randoms.pickNumberInRange(lowInclusive, highInclusive);
        if (pickedList.contains(number)) {
            return pickUniqueNumber(pickedList, lowInclusive, highInclusive);
        }
        return number;
    }
}
