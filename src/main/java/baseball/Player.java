package baseball;

import java.util.Scanner;
import views.OutputView;

public class Player {

    public static final int WANT_REPLAY = 1;
    public static final int WANT_FINISH = 2;
    private static final String CHOICE_ERROR_MESSAGE = "올바른 선택지가 아닙니다.";
    private int replayDecision;
    private final Scanner playerInput;

    public Player(Scanner playerInput) {
        replayDecision = WANT_FINISH;
        this.playerInput = playerInput;
    }

    public int getReplayDecision() {
        return replayDecision;
    }

    public void checkReplayDecision() {
        OutputView.askReplay();
        String input = playerInput.nextLine();
        replayDecision = validate(input);
    }

    private int validate(String input) {
        try {
            return getChoice(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHOICE_ERROR_MESSAGE);
        }
    }

    private int getChoice(String input) {
        int choice = Integer.parseInt(input);
        if (choice != WANT_REPLAY && choice != WANT_FINISH) {
            throw new IllegalArgumentException(CHOICE_ERROR_MESSAGE);
        }
        return choice;
    }
}
