package baseball;

import java.util.Scanner;

public class Game {
    public static void gameStart(int tartgetValue, Scanner scanner){
        boolean flag = false;
        do{
            int input = valueInsert(scanner);
            if (checking(tartgetValue)) {
                flag = gameContinue();
            } else {
                hint(tartgetValue);
            }
        } while(!flag);
    }

    private static int valueInsert(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }
}
