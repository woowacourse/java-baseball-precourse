/**
 * class name : Game.class
 *
 * version : V0.1
 *
 * date : 2019.12.2
 *
 * copyright :
 *
 * description : 입력과 출력을 담당하는 Game UI
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    Scanner sc = new Scanner(System.in);
    Check check = new Check();
    Generator generator = new Generator();
    ArrayList<Integer> result = new ArrayList<Integer>();
    private boolean isEnd = false;


    public Game() {
        generator.newResult();
        result = generator.getResult();
        startGame();

    }

    public void startGame() {
        while (!isEnd) {
            String input = "";

            /*숫자 세개를 입력하는 코드 세개를 입력 못할 시 재입력을 요구한다.*/
            do {
                input = "";
                System.out.print("\n숫자를 입력해주세요 : ");

                input = sc.nextLine();

                if (input.length() != 3 ){
                    System.out.println("3개의 숫자를 입력해주세요");
                }
            } while (input.length() != 3);


            printStrikeBall(check.checkStrike(stringToArray(input), result),
                            check.checkBall(stringToArray(input), result));

            isEnd = endCondition(check.checkStrike(stringToArray(input), result));
        }

        System.out.println("게임 종료");
    }

    public ArrayList<Integer> stringToArray(String input) {
        ArrayList<Integer> output = new ArrayList<Integer>();           //String to ArrayList 결과물

        for (int i = 0; i < input.length(); i++) {
            output.add(input.charAt(i) - '0');                          //charater를 int로 전환 후 ArrayList에 삽입
        }

        return output;
    }

    public void printStrikeBall(int strike, int ball) {
        if (strike != 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball != 0) {
            System.out.print(ball + " 볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }
    }

    public boolean endCondition(int strike) {
        if (strike == 3) {
            System.out.print("\n게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요");

            if(sc.nextInt() == 1) {
                System.out.println("--------게임을 새로 시작합니다.--------");
                generator.newResult();
                result = generator.getResult();

                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


}
