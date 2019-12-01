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

    public ArrayList makeRandomNumbers(){
        ArrayList target = new ArrayList();

        for (int i = 0; i < 3; i++) {
            int tmp = (int) (Math.random() * 9 + 1);
            while (target.contains(tmp)) {
                tmp = (int) (Math.random() * 9 + 1);
            }
            target.add(tmp);
        }
        return target;
    }

    public boolean isValidInput(String inputLine, List trial){

        if (inputLine.length() != 3) {
            return false;
        }

        try {
            Integer.parseInt(inputLine);
        } catch (Exception e) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (trial.contains(inputLine.charAt(i))) {
                return false;
            }
            trial.add(inputLine.charAt(i)-'0');
        }

        return true;
    }

    public void gameLogic() {
        Scanner scan = new Scanner(System.in);
        ArrayList target = makeRandomNumbers();
        boolean finish = false;
        while (!finish) {

            String inputLine;
            List trial = new ArrayList();

            System.out.println(" 숫자를 입력해주세요 : ");

            inputLine = scan.nextLine();

            if (!isValidInput(inputLine, trial)){
                System.out.println("유효하지 않은 입력입니다.\n");
                continue;
            }

            finish = strikeBallCheck(trial, target);
        }

        return;
    }

    public boolean strikeBallCheck(List trial, List target) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (trial.get(i) == target.get(i)) {
                strike += 1;
            }
        }

        if (strike == 3) {
            return true;  // game end
        }

        for (int i = 0; i < 3; i++) {
            if (target.contains(trial.get(i))) {
                ball += 1;
            }
        }
        ball -= strike;
        if (strike>0) {
            System.out.println(strike + "스트라이크 ");
        }
        if (ball>0) {
            System.out.println(ball + "볼");
        }
        if (strike == 0 && ball ==0){
            System.out.println("낫싱");
        }
        return false;
    }

}
