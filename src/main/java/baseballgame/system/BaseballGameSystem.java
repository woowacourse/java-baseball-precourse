package baseballgame.system;

import baseballgame.io.OutputBaseballGame;

import java.util.HashSet;

public class BaseballGameSystem {
    private static final int DIGIT = 3;
    private int strikeCount = 0, ballCount = 0;
    private HashSet<Integer> answerNumberSet;
    private int[] userNumberArr;

    public BaseballGameSystem() {
        generateAnswerNumber();
    }

    public void generateAnswerNumber() {
        answerNumberSet = new HashSet<>();

        while (answerNumberSet.size() < DIGIT) {
            answerNumberSet.add(generateRandomNumber());
        }
    }

    public int generateRandomNumber() {
        return (int) ((Math.random() * 9) + 1);
    }

    public void checkAnswer(int userNumber) {
        int index = 0;

        splitUserNumber(userNumber);
        for (int ans : answerNumberSet) {
            setPitchCount(ans, index);
            index++;
        }

        OutputBaseballGame.printPitchResult(strikeCount, ballCount);
    }

    public void splitUserNumber(int userNumber) {
        userNumberArr = new int[DIGIT];

        for (int i = 0; i < DIGIT; i++) {
            userNumberArr[i] = userNumber % 10;
            userNumber /= 10;
        }
    }

    public void setPitchCount(int ans, int index) {
        for (int i = 0; i < DIGIT; i++) {
            if (i == index && userNumberArr[i] == ans)
                strikeCount++;
            else if (userNumberArr[i] == ans)
                ballCount++;
        }
    }

    public void initPitchCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
