package edu.freecourse.view;

import edu.freecourse.tool.Computer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {

    private  static Computer computer = new Computer();
    private  static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {

        /*게임을 종료하면 벗어남*/
        while (true) {
            computer.newGame();

            boolean flag = true;

            /* 사용자가 정답을 맞출 때 벗어남*/
            while (flag) {
                flag = playGame();
            }

            boolean reGame = isReGame();

            if(!reGame){
                sc.close();
                break;
            }

        }

    }

    /**
     * 사용자의 입력을 받아서 게임의 시작유무를 판별하는 함수
     * 1 : 새로운 게임, 2 : 종료, 그외 잘못된 입력 다시 입력
     * @return false : 종료, true : 새 게임
     */
    private static boolean isReGame () {
        boolean result = true;

        while (true) {

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int userNum = inputUserNum();

            if (userNum == 2) {
                result = false;
                break;
            } else if (userNum == 1) {
                result = true;
                break;
            } else {
                System.out.println("다시 입력해주세요.");
            }

        }

        return result;
    }

    /**
     * 사용자의 입력을 받아서 게임의 결과를 출력하는 함수
     * @return  false : 3스트라이크, 그 외 true
     */
    private static boolean playGame () {
        boolean flag = true;

        try {
            System.out.print("숫자를 입력해주세요 : ");
            int userNum = inputUserNum();

            int[] result = computer.answerResult(userNum);
            int strike = result[0];
            int ball = result[1];

            showResult(strike, ball);

            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                flag = false;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
    }

    /**
     * 사용자의 입력에 따른 게임의 결과를 보여주는 함수
     * @param strike 스트라이크 개수
     * @param ball 볼 개수
     */
    private static void showResult(int strike, int ball){

        if ((strike == 0) && (ball == 0)) {
            System.out.print("아웃");
        }

        if (strike != 0) {
            System.out.print(strike + "스트라이크 ");
        }

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        System.out.println();
    }

    /**
     * 사용자가 숫자 이외의 문자를 입력했을 경우를 처리하는 함수
     * @return 0 : 숫자가 아닌입력, 그 외 사용자가 입력한 숫자
     */
    private static int inputUserNum() {
        int result;

        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다.");
            sc.nextLine();
            result = 0;
        }

        return result;
    }
}
