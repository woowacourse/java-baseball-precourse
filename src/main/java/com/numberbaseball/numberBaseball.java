package com.numberbaseball;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * numberbasball
 * @version 0.0.1
 * @since 2019-07-11
 * @author hyochan
 */

public class numberBaseball {
    public static void main(String[] args) {
        numberBaseball nb = new numberBaseball();
        nb.game();
    }

    public void game() {

        Scanner scan = new Scanner(System.in);
        boolean finish = false;

        while(true){
            if (!finish) {
                gameLogic();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                finish = true;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            String inputLine;
            inputLine = scan.nextLine();

            if (inputLine.equals("1")){
                finish = false;
                continue;
            } else if (inputLine.equals("2")){
                break;
            } else {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }
        }
        return;
    }

}
