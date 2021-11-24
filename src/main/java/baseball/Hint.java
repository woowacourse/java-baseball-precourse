package baseball;


public class Hint {
    private int strike;
    private int ball;

    public void countHint(int[] answer, String userInput) {
        initCount();
        for (int i = 0; i < Rules.NUMBER_LENGTH; i++) {
            int userNumber = Character.getNumericValue(userInput.charAt(i));
            countStrike(userNumber, answer[i]);
            countBall(i, userNumber, answer);
        }
    }

    private void initCount() {
        this.strike = 0;
        this.ball = 0;
    }

    private void countStrike(int userNumber, int answerNumber) {
        if (userNumber == answerNumber) {
            this.strike++;
        }
    }

    private void countBall(int currentIdx, int userNumber, int[] answer) {
        for (int i = 0; i < Rules.NUMBER_LENGTH; i++) {
            if (i != currentIdx && userNumber == answer[i]) {
                this.ball++;
            }
        }
    }
}
