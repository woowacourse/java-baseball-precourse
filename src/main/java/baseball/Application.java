package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.SystemMessage;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        do {
            BaseBall baseBall = new BaseBall();
            baseBall.playGame();
        } while (decideNextGame());
    }

    private static boolean decideNextGame() {
        System.out.println(SystemMessage.ENTER_NEXT_GAME_MESSAGE);
        int next_game = isValidInput(Console.readLine());
        if (next_game == SystemMessage.REPEAT) return true;
        return false;
    }

    private static int isValidInput(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) throw new IllegalArgumentException(SystemMessage.NO_NUMBER_ERROR);
        }
        int value = Integer.parseInt(input);
        if (value != SystemMessage.REPEAT && value != SystemMessage.STOP)
            throw new IllegalArgumentException(SystemMessage.INVALID_NUMBER);
        return Integer.parseInt(input);
    }

}
