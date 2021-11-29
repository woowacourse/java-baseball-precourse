package baseball;

import java.util.HashMap;

import communication.Text;

public class Umpire {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private final int ZERO = 0;
    private final int MAX_HINT = 3;
    private String computersNumber;
    private String usersNumber;
    private HashMap<String, Integer> hintStorage;
    private String hint;

    public Umpire(String computersNumber) {
        this.computersNumber = computersNumber;
        this.hintStorage = new HashMap<>();
    }

    private void resetHintStorage() {
        hintStorage.put(Text.STRIKE, ZERO);
        hintStorage.put(Text.BALL, ZERO);
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

    public void reportHint() {

        if (hint.equals(Text.NOTHING)) {
            System.out.println(Text.NOTHING);
            return;
        }

        if (hintStorage.get(Text.BALL) != ZERO) {
            hint += hintStorage.get(Text.BALL) + Text.BALL + " ";
        }

        if (hintStorage.get(Text.STRIKE) != ZERO) {
            hint += hintStorage.get(Text.STRIKE) + Text.STRIKE;
        }

        System.out.println(hint);
    }

    public boolean isWin() {

        if (hintStorage.get(Text.STRIKE) == MAX_HINT) {
            return true;
        }

        return false;
    }
}
