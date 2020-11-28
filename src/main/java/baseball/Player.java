package baseball;

import java.util.Scanner;
import views.OutputView;

public class Player {
    public static final int WANT_REPLAY = 1;
    public static final int WANT_FINISH = 2;
    private int replayDecision;
    private Scanner playerInput;

    public Player(Scanner playerInput) {
        replayDecision = WANT_FINISH;
        this.playerInput = playerInput;
    }

    public int getReplayDecision() {
        return replayDecision;
    }

    public void checkReplayDecision() {
        OutputView.askReplay();
        int choice = playerInput.nextInt();
        validate(choice);
        replayDecision = choice;
    }

    private void validate(int choice) {
        if(choice != WANT_REPLAY && choice != WANT_FINISH) {
            throw new IllegalArgumentException("올바른 선택지가 아닙니다.");
        }
    }
}
