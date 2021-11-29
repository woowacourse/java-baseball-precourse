package baseball;

import java.util.HashMap;

import communication.Text;

public class Umpire {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private final int RESET = 0;
    private String computersNumber;
    private String usersNumber;
    private HashMap<String, Integer> hintStorage;
    private String hint;

    public Umpire(String computersNumber) {
        this.computersNumber = computersNumber;
        this.hintStorage = new HashMap<>();
    }

    private void resetHintStorage() {
        hintStorage.put(Text.STRIKE, RESET);
        hintStorage.put(Text.BALL, RESET);
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

    private void countBall() {
        int ballCount = 0;

        for (int i = 0; i < ESSENTIAL_NUMBER_LENGTH; i++) {
            String compareNumber = String.valueOf(usersNumber.charAt(i));

            if (computersNumber.contains(compareNumber)) {
                ballCount++;
            }

        }

        hintStorage.put(Text.BALL, ballCount - hintStorage.get(Text.STRIKE));
    }

    public void compareNumbers(String usersNumber) {
        resetHintStorage();
        this.usersNumber = usersNumber;

        if (isNothing()) {
            hint = Text.NOTHING;
        } else {
            countStrike();
            countBall();
            hint = "";
        }

    }
}
