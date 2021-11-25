package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();

        while (true) {
            boolean isFinish = game.play();
            if (isFinish) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();
                if (input.equals("2")) {
                    break;
                }
                game.init();
            }
        }
    }
}
