package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        boolean isContinue;
        do {
            PlayBall.play(BaseBallUtil.generateThreeRandomDigits());

            System.out.println(SystemMessage.GAME_END_MESSAGE);
            System.out.println(SystemMessage.RESTART_SELECT_MESSAGE);
            String input = Console.readLine();

            if (BaseBallUtil.isValidateChoice(input)) isContinue = setIsContinue(input);
            else throw new IllegalArgumentException(SystemMessage.WRONG_INPUT_MESSAGE);

        } while (isContinue);

    }

    private static boolean setIsContinue(String input) {
        return input.equals("1");
    }
}
