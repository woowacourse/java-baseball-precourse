/**
* Computer.class        1.0 2019/03/25
*
* <Copyright 2019. 이남준. All rights reserved.>
*/

package JavaBaseball;

import java.util.Random;

/**
* 게임의 컴퓨터 역할을 하는 클래스
* @version              1.0 2019/03/25
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

    /**
     * 유저의 입력이 정답인지 판별
     * @param userNumber 유저로부터 입력받은 세자리 수
     * @return 정답 일시 : true / 정답이 아닐시 : false
     */
    public boolean correctCheck(int[] userNumber) {
        return number.equals(userNumber);
    }

    /**
     * 유저의 입력의 결과를 판별
     * @param userNumber 유저가 입력한 세자리수
     * @return [0] : 스트라이크의 갯수, [1] : 볼의 갯수
     */
    public int[] countScore(int[] userNumber) {

        int[] score = new int[2];
        score[0] = countStrikes(userNumber);
        score[1] = countBalls(userNumber);

        return score;
    }

    /**
     * 스트라이크 갯수를 판별
     * @param userNumber 유저가 입력한 세자리수
     * @return 스트라이크의 갯수
     */
    private static int countStrikes(int[] userNumber) {

        int strikes = 0;

        for(int i = 0; i < 3; i++) {
            if(number[i] == userNumber[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    /**
     * 볼의 갯수를 판별
     * @param userNumber 유저가 입력한 세자리수
     * @return 볼의 갯수
     */
    private static int countBalls(int[] userNumber) {

        int balls = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 1; j < 3; j++) {
                if(number[i] == userNumber[(i + j) % 3]) {
                    balls++;
                    userNumber[(i + j) % 3] = -1;
                }
            }
        }

        return balls;
    }
}
