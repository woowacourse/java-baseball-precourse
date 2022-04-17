package baseball.domain.rule;

import java.util.List;

public class BaseBallRule {

    int matchedNumberCount = 0;

    public int correctCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
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

}
