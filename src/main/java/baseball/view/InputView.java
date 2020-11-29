package baseball.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static void setScanner(Scanner scanner){
        InputView.scanner = scanner;
    }

    public static String getNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = deleteWhiteSpaces(scanner.nextLine());
        if (userInput.equals("")){
            System.out.println("값을 입력해주세요");
            getNumbers();
        }
        return userInput;
    }

    public static String getRestartChoice(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = deleteWhiteSpaces(scanner.nextLine());
        if (userInput.equals("")){
            System.out.println("값을 입력해주세요");
            getRestartChoice();
        }
        return userInput;
    }

    private static String deleteWhiteSpaces(String string){
        return string.replaceAll("\\s+", "");
    }
}
