/**
 * @author JiHoon Kim
 * @version 1.0
 */

/**
 * 게임 객체를 선언, 시작, 종료, 재시작하는 메인 클래스
 */
public class GameController {
    public static void main(String[] args) {
        boolean flag = true;

        BaseballGame game = new BaseballGame();
        game.init();

        while (flag) {
            game.start();
            flag = game.reset();
        }

        game.close();
    }
}
