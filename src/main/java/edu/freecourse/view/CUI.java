package edu.freecourse.view;

import edu.freecourse.tool.Computer;

import java.util.Scanner;

public class CUI {

    private  static Computer computer = new Computer();
    private  static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {

        while (true) {
            computer.newGame();
            boolean flag = true;

            while (flag) {
                flag = playGame();
            }

            boolean reGame = isReGame();

            if(!reGame){
                break;
            }

        }

    }

    /**
     * 사용자의 입력을 받아서 게임의 시작유무를 판별하는 함수
     * 1 : 새로운 게임, 2 : 종료, 그외 잘못된 입력 다시 입력
     * @return
     */
    public static boolean isReGame () {
        boolean result = true;

        while (true) {

            System.out.println("게임을 새로 시작하려면 1, 종료할려면 2를 입력하세요.");

            int userNum = sc.nextInt();

            if (userNum == 2) {
                result = false;
                break;
            }else if (userNum == 1) {
                result = true;
                break;
            }else {
                System.out.println("다시 입력해주세요.");
            }

        }

        return result;
    }

    /**
     * 사용자의 입력을 받아서 결과를 출력하는 함수
     * @return  false : 3스트라이크, 그 외 true
     */
    public static boolean playGame (){
        boolean flag = true;

        System.out.print("숫자를 입력해주세요 : ");
        int userNum = sc.nextInt();
        int[] result = computer.answerResult(userNum);

        if (result[0] == 3) {
            flag = false;

            System.out.println(result[0] + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else {
            if (result[0] == 0 && result[1] == 0) {
                System.out.print("아웃");
            }
            if (result[0] != 0) {
                System.out.print(result[0] + "스트라이크 ");
            }
            if (result[1] != 0) {
                System.out.print(result[1] + "볼 ");
            }
            System.out.println();
        }

        return flag;
    }

}
