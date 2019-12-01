/*
 * @(#)Result.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class Result {
    private int strikes;
    /** '볼'을 의미합니다(공을 의미하는 것이 아닙니다). */
    private int B;

    public Result(int strikes, int B) {
        this.strikes = strikes;
        this.B = B;
    }

    @Override
    public boolean equals(Object object) {
        if ((object == null) || object.getClass() != this.getClass()) {
            return false;
        }

        return this.strikes == ((Result)object).strikes && this.B == ((Result)object).B;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getB() {
        return B;
    }
}
