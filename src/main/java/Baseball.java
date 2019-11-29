import java.util.Scanner;

public class Baseball {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int NEW_GAME = Constants.NEW_GAME;
    private static final int PROGRAM_EXIT = Constants.PROGRAM_EXIT;
    private static final Scanner SCANNER = new Scanner(System.in);

    private boolean isRunning = true;

    private static int[] inputNumbers() {
        try {
            System.out.print(INPUT_NUMBERS_MESSAGE);
            return User.readNumbers(SCANNER.next());
        } catch (Exception e) {
            return inputNumbers();
        }
    }

    private static int inputMenu() {
        try {
            System.out.println(INPUT_MENU_MESSAGE);
            return User.readMenu(SCANNER.nextInt());
        } catch (Exception e) {
            return inputMenu();
        }
    }

    private void gameLoop() {
        int[] computer = Computer.createNumbers();

        while (true) {
            int[] user = inputNumbers();
            Result result = Computer.compute(user, computer);
            System.out.println(result);
            if (result.allMatch()) {
                System.out.println(CORRECT_MESSAGE);
                break;
            }
        }

        switch (inputMenu()) {
        case NEW_GAME:
            break;
        case PROGRAM_EXIT:
            isRunning = false;
            break;
        default:
            break;
        }
    }

    public void run() {
        while (isRunning) {
            gameLoop();
        }
    }

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.run();
    }
}
