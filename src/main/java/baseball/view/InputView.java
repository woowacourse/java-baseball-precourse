package baseball.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static void setScanner(Scanner scanner){
        InputView.scanner = scanner;
    }

    public static String getNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine().replaceAll("\\s+", "");
        if (userInput.equals("")){
            System.out.println("값을 입력해주세요");
            getNumbers();
        }
        return userInput;
    }

}
