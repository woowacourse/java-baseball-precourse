package baseball.view;

import baseball.result.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    //사용자 숫자 입력 화면
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return userInput;
    }

    //결과에 저장되어있는 결과 메세지 출력
    public static void printResultMessage(GameResult result) {
        System.out.println(result.getResultMessage());
    }

//    public static void printGameOverView() {
//        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
//                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//    }
//
//    private static String getUserRepeatInput() {
//        return Console.readLine();
//    }
}
