package baseball.view;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class InputView {
    private static final String NUMBER_REQUIRE_MSG = "숫자를 입력해 주세요 : ";
    private static final String NUMBER_REQUIRE_MSG_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printResult(boolean isGaming){
        if(isGaming){
            System.out.print(NUMBER_REQUIRE_MSG);
        }else{
            System.out.println(NUMBER_REQUIRE_MSG_END);
        }
    }
}
