package baseball;

public class Application {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        boolean quitOrnewGame = true;
        while(quitOrnewGame){
            Game game = new Game();
            game.setAnswer();
            game.start();
            quitOrnewGame = game.QuitOrNewGame();
        }
    }
}
