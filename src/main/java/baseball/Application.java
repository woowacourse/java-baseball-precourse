package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Player player= new Player(scanner);

        do {
            player.checkReplayDecision();
        } while(player.getReplayDecision() == Player.WANT_REPLAY);
    }
}
