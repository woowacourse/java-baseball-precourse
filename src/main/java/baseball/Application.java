package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Player player= new Player(scanner);

        do {
            checkReplayDecisionOf(player);
        } while(player.getReplayDecision() == Player.WANT_REPLAY);
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
