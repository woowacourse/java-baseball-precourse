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
        while (numbers.size() != COUNT_SHOULD_BE_MATCHED) {
            Integer number = randomNumberGenerator.nextInt(MAX_NUMBER_BOUNDARY);

            if (number != 0 && !numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public String makeResultStatement(List<Integer> inputNumbers) {
        int numOfStrikes = countNumOfStrikes(inputNumbers);
        int numOfBalls = countNumOfBalls(inputNumbers);

        if (numOfStrikes == 0 && numOfBalls == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (numOfStrikes != 0) {
            result.append(numOfStrikes).append("스트라이크 ");
        }
        if (numOfBalls != 0) {
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
