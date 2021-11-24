package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {


    }

    static void verifyInput(String input) {

        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
        }
    }
}
