package view;

import number.Constant;

import java.util.Scanner;

public class OutputView {

    OutputView(){

    }

    public static void showInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static int showHint(int strike, int ball) {

        if(strike == 0 && ball == 0){
            threeBall();
            return Constant.START;
        }else if(strike == 3){
            threeStrike();
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }else{
            makeHint(strike, ball);

            return Constant.START;
        }
    }

    public static void makeHint(int strike, int ball){
        if(strike == 0){
            System.out.printf("%d 볼\n", ball);
        }else if(ball == 0){
            System.out.printf("%d 스트라이크\n", strike);
        }else{
            System.out.printf("%d 볼 %d 스트라이크\n", ball, strike);
        }

    }

    public static void threeBall(){
        System.out.println("낫싱");
    }

    public static void threeStrike(){
        System.out.println("3 스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
