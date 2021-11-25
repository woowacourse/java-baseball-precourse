package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameProgress {
    private static void printInputMessage(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static String inputPlayerNumber(){
        return Console.readLine();
    }

    private static void gameProgress(){
        printInputMessage();
        String inputNumber = inputPlayerNumber();
    }

    private static void GameStart(){
        gameProgress();
    }
}
