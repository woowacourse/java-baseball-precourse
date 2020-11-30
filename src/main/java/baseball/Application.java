package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game baseballGame = new Game(scanner);
        Player player = new Player(scanner);

        do {
            baseballGame.play();
            checkReplayDecisionOf(player);
        } while (player.getReplayDecision() == Player.WANT_REPLAY);
    }

    private static void checkReplayDecisionOf(Player player) {
        try {
            player.checkReplayDecision();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkReplayDecisionOf(player);
        }
    }
}
