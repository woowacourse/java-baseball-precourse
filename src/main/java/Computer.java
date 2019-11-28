/*
 * Class Name: main.java
 * Version: 0.1
 * Date: 2019.11.28
 * Copyright(c) 2019 Sujin Cha(MIR013)
 * All rights reserved.
 *
 * This software is made for precourse of woowacourse.
 */

import java.util.Random;

/**
 * 클래스 Computer의 역할
 * 숫자야구 게임을 위한 난수를 생성한다.(단, 중복x)
 * 그리고 사용자가 언급한 수와 난수와 비교하겨 결과를 출력한다.
 */
public class Computer {
    /** 생성한 야구 게임 수 */
    private String number = new String();
    private final int RANDOM_NUMBER_SIZE = 10;

    /** 초기화와 동시에 야구게임 난수 생성 */
    public Computer()
    {
        Random random = new Random();       // 난수 생성용 객체
        Integer firstValue;                     // 첫 번째 수
        Integer secondValue;                    // 두 번째 수
        Integer thirdValue;                     // 세 번째 수

        //서로 다른 난수 생성
        firstValue = random.nextInt(RANDOM_NUMBER_SIZE);
        do{
            secondValue = random.nextInt(RANDOM_NUMBER_SIZE);
        }while(secondValue==firstValue);
        do {
            thirdValue = random.nextInt(RANDOM_NUMBER_SIZE);
        }while(thirdValue == firstValue || thirdValue == secondValue);

        this.number = firstValue.toString() + secondValue.toString() + thirdValue.toString();
        System.out.println("computer: "+this.number);
    }

    /** 특정값에 따라 결과 반환 */
    public boolean checkBaseball(String value)
    {

        return false;
    }

}
