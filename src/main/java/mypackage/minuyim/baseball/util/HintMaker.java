/*
 * @(#)HintMaker.java
 * 
 * version : 1.0
 * 
 * 2019.12.01
 */

package mypackage.minuyim.baseball.util;

/**
 * HintMaker : 사용자가 입력한 숫자와 정답을 비교하여 힌트를 만드는 클래스
 * 
 * @version 1.00 2019/12/01
 * @author 임민우
 */
public class HintMaker {
    private static final int LENGTH_NUMBER = 3;
    public int strike;
    public int ball;
    private int[] ans;
    private int[] user;

    public HintMaker(int[] answer, int[] userAnswer) {
        this.ans = answer;
        this.user = userAnswer;
        this.strike = makeStrike(this.ans, this.user);
        this.ball = makeBall(this.ans, this.user);
    }

    private int makeStrike(int[] answer, int[] userAnswer) {
        int count = 0;

        for (int i = 0; i < LENGTH_NUMBER; i++) {
            count += compareN(answer[i], userAnswer[i]);
        }
        
        return count;
    }

    private int makeBall(int[] answer, int[] userAnswer) {
        int count = 0;

        for (int i = 0; i < LENGTH_NUMBER; i++) {
            for (int j = 0; j < LENGTH_NUMBER; j++) {
                count += compareN(answer[i], userAnswer[j]);
            }
        }
        
        return count - makeStrike(answer, userAnswer);
    }

    private int compareN(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        } else {
        	return 0;
        }
    }
}
