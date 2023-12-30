package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        do {
            Game game = new Game();
            game.playGame();
        } while ( checkPlay() );
    }

    public static boolean checkPlay() {
        int retryGame = new Game().retryGame();

        if(retryGame == 1){
            return true;
        }
        return false;
    }
}
