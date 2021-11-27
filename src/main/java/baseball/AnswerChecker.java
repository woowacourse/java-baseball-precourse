package baseball;

import java.util.ArrayList;
import java.util.Iterator;

public class AnswerChecker {
    private int strikeCount;
    private int ballCount;
    private static boolean[] visit;
    private static ArrayList<Integer> computer;

    public AnswerChecker(ArrayList<Integer> computer) {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.visit = new boolean[10];
        this.computer = new ArrayList<>(computer);
    }

    public void calculateBallOrStrike(ArrayList<Integer> user) {
        for (int i = 0; i < computer.size(); i++) {
            checkStrike(computer.get(i), user.get(i));
        }
    }

    public void checkStrike(Integer computerNumber, Integer userNumber) {
        if (computerNumber == userNumber) {
            strikeCount++;
        } else {
            checkBall(userNumber);
        }
    }

    public void checkBall(Integer userNumber) {
        if (visit[userNumber.intValue()]) {
            ballCount++;
        }
    }

    public void setVisit() {
        Iterator<Integer> iterator = computer.iterator();
        while (iterator.hasNext()) {
            visit[iterator.next()] = true;
        }
    }

    public void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
