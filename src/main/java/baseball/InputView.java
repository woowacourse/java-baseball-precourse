package baseball;

import java.util.Scanner;

public class InputView {

    private static final String NUMBER_INPUT_TEXT="숫자를 입력해주세요 : ";

    private static final String GAME_START_OR_EXIT_TEXT="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    private static final Scanner scanner=new Scanner(System.in);

    public static String getUserString(){
        System.out.print(NUMBER_INPUT_TEXT);
        return scanner.nextLine();
    }

    public static String getNewGameOrExit(){
        System.out.println(GAME_START_OR_EXIT_TEXT);
        return scanner.nextLine();
    }
}
