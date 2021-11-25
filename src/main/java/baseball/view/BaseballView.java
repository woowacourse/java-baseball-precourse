package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    //사용자 숫자 입력 화면
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return userInput;
    }

}
