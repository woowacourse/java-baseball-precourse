package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        while(true) {
        	baseball.playGame();
        	if(!baseball.isUserWantRestart()) {
        		break;
        	}
        }
    }
}
