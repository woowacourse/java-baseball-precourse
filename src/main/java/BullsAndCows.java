
public class BullsAndCows {
    public static void main(String[] args) {
        final int digit = 3;
        SingleGame aGame;

        do {
            aGame = new SingleGame();
        } while (aGame.startGame(digit));
    }
}
