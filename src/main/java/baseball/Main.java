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
    public static void main(String args[]) {
        int strike = 0;
        Main myTest = new Main();

        int comnum[] = myTest.randNumGenerator();    //randNumGenerator함수로부터 랜덤 값을 받아온다
        //테스트용 출력
        for (int i = 0; i<comnum.length; i++) {
            System.out.print(comnum[i]);
        }
        while(strike < 3) {  //스트라이크 3이 안되면 반복
            int a = myTest.numReader();     //numReader로 부터 값을 입력 받음
            int usernum[] = myTest.checkNum(a);
//            for (int i = 0; i<usernum.length; i++) {
//                System.out.print(usernum[i]);
//            }
            if (usernum.length != 1){ //유저가 입력한 숫자가 제대로 된 숫자일때만 진행한다.
            int[] count = myTest.compNum(comnum, usernum);
                myTest.prtResult(count);
                System.out.println("");
            }

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
    private int[] checkNum(int number){
        int[] a = {-1};
        if(number < 0){ //입력 받은 수가 양수인지 확인한다.
            System.out.println("음수는 입력할 수 없습니다");
            return a;
        }
        //입력받은 수를 배열 형태로 바꾸어준다
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

        if (digits.length >= 4 || digits.length <= 2) {
            System.out.println("세자리 수를 입력하세요");
            return a;
        }
        return digits;
    }
    // compNum 은 사용자가 만든 숫자와 컴퓨터가 만든 숫자를 비교하여 ball 과 strike를 세는 역할을 한다.
    private int[] compNum(int[] comnum, int[] usernum){
        int[] count = {0,0};//strike, ball 카운트이다.
        for (int i = 0; i<3; i++){
            if (comnum[i] == usernum[i]){
                count[0] += 1;//strike 카운트를 하나 늘린다.
            }
            else if (usernum[i] == comnum[1] || usernum[i] == comnum[2] || usernum[i] == comnum[0]){
                count[1] +=1; //ball count를 하나 늘린다.
            }

        }
        return count;
    }
    //prtResult는 strike와 ball수를 바탕으로 낫싱 , 스트라이크, 볼을 판단하여 출력한다
    private void prtResult(int[] count){
        if(count[0] == 0 && count[1] == 0){
            System.out.println("낫싱");
        }
        if(count[0] > 0){
            System.out.print(count[0]+" 스트라이크 ");
        }
        if(count[1] > 0){
            System.out.print(count[1]+" 볼");
        }
    }
}
