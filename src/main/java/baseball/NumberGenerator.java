package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class NumberGenerator {

    public String generateNumber(int numberLength) {
        Set<Integer> numberSet = generateNumberSet(numberLength);
        return convertSetToString(numberSet);
    }

    private Set<Integer> generateNumberSet(int numberLength) {
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();

        while (randomNumberSet.size() < numberLength) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet.add(pickedNumber);
        }

        return randomNumberSet;
    }

    private String convertSetToString(Set<Integer> targetNumberSet) {
        StringBuilder builder = new StringBuilder();
        for (Integer number : targetNumberSet) {
            builder.append(number);
        }

        return builder.toString();
    }
}
