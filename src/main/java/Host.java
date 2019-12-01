import java.util.ArrayList;
import java.util.List;

public class Host {

    public static final int baseballGameSize = 3;

    private List<Integer> numbers;

    Host() {
        this.numbers = new ArrayList<Integer>();
    }

    public void generateNumbers() {
        while (numbers.size() != baseballGameSize) {
            Integer number = (int) (Math.random() * 10);

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
        int numOfStrikes = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if ( numbers.get(i).equals(inputNumbers.get(i)) ) {
                numOfStrikes++;
            }
        }
        return numOfStrikes;
    }

    public int countNumOfBalls(List<Integer> inputNumbers) {
        int numOfBalls = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if ( findAnyMatch(inputNumbers, numbers.get(i)) ) {
                numOfBalls++;
            }
        }
        return numOfBalls - countNumOfStrikes(inputNumbers);
    }

    private boolean findAnyMatch(List<Integer> inputNumbers, Integer number) {
        for (int i = 0; i < inputNumbers.size(); i++) {
            if (inputNumbers.get(i).equals(number)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
