import java.util.*;

public class Numbers {
    private static Random random = new Random();
    private static final int SIZE_OF_NUMBERS = 3;
    private static final int MAX_NUMBER = 9;

    private Map<Integer, Integer> numbersMap = new HashMap<>();

    public Numbers() {
        while (numbersMap.size() < SIZE_OF_NUMBERS) {
            int index = numbersMap.size() + 1;
            numbersMap.put(makeRandomNumber(), index);
        }
    }

    public Numbers(int firstValue, int secondValue, int thirdValue) {
        numbersMap.put(firstValue, 1);
        numbersMap.put(secondValue, 2);
        numbersMap.put(thirdValue, 3);
    }

    private int makeRandomNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }

    public boolean hasNumber(int number) {
        return numbersMap.containsKey(number);
    }

    public boolean hasDuplicatedNumber() {
        return numbersMap.size() != SIZE_OF_NUMBERS;
    }

    public void compareWith(Numbers numbersToCompare) {
        int strike = 0;
        int ball = 0;
        Set<Integer> valuesToCompare = numbersToCompare.numbersMap.keySet();
        for(int valueToCompare : valuesToCompare) {

        }
    }

    private int countStrike(Numbers numbers) {
        Set<Integer> valuesOfNumbers = numbersMap.keySet();
        for (int value1 : valuesOfNumbers) {
            Set<Integer> valuesOfNumbers = numbers.numbersMap.keySet();
            for (int value : valuesOfNumbers) {
        }




        }
    }
}