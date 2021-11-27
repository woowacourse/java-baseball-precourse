package baseball;

import baseball.exception.WrongGuessException;

import java.util.Arrays;

public class MarkingManager {
    private int[] answerArray;
    private int strike;
    private int ball;


    public MarkingManager(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public void markStrike(int[] guessArray) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] == guessArray[i]) {
                strike ++;
            }
        }
        this.strike = strike;
    }

    public void markBall(int[] guessArray) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] != guessArray[i] && checkContain(guessArray[i])) {
                ball++;
            }
        }
        this.ball = ball;
    }

    public boolean checkContain(int guessInt) {
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] == guessInt) {
                return true;
            }
        }
        return false;
    }

    public void mark(int[] guessArray) throws WrongGuessException {
        markStrike(guessArray);
        markBall(guessArray);
        if (strike == 3) {
            guessRight();
        } else {
            guessWrong();
            throw new WrongGuessException();
        }
    }

    public void guessRight() {
        System.out.print("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void guessWrong() {
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        } else if (strike != 0 && ball == 0) {
            System.out.print(String.format("%d스트라이크", strike));
        } else if (strike == 0 && ball != 0) {
            System.out.print(String.format("%d볼", ball));
        } else {
            System.out.print(String.format("%d볼 %d스트라이크", ball, strike));
        }
    }

}
