/*
 * @(#)Hint.java
 *
 */

package baseball;

public class Hint {
    private int strike, ball;

    public Hint(){

    }

    public int getStrike() {
        return strike;
    }

    public void setHint(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    /**
     * Hint의 내용을 출력하는 메소드
     */
    public void printHint(){
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        System.out.println();
    }

    /**
     * 정답과 플레이어의 답안을 비교하는 메소드
     *
     * @param answer
     * @param playerAnswer
     */
    public void compareAnswerAndPlayerNumber(int[] answer, int[] playerAnswer){
        for (int i = 0; i < Constants.MAX_LEN; i++) {
            countStrike(answer[i], playerAnswer[i]);
            countBall(answer, playerAnswer[i], i);
        }
    }

    /**
     * Strike의 개수를 세는 메소드
     * answer과 playerAnswer이 일치한다면 strike의 값을 1 증가시킨다.
     *
     * @param answer
     * @param playerAnswer
     */
    private void countStrike(int answer, int playerAnswer){
        if (answer == playerAnswer) {
            this.strike++;
        }
    }

    /**
     * Ball의 개수를 세는 메소드
     * playerAnswer이 answer에 포함되어있다면 ball을 1 증가시킨다.
     * 이때, 주어진 자릿수(digits)와 다른 위치에 포함되어있어야한다.
     *
     * @param answer
     * @param playerAnswer
     */
    private void countBall(int[] answer, int playerAnswer, int digits){
        for (int i = 0; i < Constants.MAX_LEN; i++) {
            if (i != digits && answer[i] == playerAnswer) { // 자릿수가 다르지만 playerAnswer과 같은 값이 answer에 존재하는 경우
                this.ball++;
            }
        }
    }
}
