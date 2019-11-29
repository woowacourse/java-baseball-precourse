public class baseballGame {

    public static void main(String[] args) {
        gameMc game = new gameMc();
        do{
            game.setUserNum();
            game.compare();
            game.result();
        }
        while(game.checkStatus() != 2);

    }
}