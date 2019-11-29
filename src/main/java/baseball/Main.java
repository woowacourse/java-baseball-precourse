/**
 * 우아한 테크코스 1주차 - 숫자 야구
 * 메인 클래스
 *
 * @version         0.1
 * @author          황성찬
 */
package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        CreateList userYou = new CreateList();
        CreateList userComputer = new CreateList();

        int restart;
        int RESTART = 1;
        int EXIT = 2;

        Scanner sc = new Scanner(System.in);


        do {
            PlayBall.run(userYou, userComputer);

            System.out.println("게임이 종료되었습니다. 1. 다시하기 2. 종료하기");
            restart = sc.nextInt();
        }while(restart == RESTART);


    }
}
