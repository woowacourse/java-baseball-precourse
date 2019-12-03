import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String replay = "";

        do {
            BaseballGame.start(sc);
            replay = BaseballGame.askReplay(sc);
        } while (replay.equals("1"));
    }
}
