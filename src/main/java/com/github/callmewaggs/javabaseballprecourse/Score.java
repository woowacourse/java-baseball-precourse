package com.github.callmewaggs.javabaseballprecourse;

public class Score {

    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public void init() {
        this.strike = 0;
        this.ball = 0;
    }

    //TODO : indent depth <= 3
    public void calculate(int[] numbers1, int[] numbers2) {
        for(int i = 0 ; i < 3 ; ++i) {
            for(int j = 0 ; j < 3; ++j) {
                if(numbers1[i] == numbers2[j]) {
                    if(i == j)
                        ++this.strike;
                    else
                        ++this.ball;
                }
            }
        }
    }
}
