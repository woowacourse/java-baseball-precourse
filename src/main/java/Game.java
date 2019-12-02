/*
 * Game
 *
 * ver 1.0
 *
 * 2019.11.30
 *
 * CopyRight
 *
 */

import java.util.Scanner;

public class Game {
    /*
     * 게임을 실행시키는 클래스 입니다.
     * 게임 실행, 재시작, 출력, 검사 기능을 함수화 시켰습니다.
     */
    public static void start(){ // 게임을 실행시키는 함수 입니다.
        int answer;
        int correct = Random.create();
        int result = 0;
        Scanner scan = new Scanner(System.in);
        while(result == 0){
            System.out.println("숫자를입력해주세요:");
            answer = scan.nextInt();
            result = compare(answer, correct);
            if(result == 1){
                correct = Random.create();
                result = 0;
            }
        }
    }

    public static int compare(int answer, int correct){ // 정답을 검사하는 함수입니다.
        int strike = Strike.calculateStrike(answer, correct);
        int ball = Ball.calculateBall(answer, correct);
        printResult(strike, ball);
        if(strike == 3){
            return restart();
        }else{
            return 0;
        }
    }

    public static int restart(){ // 게임을 재시작하는 함수입니다.
        int answer;
        System.out.println("3개의숫자를모두맞히셨습니다!게임종료");
        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요. ");
        Scanner scan = new Scanner(System.in);
        answer = scan.nextInt();
        if(answer == 1){
            return 1;
        }else{
            return 2;
        }
    }

    public static void printResult(int strike, int ball){ // 결과를 출력하는 함수입니다.
        int nothing = strike + ball;
        if(nothing == 0){
            System.out.print("낫싱 ");
        }
        if(strike != 0){
            System.out.print(strike + "스트라이크 ");
        }
        if(ball != 0){
            System.out.print(ball + "볼 ");
        }
        System.out.print("\n");
    }

}
