package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String targetNumber = NumberGenerator.generate();
        getConsoleInput();
    }

    private static void getConsoleInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
    }
}
