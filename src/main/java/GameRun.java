import java.util.Scanner;

/*
 * ClassName : GameRun
 * ClassExplanation : 게임 실행 및 재실행 여부 설정
 * author : Kim SeYun
 * Date : 2019. 12. 02
 * Copyright (c) 2019 SeYun Kim
 */
public class GameRun {
    static boolean isGame = true;
    Computer computer = new Computer();

    public void run() {
        while (isGame) {
            User user = new User();
            GameCheck gameCheck = new GameCheck(computer.computerAnswer, user.userNumber);

            if (gameCheck.strike != 0) {
                System.out.print(gameCheck.strike + " 스트라이크 ");
            }

            if (gameCheck.ball != 0) {
                System.out.print(gameCheck.ball + " 볼");
            }

            if (gameCheck.ball == 0 && gameCheck.strike == 0) {
                System.out.print("낫싱");
            }

            System.out.println();                                       // 줄바꿈 설정

            if (gameCheck.strike == 3) {
                this.reRun();
            }
        }
    }

    void reRun() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("게임을 더 하시려면 1을 입력해주시고, 게임을 종료하실려면 2을 입력해주세요.");
            int input = sc.nextInt();

            if (input == 1) {
                computer = new Computer();
                isGame = true;
                break;
            } else if (input == 2) {
                isGame = false;
                break;
            } else {
                continue;
            }
        }
    }
}