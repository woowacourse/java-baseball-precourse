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
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;
/**
 * Main 클래스는 다음과 같은 기능을 구현한다
 * 1.1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 기능
 * 2.세 자리의 수를 입력 받는 기능
 * 3. 입력 받은 수가 세자리 수 인지 확인하는 기능
 */
public class Main {
    static int strike = 0;
    static int ball = 0;
    public static void main(String args[]) {
        Main myTest = new Main();

        int a[] = myTest.randNumGenerator();    //randNumGenerator함수로부터 랜덤 값을 받아온다
        //테스트용 출력
//        for (int i = 0; i<a.length; i++) {
//            System.out.print(a[i]);
//        }
        while(strike < 3) {  //스트라이크 3이 안되면 반복
            int b = myTest.numReader();     //numReader로 부터 값을 입력 받음
            myTest.checkNum(b);
            System.out.println(b);     //Test용 출력
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
    //numReader은 사용자로 부터 숫자를 입력받는 함수 이다.
    private int numReader(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();//입력받은 숫자를 반환한다.
    }
    // checkNum은 사용자로 입력받은 숫자가 3자리 수인지, 양의 정수인지 판별해 준다.
    private void checkNum(int number){
        //정수를 배열 형태로 바꾸어줌
        if(number < 0){
            System.out.println("음수는 입력할 수 없습니다");
            return;
        }
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits.length >= 4 || digits.length <= 2) {
                System.out.println("세자리 수를 입력하세요");
                return;
            }
        }
        return;
    }
}
