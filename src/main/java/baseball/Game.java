package baseball;

import java.util.Scanner;

public class Game {
    public static void gameStart(int tartgetValue, Scanner scanner){
        boolean flag = false;
        do{
            int input = valueInsert(scanner);
            if (checking(tartgetValue, input)) {
                flag = gameContinue();
            } else {
                hint(tartgetValue);
            }
        } while(!flag);
    }

    private static boolean checking(int tartgetValue, int input) {
        return tartgetValue == input;
    }

    private static int valueInsert(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }
}
