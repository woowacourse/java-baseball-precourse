package baseball;

public class Application {

    public static void main(String[] args){
        BaseballGame game;

        do {
            // 게임 개체 생성
            game = new BaseballGame();

            // 게임 시작
            game.play();
        } while (game.getRestart());
    }

}
