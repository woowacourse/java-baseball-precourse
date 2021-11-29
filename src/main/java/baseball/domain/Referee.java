package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.resource.rule.NumberDigit;
import baseball.resource.rule.NumberRange;
import camp.nextstep.edu.missionutils.Randoms;

import baseball.exception.NotPickedRefereeNumbers;

public class Referee {

    private static final int CHECK_BITS_LENGTH = 10;

    List<Integer> targetNumbers;
    boolean[] duplicationCheckBits;

    public void pickRandomNumbers() {
        targetNumbers = new ArrayList<>();
        duplicationCheckBits = new boolean[CHECK_BITS_LENGTH];

        while (isCountLessThen(NumberDigit.getCount())) {
            int number = Randoms.pickNumberInRange(NumberRange.START.getNumber(), NumberRange.END.getNumber());
            if (checkDuplicated(number)) {
                continue;
            }
            targetNumbers.add(number);
            duplicationCheckBits[number] = true;
        }
    }

    public Hint evaluateNumbers(List<Integer> playerNumbers) {
        Hint hint = new Hint();

        validateRefereeNumbersPicked();

        for (int i = 0; i < targetNumbers.size(); i++) {
            int targetNumber = targetNumbers.get(i);
            int playerNumber = playerNumbers.get(i);

            if (checkStrike(playerNumber, targetNumber)) {
                hint.increaseStrike();
            } else if (checkBall(playerNumber)) {
                hint.increaseBall();
            }
        }
        return hint;
    }

    private boolean isCountLessThen(int count) {
        return (targetNumbers.size() < count);
    }

    private boolean checkDuplicated(int number) {
        return duplicationCheckBits[number];
    }

    private boolean checkStrike(int playerNumber, int targetNumber) {
        return (playerNumber == targetNumber);
    }

    private boolean checkBall(int playNumber) {
        return duplicationCheckBits[playNumber];
    }

    private void validateRefereeNumbersPicked() {
        if (targetNumbers == null) {
            throw new NotPickedRefereeNumbers();
        }
    }

}
