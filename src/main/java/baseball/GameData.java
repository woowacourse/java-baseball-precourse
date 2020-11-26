package baseball;

import utils.RandomUtils;

// Data needed to play the game
public class GameData {

    private int[] chosenNumber = new int[3];
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
        for (int i = 0; i < 3; i++) {
            setChosenNumber(i, 0);
        }
        initCounts();
    }

    // give random values using RandomUtils
    public void selectRandomNumber() {
        boolean[] isUsed = new boolean[10];
        int currentIndex = 0;
        while (currentIndex < 3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            if (!isUsed[randomNumber]){
                setChosenNumber(currentIndex, randomNumber);
                isUsed[randomNumber] = true;
                currentIndex++;
            }
        }
    }
}
