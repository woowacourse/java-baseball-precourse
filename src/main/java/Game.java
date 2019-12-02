import java.util.List;
import java.util.Scanner;

public class Game {

    private static final String RESTART_GAME = "1";
    private static final String EXIT_GAME = "2";
    private static final int COUNT_SHOULD_BE_MATCHED = 3;

    private Host host;
    private Client client;
    private Scanner gameScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        boolean continueGame = true;

        game.printIntroStatement();
        while (continueGame) {
            game.startOneGame();
            game.printEndStatement();
            continueGame = game.checkContinueGame();
        }
    }

    private Game() {
        host = new Host();
        client = new Client();
    }


    private void startOneGame() {
        boolean isFinished = false;

        initGame();
        while (!isFinished) {
            try {
                List<Integer> numbersFromClient = takeNumbersFromUser();
                isFinished = host.matchAllNumbers(numbersFromClient);
                System.out.println(host.makeResultStatement(numbersFromClient));
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private void initGame() {
        host.generateRandomNumbers();
    }

    private List<Integer> takeNumbersFromUser() {
        System.out.print("숫자를 입력하세요: ");
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
            System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요(새로운 게임: 1, 게임 종료: 2)");
        }
    }

    private void printIntroStatement() {
        String introStatement = "안녕하세요. 숫자야구게임에 오신 것을 환영합니다.\n" +
                "숫자야구게임은 컴퓨터가 생성한 임의의 숫자 " + COUNT_SHOULD_BE_MATCHED + "개의 값과 자리를 맞추는 게임입니다.\n" +
                "값과 자리가 모두 맞을 경우 스트라이크, 값만 맞을 경우 볼입니다.\n" +
                COUNT_SHOULD_BE_MATCHED + "스트라이크가 될 경우 사용자의 승리로 게임이 끝납니다.\n" +
                "그럼 게임을 시작하겠습니다.\n";
        System.out.println(introStatement);
    }

    private void printEndStatement() {
        System.out.println(COUNT_SHOULD_BE_MATCHED + "개의 숫자를 모두 맞추셨습니다. 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
    }
}
