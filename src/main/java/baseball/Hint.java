package baseball;

import java.util.List;

import static baseball.Game.NUM_LENGTH;

public class Hint {
    private int ballCount;
    private int strikeCount;

    public Hint() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void countStrikeAndBall(List<Integer> randomNum, List<Integer> input) {
        this.ballCount = 0;
        this.strikeCount = 0;
        for (int i=0; i<NUM_LENGTH; i++) {
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
        if (this.ballCount == 0 && this.strikeCount == 0) {
            System.out.println(Message.RESULT_NOTHING_MESSAGE);
            return;
        }
        if (this.ballCount == 0 && this.strikeCount > 0) {
            System.out.println(this.strikeCount+"스트라이크");
            return;
        }
        if (this.ballCount > 0 && this.strikeCount == 0) {
            System.out.println(this.ballCount+"볼");
            return;
        }
        System.out.println(this.ballCount + "볼 " + this.strikeCount+"스트라이크");
    }
}
