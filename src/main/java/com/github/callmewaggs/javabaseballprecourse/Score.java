package com.github.callmewaggs.javabaseballprecourse;

public class Score {

    private int strike;
    private int ball;
    private boolean win;

    public Score() {
        this.strike = 0;
        this.ball = 0;
        this.win = false;
    }

    public boolean isWin() {
        return win;
    }

    public void init() {
        this.strike = 0;
        this.ball = 0;
        this.win = false;
    }

    public void calculateWinning(int[] numbers1, int[] numbers2) {
        for(int i = 0 ; i < 3 ; ++i) {
            for(int j = 0 ; j < 3; ++j) {
                calculateScore(numbers1[i], numbers2[j], i, j);
            }
        }
        if(strike == 3)
            win = true;
    }

    private void calculateScore(int number1, int number2, int index1, int index2) {
        if(number1 == number2) {
            if(index1 == index2)
                ++strike;
            else
                ++ball;
        }
    }

    public void printScore() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            if (strike == 0 && ball == 0)
                System.out.println("낫싱");
            else
                System.out.println(strike + " 스트라이크 " + ball + "볼");
        }
    }
}
