package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class NumberGenerator {

    private static final int NUMBER_LENGTH = 3;

    public String generateNumber() {
        Set<Integer> numberSet = generateNumberSet();
        return convertSetToString(numberSet);
    }

    private Set<Integer> generateNumberSet() {
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();

        while (randomNumberSet.size() < NUMBER_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet.add(pickedNumber);
        }

        return randomNumberSet;
    }

    private String convertSetToString(Set<Integer> numberSet) {
        StringBuilder stringNumber = new StringBuilder();
        for (Integer number : numberSet) {
            stringNumber.append(number);
        }

        return stringNumber.toString();
    }
}
