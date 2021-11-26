package baseball;

import java.util.List;

import static constant.Constant.*;


public class Hint {
    private int ballCount;
    private int strikeCount;

    public Hint() {
        this.ballCount = INITIAL_VALUE;
        this.strikeCount = INITIAL_VALUE;
    }

    public void countStrikeAndBall(List<Integer> randomNum, List<Integer> input) {
        this.ballCount = INITIAL_VALUE;
        this.strikeCount = INITIAL_VALUE;
        for (int i=INITIAL_VALUE; i<NUM_LENGTH; i++) {
            if (randomNum.get(i) == input.get(i)) {
                this.strikeCount++;
                continue;
            }
            if (randomNum.contains(input.get(i))) {
                this.ballCount++;
            }
        }
        printHintMessage();
    }

    public void printHintMessage() {
        if (this.strikeCount == 3) {
            return;
        }
        if (this.ballCount == INITIAL_VALUE && this.strikeCount == INITIAL_VALUE) {
            System.out.println(RESULT_NOTHING_MESSAGE);
            return;
        }
        if (this.ballCount == INITIAL_VALUE && this.strikeCount > INITIAL_VALUE) {
            System.out.println(this.strikeCount+STRIKE);
            return;
        }
        if (this.ballCount > INITIAL_VALUE && this.strikeCount == INITIAL_VALUE) {
            System.out.println(this.ballCount+BALL);
            return;
        }
        System.out.println(this.ballCount + BALL + " " + this.strikeCount+STRIKE);
    }
}
