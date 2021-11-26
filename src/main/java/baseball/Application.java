package baseball;

/**
 * 숫자 야구 진행을 총괄하는 메인 클래스
 */
public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        do {
            game.playBaseball();
        } while (game.askRestart());
    }
}
