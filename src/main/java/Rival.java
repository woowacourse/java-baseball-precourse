import java.util.HashSet;

public class Rival {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;
    private static final int HOLD_COUNT = 3;
    private HashSet<Integer> numbers;
    private RandomNumberGenerator generator;

    public Rival() {
        this.numbers = new HashSet<>(HOLD_COUNT);
        this.generator = new RandomNumberGenerator(RANGE_MIN, RANGE_MAX);
        resetNumbers();
    }

    public Integer[] getNumbers() {
        return numbers.toArray(new Integer[0]);
    }

    public void resetNumbers() {
        numbers.clear();

        while (numbers.size() < HOLD_COUNT) {
            int randomNumber = generator.execute();
            numbers.add(randomNumber);
        }
    }
}