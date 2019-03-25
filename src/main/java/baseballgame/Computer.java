/*
 * @(#)Computer.java        0.3 2019/03/26
 *
 *
 */

package baseballgame;

import java.util.Random;

/**
 * 기능 목록 2 - 컴퓨터가 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성 하는 클래스입니다.
 *
 * @version         0.3 2019년 3월 26일
 * @author          반선호
 */
class Computer {

    /** 난수 생성 시 범위를 지정해주기 위한 상수 - (0~8)의 범위로 설정 */
    private static final int MAX_NUM = 9;

   /** 위의 MAX_NUM을 이용해 생성된 난수에 1을 더하기 위한 상수 */
    private static final int ONE = 1;

    /** 숫자의 최대 길이 상수 */
    private static final int BALL_LEN = 3;

    /** 생성된 숫자를 담을 문자열 */
    String number = "";

    /**
     * Computer 생성자이며 서로 다른 수로 이루어진 3자리의 수를 만들어 낸다.
     */
    Computer(){
        Random random;
        int temp;

        while(number.length() < BALL_LEN){
            random = new Random();
            temp = random.nextInt(MAX_NUM) + ONE;

            if(!checkDuplicate(temp)){

                /* 만약 중복 되지 않는다면 생성된 난수를 합친다*/
                number += String.valueOf(temp);
            }
        }
    }

    /**
     * 생성된 난수가 중복되는지 확인하는 메소드이다.
     * @param temp = 1 ~ 9사이의 난수이다.
     * @return 만약 난수가 중복된다면 true를 return한다.
     */
    private boolean checkDuplicate(int temp){
        return number.contains(String.valueOf(temp));
    }
}
