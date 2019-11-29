import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    public static void main(String[] args) {
        Batter computer = new Batter();
        Pitcher user;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        user = new Pitcher(n);

        computer.printBatting();
        user.printPitching();

    }
}
