package baseball.model;

import baseball.util.AnswerRange;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int[] answer;
    private boolean[] duplicateCheck;

    public Computer() {
    }

    public int[] getAnswer() {
        return answer;
    }

    public void createAnswer() {
        initAnswer();
        initDuplicateCheck();

        for (int i = 0; i < AnswerRange.DIGIT; i++) {
            int randomNumber = pickRandomNumber();
            answer[i] = randomNumber;
            duplicateCheck[randomNumber] = true;
        }
    }

    private void initAnswer() {
        answer = new int[AnswerRange.DIGIT];
    }

    private void initDuplicateCheck() {
        duplicateCheck = new boolean[AnswerRange.MAX + 1];
    }

    private int pickRandomNumber() {
        int randomNumber;

        do {
            randomNumber = Randoms.pickNumberInRange(AnswerRange.MIN, AnswerRange.MAX);
        } while (duplicateCheck[randomNumber]);

        return randomNumber;
    }
}
