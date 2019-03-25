/**
* Computer.class        0.25 2019/03/25
*
* <Copyright 2019. 이남준. All rights reserved.>
*/

package JavaBaseball;

import java.util.Random;

/**
* 게임의 컴퓨터 역할을 하는 클래스
* @version              0.25 2019/03/25
* @author               이남준
*/
public class Computer {

    /** 생성된 난수를 저장할 변수 */
    private static int[] number = new int[3];

    /**
     * 게임이 시작되어 클래스가 생성되면 자동으로 난수를 생성하도록 하는 생성자
     */
    public Computer() {
        setRndNumber();
    }

    /**
    * 난수를 생성하는 메소드
    */
    private static void setRndNumber() {
        Random rd = new Random();
        number[0] = rd.nextInt(9) + 1;
        number[1] = rd.nextInt(9) + 1;
        number[2] = rd.nextInt(9) + 1;
    }
}
