package baseball.domain;

import baseball.exception.BaseballException;
import baseball.resource.GameMessage;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import baseball.resource.GameRule;

public class Referee {
    List<Integer> targetNumbers;
    boolean[] booleanBits;

    public void pickRandomNumbers() {
        targetNumbers = new ArrayList<>();
        booleanBits = new boolean[10];

        while (targetNumbers.size() < GameRule.NUMBERS_DIGITS) {
            int number = Randoms.pickNumberInRange(GameRule.NUMBERS_START_INCLUSION, GameRule.NUMBERS_END_INCLUSION);
            if (booleanBits[number]) {
                continue;
            }
            targetNumbers.add(number);
            booleanBits[number] = true;
        }
    }

    public Hint evaluateNumbers(List<Integer> playerNumbers) {
        Hint hint = new Hint();

        validateRefereeNumbersPicked();

        for (int i = 0; i < targetNumbers.size(); i++) {
            int targetNumber = targetNumbers.get(i);
            int playerNumber = playerNumbers.get(i);

            if (playerNumber == targetNumber) {
                hint.increaseStrike();
            } else if (booleanBits[playerNumber]) {
                hint.increaseBall();
            }
        }
        return hint;
    }

    private void validateRefereeNumbersPicked() {
        if (targetNumbers == null) {
            throw new BaseballException(GameMessage.NOT_PICKED_REFEREE_NUMBERS);
        }
    }


    // TODO: 추후 삭제 필요 (테스트코드를 위한 Getter 메소드)
    public List<Integer> getTargetNumbers() {
        return this.targetNumbers;
    }

    public void setTargetNumbers(List<Integer> numbers) {
        this.targetNumbers = numbers;
    }

    public void setBooleanBits(boolean[] booleanBits) {
        this.booleanBits = booleanBits;
    }
}
