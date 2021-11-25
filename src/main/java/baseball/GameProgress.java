package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameProgress {
    private static void printInputMessage(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static String inputPlayerNumber(){
        return Console.readLine();
    }

    private static int inputAnswerNumber(){
        return Randoms.pickNumberInRange(0,3);
    }

    private static void gameProgress(){
        int answer = inputAnswerNumber();
        printInputMessage();
        String inputNumber = inputPlayerNumber();
    }

    private static void GameStart(){
        gameProgress();
    }
}
