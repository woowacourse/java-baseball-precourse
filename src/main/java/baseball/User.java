package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String input;

    // 사용자에게 3자리의 수(문자열 형태)로 리턴하는 메소드
    public static String inputNumber() {

        input = Console.readLine();


        if(input.length() != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
        return input;
    }


}
