import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Host {

    public static final int COUNT_SHOULD_BE_MATCHED = 3;
    private static final int MAX_NUMBER_BOUNDARY = 10;
    private static final int DEFAULT_NUMBER_FOR_COUNTING = 0;

    private List<Integer> numbers;
    private Random randomNumberGenerator;

    Host() {
        this.numbers = new ArrayList<>();
        randomNumberGenerator = new Random();
    }

    public void generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() != COUNT_SHOULD_BE_MATCHED) {
            Integer number = randomNumberGenerator.nextInt(MAX_NUMBER_BOUNDARY);

            if (number != 0 && !randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }

        this.numbers = randomNumbers;
    }

    public String makeResultStatement(List<Integer> inputNumbers) {
        int numOfStrikes = countNumOfStrikes(inputNumbers);
        int numOfBalls = countNumOfBalls(inputNumbers);
        StringBuilder result = new StringBuilder();

        if (numOfStrikes == DEFAULT_NUMBER_FOR_COUNTING && numOfBalls == DEFAULT_NUMBER_FOR_COUNTING) {
            result.append("낫싱");
        }
        if (numOfStrikes > DEFAULT_NUMBER_FOR_COUNTING) {
            result.append(numOfStrikes).append("스트라이크 ");
        }
        if (numOfBalls > DEFAULT_NUMBER_FOR_COUNTING) {
            result.append(numOfBalls).append("볼");
        }
        return result.toString();
    }

    public int countNumOfStrikes(List<Integer> inputNumbers) {
        int numOfStrikes = DEFAULT_NUMBER_FOR_COUNTING;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(inputNumbers.get(i))) {
                numOfStrikes++;
            }
        }
        return numOfStrikes;
    }

    public int countNumOfBalls(List<Integer> inputNumbers) {
        int numOfMatch = DEFAULT_NUMBER_FOR_COUNTING;

        for (int i = 0; i < numbers.size(); i++) {
            if (findAnyMatch(inputNumbers, numbers.get(i))) {
                numOfMatch++;
            }
        }
        return numOfMatch - countNumOfStrikes(inputNumbers);
    }

    private boolean findAnyMatch(List<Integer> inputNumbers, Integer number) {
        for (int i = 0; i < inputNumbers.size(); i++) {
            if (inputNumbers.get(i).equals(number)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchAllNumbers(List<Integer> inputNumbers) {
        return countNumOfStrikes(inputNumbers) == COUNT_SHOULD_BE_MATCHED;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
