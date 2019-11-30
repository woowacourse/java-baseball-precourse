import java.util.Scanner;

public class Host {
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final int HOLD_COUNT = 3;
    private Player player;
    private Rival rival;
    private Judgement judgement;
    private Scanner scanner;

    public Host() {
        this.player = new Player(HOLD_COUNT);
        this.rival = new Rival(HOLD_COUNT);
        this.judgement = new Judgement(HOLD_COUNT);
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("야구게임을 시작합니다.");
        rival.resetNumbers();
        player.receiveNumbers();

        while (true) {
            if (judgement.checkResult(player.getNumbers(), rival.getNumbers())) {
                System.out.println("정답입니다! 게임이 종료되었습니다.\n게임을 재시작하려면 1, 종료하려면 2를 입력해주세요.");
                askGameProgress();
            } else {
                player.receiveNumbers();
            }
        }
    }

    private void askGameProgress() {
        while (true) {
            String input = scanner.nextLine();

            if (input.equals(RESTART)) {
                startGame();
            } else if (input.equals(EXIT)) {
                endOfGame();
                break;
            } else {
                System.out.println("숫자 1 또는 2를 입력해주세요.");
            }
        }
    }

    private void endOfGame() {
        System.out.println("게임을 종료합니다. 이용해주셔서 감사합니다.");
        player.gameOver();
        scanner.close();
        System.exit(0);
    }
}
