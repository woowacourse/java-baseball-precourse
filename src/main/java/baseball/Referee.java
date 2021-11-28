package baseball;

import java.util.ArrayList;

public class Referee {
    private BallCount ballCount;

    public boolean canFinish() {
        return ballCount.isStrikeOut();
    }

    public void calculateBallCount(int randomNumber, int predict) {
        ballCount = new BallCount();
        calculate(makeNumberToList(randomNumber), makeNumberToList(predict));
        ballCount.printCurrentBallCount();
    }

    private void calculate(ArrayList<Integer> randomNumber, ArrayList<Integer> predict) {
        for (int i = 0; i < predict.size(); ++i) {
            if (randomNumber.get(i) == predict.get(i)) {
                ballCount.plusStrike();
                continue;
            }
            if (randomNumber.contains(predict.get(i))) {
                ballCount.plusBall();
            }
        }
    }

    private ArrayList<Integer> makeNumberToList(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(0, number % 10);
            number /= 10;
        }
        return list;
    }

}
