package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        boolean isContinue;
        do {
            PlayBall.play(BaseBallUtil.generateThreeRandomDigits());

            System.out.println("end game");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if (BaseBallUtil.isValidateChoice(input)) isContinue = setIsContinue(input);
            else throw new IllegalArgumentException("잘못된 입력입니다.");

        } while (isContinue);

    }

    private static boolean setIsContinue(String input) {
        return input.equals("1");
    }
}
