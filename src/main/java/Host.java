import java.util.Scanner;

public class Host {
    private static final int HOLD_COUNT = 3;
    private Rival rival;
    private Player player;
    private Scanner scanner;

    public Host() {
        this.rival = new Rival(HOLD_COUNT);
        this.player = new Player(HOLD_COUNT);
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("야구게임을 시작합니다.");
    }

    private void startGame() {
        rival.resetNumbers();
        player.receiveNumbers();
    }

    private void endOfGame() {
        player.gameOver();
        scanner.close();
    }
}
