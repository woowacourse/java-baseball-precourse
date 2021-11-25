package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();

        while (true) {
            boolean isFinish = game.play();
            if (isFinish) {
                game.printEndMessage();
                String input = Console.readLine();
                if (input.equals("2")) {
                    break;
                }
                game.init();
            }
        }
    }
}
