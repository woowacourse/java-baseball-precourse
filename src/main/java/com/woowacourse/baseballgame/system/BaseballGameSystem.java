package com.woowacourse.baseballgame.system;

import com.woowacourse.baseballgame.io.InputBaseballGame;
import com.woowacourse.baseballgame.io.OutputBaseballGame;

import java.util.HashSet;

public class BaseballGameSystem {
    public static final int CONTINUE = 1;
    public static final int GAMEOVER = 2;

    private static final int DIGIT = 3;

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
        int userNumber;

        while (strikeCount != 3) {
            initPitchCount();
            userNumber = InputBaseballGame.inputUserNumber();
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
}
