package baseball;

import java.util.Scanner;

public class GameRestarter {
    private static final String REGAME_TEXT="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static void replayGame(Scanner scanner){
        System.out.println(REGAME_TEXT);
        String userSelection = scanner.nextLine();
        if (userSelection.equals("1")){
            GamePlayer.playGame(scanner);
        } else if (!userSelection.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
