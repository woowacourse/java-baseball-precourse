/*
 * @(#)Main.java             1.0.0 2019/03/27
 *
 * Copyright (c) 2019 Kris Kim.
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All right reserved
 *
 * This software is the confidential and proprietary information of Kris
 * Kim ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kris Kim
 */

package baseball;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
/**
 * Main 클래스는 다음과 같은 기능을 구현한다
 * 1. 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 기능
 * 2. 사용자로 부터 숫자를 입력 받는 기능
 * 3. 입력 받은 수가 세자리 양의 정수 인지 확인하고 아닐시 오류를 출력하는 기능
 * 4. 숫자를 서로 비교하여 스트라이크 와 볼을 세는 기능
 * 5. 4번을 바탕으로 스트라이크 볼 낫싱을 판단하여 출력하는 기능
 * 6. 게임 종류후 문구를 출력하고 사용자 입력을 받아 게임을 다시 시작하거나 완전히 종료하는 기능
 *
 * @version                             1.00 2019년 3월 27일
 * @author                              김홍덕
 */
public class Main {
    /* Main class 에 상기한 기능들을 포함하는 함수를 각각 구현한다 */

    public static void main(String args[]) {
        int flag = 0;
        int[] count = {0};
        Main myTest = new Main();

        int comnum[] = myTest.randNumGenerator();    //randNumGenerator 함수로부터 랜덤 값을 받아온다

        /* 테스트용 출력 */
//        for (int i = 0; i<comnum.length; i++) {
//            System.out.print(comnum[i]);
//        }

        while (flag != 2) {  //restGame 으로부터 입력받은 flag가 2이면 게임을 종료한다.
            int a = myTest.numReader();     //numReader로 부터 값을 입력 받음
            int usernum[] = myTest.checkNum(a);

            /* 테스트용 출력 */
//            for (int i = 0; i<usernum.length; i++) {
//                System.out.print(usernum[i]);
//            }

            if (usernum.length != 1) { //유저가 입력한 숫자가 제대로 된 숫자일때만 진행한다.
            count = myTest.compNum(comnum, usernum);
                myTest.prtResult(count);
                System.out.println("");
            }

            if (count[0] == 3) { // 스트라이크가 3일경우에 새로운 랜덤숫자를 만들고 restGame 함수를 실행한다.
                count[0] = 0;
                comnum = myTest.randNumGenerator();

                /* 테스트용 출력 */
//                for (int i = 0; i<comnum.length; i++) {
//                    System.out.print(comnum[i]);
//                }

                flag = myTest.resetGame();
            }
        }
    }

    /**
     * randNumGenerator는 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성한다.
     * @return 만들어낸 숫자를 리턴한다.
     */
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

        while(computer[0] == computer[1] || computer[1] == 0) {
            computer[1] = random.nextInt(10);
        }

        //computer의 세자리 숫자 중에 1번째와 3번째가 중복되거나,
        //2번째와 3번째가 중복되거나,
        //3번째가 0이라면 세번째 수에 랜덤 값 할당

        while (computer[0] == computer[2] || computer[1] == computer[2]
                || computer[2] == 0) {
            computer[2] = random.nextInt(10);
        }
        return computer;
    }

    /**
     * numReader은 사용자로 부터 숫자를 입력받는 함수 이다.
     * @return 사용자가 입력한 숫자를 리턴한다.
     */
    private int numReader(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();                   //입력받은 숫자를 반환한다.
    }

    /**
     * checkNum은 사용자로 입력받은 숫자가 3자리 수인지, 양의 정수인지 판별해 준다.
     * @param number 사용자가 입력한 수를 파라미터로 받는다.
     * @return 파라미터 number가 3자리 양의 정수일 경우 배열로 바꾸어서 리턴하고 아니면 -1을 리턴한다.
     */
    private int[] checkNum(int number){

        int[] a = {-1};

        if (number < 0) {                      //입력 받은 수가 양수인지 확인한다.
            System.out.println("음수는 입력할 수 없습니다");
            return a;
        }
        /*입력받은 수를 배열 형태로 바꾸어준다*/
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

        if (digits.length >= 4 || digits.length <= 2) {  // 입력받은수가 세자리 수인지 확인한다
            System.out.println("세자리 수를 입력하세요");
            return a;
        }
        return digits;
    }

    /**
     * compNum 은 사용자가 만든 숫자와 컴퓨터가 만든 숫자를 비교하여 ball 과 strike를 세는 역할을 한다.
     * @param comnum 컴퓨터가 만들어낸 숫자
     * @param usernum 유저가 입력한 숫자
     * @return 스트라이크 수와 볼 수를 저장하고 있는 count 배열을 리턴한다.
     */
    private int[] compNum(int[] comnum, int[] usernum){

        int[] count = {0,0};                   //strike, ball 카운트이다.

        for (int i = 0; i<3; i++) {

            if (comnum[i] == usernum[i]) {
                count[0] += 1;              //strike 카운트를 하나 늘린다.
            } else if (usernum[i] == comnum[1] || usernum[i] == comnum[2] || usernum[i] == comnum[0]){
                count[1] +=1;                //ball count를 하나 늘린다.
            }
        }
        return count;
    }

    /**
     * prtResult는 strike와 ball수를 바탕으로 낫싱 , 스트라이크, 볼을 판단하여 출력한다
     * @param count 스트라이크 수와 볼 수를 저장하고 있는 count 배열을 파라미터로 전달 받는다.
     */
    private void prtResult(int[] count){
        if (count[0] == 0 && count[1] == 0) { //strike 와 ball 이 전부 0 일때 낫싱을 출력한다
            System.out.print("낫싱");
        }

        if (count[0] > 0) {
            System.out.print(count[0]+" 스트라이크 ");
        }

        if (count[1] > 0) {
            System.out.print(count[1]+" 볼");
        }
    }

    /**
     * resetGame 메서드는 문구를 출력하고 입력받은 숫자를 반환한다.
     * @return 메서드에서 입력받은 숫자를 리턴한다
     * */
     private int resetGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();//입력받은 숫자를 반환한다.
    }
}
