package baseball;


public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        BaseBall baseBall;
        do {
            baseBall = new BaseBall();
            baseBall.playGame();
        } while (baseBall.decideNextGame());
    }

}
