package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        BaseballGame baseballGame = new BaseballGame();
        do {
            baseballGame.gameStart();
        } while (baseballGame.decideToRestart());
    }
}
