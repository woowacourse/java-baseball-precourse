package baseball.domain;

import java.util.List;

public class Computer {
    private int countsOfStrike = 0;
    private int countsOfBall = 0;

    public void calculateResult(List<Integer> inputNumbersList, List<Integer> randomNumberList) {
        for (int i = 0; i < inputNumbersList.size(); i++) {
            Integer numberInInputNumbers = inputNumbersList.get(i);
            if (numberInInputNumbers.equals(randomNumberList.get(i))) {
                countsOfStrike++;
            } else if (randomNumberList.stream().anyMatch(integer -> integer.equals(numberInInputNumbers))) {
                countsOfBall++;
            }
        }
    }

    public int getCountsOfBall() {
        return countsOfBall;
    }

    public int getCountsOfStrike() {
        return countsOfStrike;
    }
}
