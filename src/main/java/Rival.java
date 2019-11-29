import java.util.HashSet;

public class Rival {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;
    private int holdCount;
    private HashSet<Integer> numbers;
    private RandomNumberGenerator generator;

    public Rival(int holdCount) {
        this.holdCount = holdCount;
        this.numbers = new HashSet<>(holdCount);
        this.generator = new RandomNumberGenerator(RANGE_MIN, RANGE_MAX);
        resetNumbers();
    }

    public Integer[] getNumbers() {
        return numbers.toArray(new Integer[0]);
    }

    public void resetNumbers() {
        numbers.clear();

        while (numbers.size() < holdCount) {
            int randomNumber = generator.execute();
            numbers.add(randomNumber);
        }
    }
}