/*
 *  java_baseball.java
 *
 *  ver 1.0.2
 *
 *  2019/03/28
 *
 */

import java.util.Scanner;

public class java_baseball {
    public static void main(String[] args) {
        Number comNum = new Number();
        int[] userNum = new int[3];
        int input;
        Scanner sc = new Scanner(System.in);

        comNum.setNumber();

        System.out.print("숫자를 입력하세요 : ");
        input = sc.nextInt();
        separateNum(userNum, input);
    }

    public static void separateNum(int[] userNum, int input){
        int index = 0;
        while (input > 0){
            userNum[index] = input % 10;
            index++;
            input /= 10;
        }
    }
}
