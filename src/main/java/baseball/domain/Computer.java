package baseball.domain;

import java.util.List;

public class Computer {
    private static final RandomNumbers randomNumbers = new RandomNumbers();

    private int countsOfStrike = 0;
    private int countsOfBall = 0;

    public void calculateResult(List<Integer> threeNumbers, List<Integer> randomNumberList) {
        //System.out.print(randomNumberList);
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
