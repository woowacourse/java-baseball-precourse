import java.util.*;

public class Numbers {
    private static Random random = new Random();
    private static final int SIZE_OF_NUMBERS = 3;
    private static final int MAX_NUMBER = 9;

    private HashMap<Integer, Integer> numbers = new HashMap<>();

    public Numbers() {
        while (numbers.size() < SIZE_OF_NUMBERS) {
            int index = numbers.size() + 1;
            numbers.put(makeRandomNumber(), index);
        }
    }

    public Numbers(int firstValue, int secondValue, int thirdValue) {
        numbers.put(firstValue, 1);
        numbers.put(secondValue, 2);
        numbers.put(thirdValue, 3);
    }

    private int makeRandomNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }

    public boolean hasNumber(int number) {
        return numbers.containsKey(number);
    }

    public boolean hasDuplicatedNumber() {
        return numbers.size() != SIZE_OF_NUMBERS;
    }

    public void compareWith(Numbers numbersFromUser) {

    }
}