import GameMake.Baseball;

public class baseballgame {
    public static void main(String[] args) {
        int checkStrike = 0;
        Baseball game = new Baseball();

        while(true) {
            game.makeInput();
            checkStrike = game.check();
            if(checkStrike == 3){
                break;
            }
        }
    }
}
