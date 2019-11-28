import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    private boolean wantToContinue;
    private Scanner input;

    Player() {
        this.wantToContinue = true;
        this.input = new Scanner(System.in);
    }

    public List<Integer> getPlayerInputNumbers() {
        List<Integer> inputNumbers = new ArrayList<>();
        String inputString = input.next();

        for (int i = 0; i < BaseballGame.ANSWER_NUMBERS_COUNT; ++i) {
            inputNumbers.add(inputString.charAt(i) - '0');
        }

        return inputNumbers;
    }

    public boolean toBeContinued() {
        return this.wantToContinue;
    }

    public void playerQuitGame() {
        this.wantToContinue = false;
    }
}
