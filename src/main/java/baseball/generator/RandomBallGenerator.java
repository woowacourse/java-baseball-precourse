package baseball.generator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RandomBallGenerator extends BallGenerator {

    private final Set<Integer> duplicateNumbers;

    public RandomBallGenerator() {
        duplicateNumbers = new HashSet<>();
        Collections.shuffle(ballNumbers);
    }

    @Override
    public int getNumber(int index) {
        int number = ballNumbers.get(index);

        while (duplicateNumbers.contains(number)) {
            Collections.shuffle(ballNumbers);
            number = ballNumbers.get(index);
        }
        duplicateNumbers.add(number);

        return number;
    }
}
