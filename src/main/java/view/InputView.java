package view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MSG = "숫자를 입력해주세요 : ";

    public static String askGuessNum(Scanner SCANNER){
        printAskNumberMsg();
        return readInputLine(SCANNER);
    }

    private static void printAskNumberMsg(){
        System.out.println(ASK_NUMBER_MSG);
    }

    private static String readInputLine(Scanner SCANNER){
        return SCANNER.nextLine();
    }
}
