import java.util.List;
import java.util.Scanner;

public class Game {

    private static final String RESTART_GAME = "1";
    private static final  String EXIT_GAME = "2";

    private Host host;
    private Client client;
    private Scanner gameScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        boolean continueGame = true;
        while (continueGame) {
            game.startOneGame();
            continueGame = game.checkContinueGame();
        }
    }

    Game() {
        host = new Host();
        client = new Client();
    }

    private void startOneGame() {
        initGame();
        boolean isFinished = false;
        while (!isFinished) {
            try {
                List<Integer> numbersFromClient = takeNumbersFromUser();
                printWithNewline(host.makeResultStatement(numbersFromClient));
                isFinished = host.matchAllNumbers(numbersFromClient);
            } catch (InvalidInputException ie) {
                printWithNewline(ie.getMessage());
            }
        }
    }

    private void initGame() {
        host.generateRandomNumbers();
    }

    private List<Integer> takeNumbersFromUser() {
        printWithoutNewline("숫자를 입력하세요: ");
        String inputFromUser = gameScanner.nextLine();
        return client.makeNumbersFromString(inputFromUser);
    }

    private boolean checkContinueGame() {
        String input;
        while (true) {
            input = gameScanner.nextLine().trim();
            if (input.equals(RESTART_GAME)) {
                return true;
            }
            if (input.equals(EXIT_GAME)) {
                return false;
            }
            printWithNewline("잘못된 값을 입력하셨습니다. 다시 입력해주세요(새로운 게임: 1, 게임 종료: 2)");
        }
    }

    private void printWithoutNewline(String message) {
        System.out.print(message);
    }

    private void printWithNewline(String message) {
        System.out.println(message);
    }

}
