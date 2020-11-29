package baseball.domain;

import utils.RandomUtils;

public class NumberGenerator {
    RandomUtils randomUtils;

    public Number execute(){
        Number randomNumber = new Number(new int[Number.NUM_LENGTH]);
        int index = 0;

        while (index < Number.NUM_LENGTH) {
            int number = randomUtils.nextInt(Number.MIN, Number.MAX);
            if (randomNumber.contains(number)) {
                continue;
            }
            randomNumber.create(index, number);
            index++;
        }
        return randomNumber;
    }
}
