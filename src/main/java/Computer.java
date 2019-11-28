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
 * 그리고 사용자가 언급한 수와 난수와 비교하여 결과를 출력한다.
 */
public class Computer {
    /** 생성한 야구 게임 수 */
    private String number = new String();             // 생성 숫자
    private final int RANDOM_NUMBER_SIZE = 10;      //야구게임 생성 숫자 크기
    private final int BASEBALL_SIZE = 3;            //야구게임 볼 수

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

    /** 특정값에 따라 결과 반환. */
    public boolean checkBaseball(String value)
    {
        Integer[] result = new Integer[2];            // 스트라이크 개수, 볼 개수
        boolean isNotStrike = true;                    // 3 스트라이크 여부

        //초기화
        result[0] = 0;
        result[1] = 0;

        //숫자 검사
        for(int i=0;i<BASEBALL_SIZE;i++){
            checkValue(this.number.charAt(i),i,value,result);
        }
        //System.out.println(result[0].toString()+" : "+result[1].toString());

        //결과 출력
        if(result[0] == 3){                                 // 3 strike
            isNotStrike = false;
        }
        if(result[0]>0){                                    // strike 출력
            System.out.print(result[0]+" 스트라이크 ");
        }
        if(result[1]>0){                                    // ball 출력
            System.out.print(result[1]+" 볼 ");
        }
        if(result[0]<=0 && result[1]<=0){                   // 낫싱 출력
            System.out.print("낫싱 ");
        }

        System.out.println("");
        return isNotStrike;
    }

    /** 각 정답인 수 하나에 해당하는 것의 스트라이크/볼을 구분한다. */
    private void checkValue(char num,int location, String value,Integer[] result)
    {
        for(int i=0;i<BASEBALL_SIZE;i++){
            char compare = value.charAt(i);
            if(location == i && num == compare){
                result[0] += 1;
            }else if(num == compare){
                result[1] += 1;
            }
        }

        return;
    }
}
