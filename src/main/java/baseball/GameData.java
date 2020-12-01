package baseball;

import utils.RandomUtils;

// Data needed to play the game
public class GameData {

    public static final int DIGIT_SIZE = 10; // 0 ~ 9
    public static final int MIN_RANDOM_VALUE = 1;
    public static final int MAX_RANDOM_VALUE = 9;

    private int[] chosenNumber = new int[Application.MAX_NUM_SIZE];
    private int ballCount = 0;
    private int strikeCount = 0;

    public int getChosenNumber(int index) {
        return chosenNumber[index];
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setChosenNumber(int index, int val) {
        chosenNumber[index] = val;
    }

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void initCounts() {
        ballCount = 0;
        strikeCount = 0;
    }

    // constructor: initialize varialbes and arrays
    public GameData() {
        for (int i = 0; i < Application.MAX_NUM_SIZE; i++) {
            setChosenNumber(i, 0);
        }
        initCounts();
    }

    // give random values using RandomUtils
    public void selectRandomNumber() {
        boolean[] isUsed = new boolean[DIGIT_SIZE];
        int currentIndex = 0;
        while (currentIndex < Application.MAX_NUM_SIZE) {
            int randomNumber = RandomUtils.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            if (!isUsed[randomNumber]){
                setChosenNumber(currentIndex, randomNumber);
                isUsed[randomNumber] = true;
                currentIndex++;
            }
        }
    }
}
