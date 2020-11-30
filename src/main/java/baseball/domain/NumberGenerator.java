package baseball.domain;

import utils.RandomUtils;

public class NumberGenerator {
    RandomUtils randomUtils;
    private static int NumberMin = 1;
    private static int NumberMax = 9;

    public Number execute(){
        Number randomNumber = new Number(new int[Number.NUM_LENGTH]);
        int index = 0;

        while (index < Number.NUM_LENGTH) {
            int number = randomUtils.nextInt(NumberMin, NumberMax);
            if (randomNumber.contains(number)) {
                continue;
            }
            randomNumber.insert(index, number);
            index++;
        }
        return randomNumber;
    }
}
