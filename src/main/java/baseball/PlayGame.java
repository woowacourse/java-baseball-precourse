package baseball;

import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private String computersNumber;

    public PlayGame() {

    }

    private void assignComputerNumber() {
        computersNumber = "";
        HashSet<String> checkOverlap = new HashSet<>();

        for (int i = 0; i < ESSENTIAL_NUMBER_LENGTH; i++) {
            String number = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));

            if (checkOverlap.contains(number)) {
                i--;
                continue;
            }

            checkOverlap.add(number);
            computersNumber += number;
        }

    }
}
