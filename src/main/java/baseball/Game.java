package baseball;

import java.util.Scanner;

public class Game {
    public static void gameStart(int tartgetValue, Scanner scanner){
        int input = valueInsert(scanner);
    }

    private static int valueInsert(Scanner scanner) {
        System.out.println("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }
}
