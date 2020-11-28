package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static boolean CheckValue(int value) throws IllegalArgumentException{
        if(value == 1 || value == 2)
            return true;
        throw new IllegalArgumentException("값을 확인하고 입력해주세요!");
    }
    private static boolean Restart(int opinion) throws IllegalArgumentException{
        try{
            return CheckValue(opinion);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        return false;
    }
    final static int LENGTH = 3;
    //게임을 이어갈껀지만 결정하는 main
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
         int check = 1;

        //depth가 2 이하로 만들어야하는 것.
        while(check == 1) {
            try {
                GameCycle g = new GameCycle();
                g.GameStart();
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
            do {
                System.out.println("선택해 1과 2");
            } while (!Restart(check = scanner.nextInt()));
        }
    }
}
