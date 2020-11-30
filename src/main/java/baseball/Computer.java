package baseball;

import java.util.HashSet;
import interfaces.IComputer;
import utils.RandomUtils;

public class Computer implements IComputer {
    private BaseballGameNumber baseballGameNumber;

    public Computer() {
        baseballGameNumber = new BaseballGameNumber();
    }

    @Override
    public void makeRandomNumber() {
        HashSet<Integer> set = new HashSet<>();
        int[] numbers = new int[BaseballGameNumber.SIZE_OF_ARRAY];

        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = RandomUtils.nextInt(BaseballGameNumber.MIN_NUMBER_RANGE,
                    BaseballGameNumber.MAX_NUMBER_RANGE);
            while (set.contains(randomNumber)) {
                randomNumber = RandomUtils.nextInt(BaseballGameNumber.MIN_NUMBER_RANGE,
                        BaseballGameNumber.MAX_NUMBER_RANGE);
            }
            numbers[i] = randomNumber;
            set.add(randomNumber);
        }

        baseballGameNumber.setNumbers(numbers);
    }

    @Override
    public BaseballGameNumber getBaseballGameNumber() {
        // TODO Auto-generated method stub
        return this.baseballGameNumber;
    }
}
