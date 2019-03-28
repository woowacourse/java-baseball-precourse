/*
 *  java_baseball.java
 *
 *  ver 1.0.5
 *
 *  2019/03/28
 *
 */

import java.util.Scanner;

public class java_baseball {
    public static void main(String[] args) {
        Number comNum = new Number();
        int[] userNum = new int[3];
        Judge judge = new Judge();


        int input;
        Scanner sc = new Scanner(System.in);

        comNum.setNumber();

        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            input = sc.nextInt();
            separateNum(userNum, input);
            judge.clear();

            judge.count(userNum, comNum.number);
            judge.printResult();

            if (judge.strike == 3){
                System.out.println("3개의 숫자를 모두 맞히쳤습니다! 게임종료");
                break;
            }
        }

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
