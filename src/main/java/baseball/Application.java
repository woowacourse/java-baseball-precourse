package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        boolean flag = true;
        do {
            game.gameStart();
            flag = startNewGame();
        } while(flag);
    }

    private static boolean startNewGame() {
        System.out.println(Message.RESTART_MESSAGE);
        String answer = Console.readLine();

        if (answer.length() > 1) {
            throw new IllegalArgumentException(Message.INPUT_ERROR_INVALID_INPUT);
        }

        if (answer.charAt(0) != '1' || answer.charAt(0) != '0') {
            throw new IllegalArgumentException(Message.INPUT_ERROR_INVALID_INPUT);
        }

        if (answer.charAt(0) == '1') {
            return true;
        }
        return false;
    }
}
