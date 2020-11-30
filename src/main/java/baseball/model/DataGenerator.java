package baseball.model;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    private DataGenerator() {
    }

    public static List<Integer> generateRandomDigitList(ParameterSet parameterSet) {
        List<Integer> randomDigitList = new ArrayList<>();

        while (randomDigitList.size() < parameterSet.numberOfDigits()) {
            int aRandomDigit = RandomUtils.nextInt(parameterSet.minDigit(), parameterSet.maxDigit());

            if (!randomDigitList.contains(aRandomDigit)) {
                randomDigitList.add(aRandomDigit);
            }
        }

        return randomDigitList;
    }
}
