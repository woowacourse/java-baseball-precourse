package com.woowacourse.baseballgame.system;

import com.woowacourse.baseballgame.io.InputBaseballGame;
import com.woowacourse.baseballgame.io.OutputBaseballGame;

import java.util.HashSet;

public class BaseballGameSystem {
    public static final int CONTINUE = 1;
    public static final int GAME_OVER = 2;

    private static final int DIGIT = 3;
    private static final int FINISH_CONDITION = 3;

    private int strikeCount, ballCount;
    private int[] userNumberArr;
    private HashSet<Integer> answerNumberSet;

    public void startGame() {
        int nextStep = CONTINUE;

        while (nextStep == CONTINUE) {
            generateAnswerNumber();
            initPitchCount();                               // 추가 게임을 진행한 경우를 위해
            playInGame();
            nextStep = InputBaseballGame.inputNextStep();
        }
    }

    public void playInGame() {
        while (strikeCount != FINISH_CONDITION) {
            initPitchCount();
            int userNumber = InputBaseballGame.inputUserNumber();
            checkAnswer(userNumber);
            OutputBaseballGame.printPitchResult(strikeCount, ballCount);
        }
        OutputBaseballGame.printFinishMsg();
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
            if (isStrike(index, ans, i))
                strikeCount++;
            else if (isBall(ans, i))
                ballCount++;
        }
    }

    public void initPitchCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isStrike(int answerIndex, int answerNumber, int userIndex) {
        return answerIndex == userIndex && userNumberArr[userIndex] == answerNumber;
    }

    public boolean isBall(int answerNumber, int userIndex) {
        return userNumberArr[userIndex] == answerNumber;
    }
}
