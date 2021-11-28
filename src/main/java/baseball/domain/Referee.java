package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.resource.rule.NumberDigit;
import baseball.resource.rule.NumberRange;
import camp.nextstep.edu.missionutils.Randoms;

import baseball.exception.NotPickedRefereeNumbers;

public class Referee {

    List<Integer> targetNumbers;
    boolean[] booleanBits;

    public void pickRandomNumbers() {
        targetNumbers = new ArrayList<>();
        booleanBits = new boolean[10];

        while (targetNumbers.size() < NumberDigit.COUNT.getCount()) {
            int number = Randoms.pickNumberInRange(NumberRange.START.getNumber(), NumberRange.END.getNumber());
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
            throw new NotPickedRefereeNumbers();
        }
    }

}
