package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String input;

    // 사용자에게 3자리의 수(문자열 형태)로 리턴하는 메소드
    public static String inputNumber() {

        input = Console.readLine();

        // 유저 입력에 0이 포함된 경우
        if(input.contains("0")) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        // 유저 입력이 3자리가 아닌 경우
        if(input.length() != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        // 유저 입력에 문자가 포함된 경우
        for(int i=0; i<3; i++) {
            checkNumeric(input.charAt(i));
        }

        return input;
    }

    public static void checkNumeric(char c) {
        if(Character.isDigit(c)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }


}
