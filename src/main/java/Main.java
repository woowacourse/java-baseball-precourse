import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame game = new BaseballGame();
        String replay = "";

        do {
            game.start(sc);
            replay = game.askReplay(sc);
        } while (replay.equals("1"));
    }
}
