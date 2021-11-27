package baseball.domain;

import baseball.resource.GameRule;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    List<Integer> targetNumbers;
    boolean[] booleanBits;

    public void pickRandomNumbers() {
        targetNumbers = new ArrayList<>();
        booleanBits = new boolean[10];

        int number;
        while (targetNumbers.size() < GameRule.NUMBERS_DIGITS) {
            number = Randoms.pickNumberInRange(GameRule.NUMBERS_START_INCLUSION, GameRule.NUMBERS_END_INCLUSION);
            if (booleanBits[number]) {
                continue;
            }
            targetNumbers.add(number);
            booleanBits[number] = true;
        }
    }

    public Hint calculateHint(List<Integer> playerNumbers) {
        Hint hint = new Hint();
        int targetNumber;
        int playerNumber;

        for (int i = 0; i < targetNumbers.size(); i++) {
            targetNumber = targetNumbers.get(i);
            playerNumber = playerNumbers.get(i);

            if (playerNumber == targetNumber) {
                hint.increaseStrike();
            } else if (booleanBits[playerNumber]) {
                hint.increaseBall();
            }
        }
        return hint;
    }


    // TODO: 추후 삭제 필요 (테스트코드를 위한 Getter 메소드)
    public List<Integer> getTargetNumbers() {
        return this.targetNumbers;
    }
}
