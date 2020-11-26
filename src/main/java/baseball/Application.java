package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    final static int LENGTH = 3;
    //입력과 예외처리.
    public static void main(String[] args) {
        //입력을 여기서 받길 원하는 거 같음.
        final Scanner scanner = new Scanner(System.in);
        boolean check = true;
        // TODO 구현 진행
        ArrayList<Integer> temp = new ArrayList<>();

        //depth가 2 이하로 만들어야하는 것.
        while(check){
            GameCycle g = new GameCycle();
            System.out.print("숫자를 입력해주세요 : ");
            g.GameStart(scanner.nextInt());
            check = false;
        }
    }
}
