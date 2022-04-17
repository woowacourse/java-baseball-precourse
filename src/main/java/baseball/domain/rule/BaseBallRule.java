package baseball.domain.rule;

import java.util.List;

public class BaseBallRule {

    private int matchedNumberCount = 0;

    private int strikeCount = 0;
    private int ballCount = 0;

    public int matchedCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int index = 0; index < computerNumbers.size(); index++) {
            isContainNumber(computerNumbers, userNumbers, index);
        }
        return matchedNumberCount;
    }

    private void isContainNumber(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        if (userNumbers.contains(computerNumbers.get(index))) {
            matchedNumberCount++;
        }
    }

    public boolean equalPostion(List<Integer> computer, int placedIndex, int number) {
        return computer.get(placedIndex) == number;
    }

    public void compareBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        strikeCount = isStrike(computerNumbers, userNumbers);
        ballCount = isBall(computerNumbers, userNumbers, strikeCount);
    }

    public int isStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int index = 0; index < computerNumbers.size(); index++) {
            isEqualPosition(computerNumbers, userNumbers, index);
        }

        return strikeCount;
    }

    private void isEqualPosition(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        if (equalPostion(computerNumbers, index, userNumbers.get(index))) {
            strikeCount++;
        }
    }

    public int isBall(List<Integer> computerNumbers, List<Integer> userNumbers, int strikeCount) {
        int correctedCount = matchedCount(computerNumbers, userNumbers);
        return correctedCount - strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
