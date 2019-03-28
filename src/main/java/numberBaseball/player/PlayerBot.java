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

    public boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(n -> n == key);
    }

    public StringBuffer makeHintMsg(int strikeCount, int ballCount) {
        StringBuffer hintMsg = new StringBuffer();

        if (strikeCount != 0)
            hintMsg.append(strikeCount + " 스트라이크 ");
        if (ballCount != 0)
            hintMsg.append(ballCount + " 볼 ");
        if ((strikeCount == 0) && (ballCount == 0))
            hintMsg.append("낫싱");
        return hintMsg;
    }

    public void answerHintOf(int[] guessed) {
        final int oneScore = 1;
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < guessed.length; i++) {
            if (guessed[i] == this.answerNumber[i])
                strikeCount += oneScore;
            else if (contains(this.answerNumber, guessed[i]))
                ballCount += oneScore;
        }
        System.out.println(makeHintMsg(strikeCount, ballCount));
    }

    public boolean checkCorrect(int[] guessed) {
        return Arrays.equals(this.answerNumber, guessed);
    }
}