package baseball;

import java.util.Scanner;
import interfaces.IApplication;

public class Application implements IApplication {
    private final int INPUT_RESTART = 1;
    private final int INPUT_STOP = 2;

    private static boolean isPlaying = true;

    private Computer computer;
    private Player player;
    private Hint hint;

    public Application() {
        computer = new Computer();
        player = new Player();
        hint = new Hint();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        while (isPlaying) {
            application.startGame(scanner);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            application.inputForRestart(scanner);
        }
    }

    private void inputForRestart(Scanner scanner) {
        int input = scanner.nextInt();
        if (input == INPUT_RESTART) {
            isPlaying = true;
        } else if (input == INPUT_STOP) {
            isPlaying = false;
        } else {
            throw new IllegalArgumentException("input only 1 or 2");
        }
    }

    private void startGame(Scanner scanner) {
        computer.makeRandomNumber();
        computer.getBaseballGameNumber().printAllNumbers();
        while (true) {
            player.inputThreeNumber(scanner);
            printHint();
            if (hint.isCorrectAnswer(player.getBaseballGameNumber(),
                    computer.getBaseballGameNumber())) {
                break;
            }
        }
    }

    @Override
    public void printHint() {
        String hintMessage =
                hint.getHint(player.getBaseballGameNumber(), computer.getBaseballGameNumber());
        System.out.println(hintMessage);
    }

}
