/*
 * Main.java
 *
 * 1.0.0
 *
 * 2019/03/26
 *
 * copyright Kris Kim.
 * All right reserved
 */

package baseball;

import java.util.Random;
/**
 * Example 클래스는 ...
 */
public class Main {

    public static void main(String args[]) {
        Main myTest = new Main();
        //randNumGenerator함수로부터 랜덤 값을 받아온다
        int a[] = myTest.randNumGenerator();
        //테스트용 출력
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i]);
        }
    }

    private int[] randNumGenerator(){

        int computer[] = new int[3]; //컴퓨터가 정한 수
        Random random = new Random();
        //컴퓨터가 정한 수를 한자리 씩 정한다
        //중복방지
        //computer 세자리 숫자 중에 1번째가 0이면 랜덤 값 할당,
        while(computer[0] == 0){
            computer[0] = random.nextInt(10);
        }
        //computer 세자리 숫자 중에 1번째와 2번째가 중복되거나,
        //2번째가 0이라면 랜덤 값 할당
        while(computer[0] == computer[1] || computer[1] == 0){
            computer[1] = random.nextInt(10);
        }
        //computer의 세자리 숫자 중에 1번째와 3번째가 중복되거나,
        //2번째와 3번째가 중복되거나,
        //3번째가 0이라면 세번째 수에 랜덤 값 할당
        while(computer[0] == computer[2] || computer[1] == computer[2]
                || computer[2] == 0) {
            computer[2] = random.nextInt(10);
        }
        return computer;
    }

}
