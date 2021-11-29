package baseball;

import java.util.HashMap;

import communication.Text;

public class Umpire {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private String computersNumber;
    private String usersNumber;
    private HashMap<String, Integer> hintStorage;

    public Umpire(String computersNumber) {
        this.computersNumber = computersNumber;
        this.hintStorage = new HashMap<>();
    }

    private boolean isNothing() {

        for (int i = 0; i < ESSENTIAL_NUMBER_LENGTH; i++) {
            String compareNumber = String.valueOf(usersNumber.charAt(i));

            if (computersNumber.contains(compareNumber)) {
                return false;
            }

        }

        return true;
    }

    private void countStrike() {
        int strikeCount = 0;

        for (int i = 0; i < ESSENTIAL_NUMBER_LENGTH; i++) {

            if (computersNumber.charAt(i) == usersNumber.charAt(i)) {
                strikeCount++;
            }

        }

        hintStorage.put(Text.STRIKE, strikeCount);
    }
}
