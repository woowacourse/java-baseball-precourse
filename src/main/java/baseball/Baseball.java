package baseball;

import java.io.IOException;
import java.util.*;

public class Baseball {
    private static final String FIRST_SELECTION = "1";
    private static final int COUNT_OF_NUMBERS = 3;
    private Scanner scan;
    private Integer[] com;

    public Baseball() {
        scan = new Scanner(System.in);
        com = new Integer[COUNT_OF_NUMBERS];

        menu();
    }

    public void menu() {
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
        generateComNumbers();
        System.out.println("게임 진행중...");
        pause();
    }

    public void generateComNumbers() {
        Set<Integer> set = new LinkedHashSet<>();

        while(set.size() != COUNT_OF_NUMBERS){
            set.add((int) (Math.random() * 9 + 1));
        }

        com = set.toArray(new Integer[set.size()]);
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
