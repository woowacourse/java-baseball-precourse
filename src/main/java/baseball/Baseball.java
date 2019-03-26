package baseball;

import java.io.IOException;
import java.util.Scanner;

public class Baseball {
    private static final String FIRST_SELECTION = "1";
    private Scanner scan;

    public Baseball() {
        scan = new Scanner(System.in);
        String sel = FIRST_SELECTION;

        Loop: while (true) {
            switch (sel) {
            case "1":
                startGame();
                break;
            case "2":
                System.out.println("프로그램이 종료됩니다.");
                pause();
                break Loop;
            default:
                System.out.println("잘못 입력하셨습니다.");
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            sel = scan.next();
        }
    }

    public void startGame() {
        System.out.println("게임 진행중...");
        pause();
    }

    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Baseball();
    }
}
