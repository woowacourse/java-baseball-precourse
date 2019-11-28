import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    public static void main(String[] args) {
        Batter a = new Batter();
        Pitcher b = new Pitcher();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        b.setPitching(n);
        b.printPitching();
        a.printBatting();
    }
}
