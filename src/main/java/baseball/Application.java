package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    final static int LENGTH = 3;
    //게임을 이어갈껀지만 결정하는 main
    public static void main(String[] args) {
        //입력을 여기서 받길 원하는 거 같음.
        final Scanner scanner = new Scanner(System.in);
        boolean check = false;
        // TODO 구현 진행
        ArrayList<Integer> temp = new ArrayList<>();

        //depth가 2 이하로 만들어야하는 것.
        System.out.println("값을 입력해주세요.");
        GameCycle g = new GameCycle();
        g.GameStart(scanner.nextInt());

    }
}
