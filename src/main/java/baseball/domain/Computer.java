package baseball.domain;

import java.util.List;

public class Computer {
    private static final RandomNumbers randomNumbers = new RandomNumbers();
    private final List<Integer> randomNumberList = randomNumbers.getRandomNumbers();

    private int countsOfStrike = 0;
    private int countsOfBall = 0;

    public void calculateResult(List<Integer> threeNumbers) {
        for(int i=0;i<threeNumbers.size();i++){
            Integer numberInThreeNumbers = threeNumbers.get(i);
            if(numberInThreeNumbers.equals(randomNumberList.get(i))){
                countsOfStrike++;
            } else if(randomNumberList.stream().anyMatch(integer -> integer.equals(numberInThreeNumbers))){
                countsOfBall++;
            } else continue;
        }
    }

    public int getCountsOfBall() {
        return countsOfBall;
    }

    public int getCountsOfStrike() {
        return countsOfStrike;
    }
}
