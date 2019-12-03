/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Result.java
 * 난수와 예측 값의 비교 결과를 저장하는 클래스
 *
 * @author		Sorin Jin
 * @version		1.0
 * @date	    03 Dec 2019
 *
 */
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result{
    static final int ZERO = 0;

    int numberOfBall;
    int numberOfStrike;

    public Result(){
        numberOfBall = ZERO;
        numberOfStrike = ZERO;
    }
}