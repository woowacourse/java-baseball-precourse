package numberBaseball.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlayerBot implements Player {
    private int[] answerNumber = new int[] {0, 0, 0};

    public int randomPop(ArrayList<Integer> numberSet) {
        int randomIdx = (new Random()).nextInt(numberSet.size());
        return numberSet.remove(randomIdx);
    }

    public void setThreeNumber() {
        ArrayList<Integer> numberSet = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            numberSet.add(i);
        }
        for (int i = 0; i < this.answerNumber.length; i++) {
            this.answerNumber[i] = randomPop(numberSet);
        }
    }

    public int[] guessThreeNumber() {
        return new int[3];
    }

    public void answerHintOf(int[] guessed) {

    }

    public boolean checkCorrect(int[] guessed) {
        return Arrays.equals(this.answerNumber, guessed);
    }
}