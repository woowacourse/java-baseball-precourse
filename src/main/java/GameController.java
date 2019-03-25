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
