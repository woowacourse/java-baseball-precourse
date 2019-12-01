public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame;
        do {
            baseballGame = new BaseballGame();
            baseballGame.run();
        } while (baseballGame.restart());
    }
}