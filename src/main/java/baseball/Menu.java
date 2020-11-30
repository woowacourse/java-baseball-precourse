package baseball;

import java.util.Scanner;

public class Menu {

    /*
    * 게임을 새로시작할지, 종료할지 결정하는 클래스
    * */

    private static String stopOrGo;

    public static boolean menu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            stopOrGo = scan.nextLine().trim();

            if (stopOrGo.equals("1")) {
                return true;
            } else if(stopOrGo.equals("2")) {
                return false;
            } else {
                System.out.println("잘못 눌렀습니다. 1 또는 2를 눌러주세요.");
                continue;
            }

        }
    }
}