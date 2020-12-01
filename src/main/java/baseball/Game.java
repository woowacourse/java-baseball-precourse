package baseball;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Game {

    private final Scanner scanner;

    private static final String playMessage = "숫자를 입력해주세요 : ";
    private static final String endMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ballMessage = "볼 ";
    private static final String strikeMessage = "스트라이크";
    private static final String outMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String nothingMessage = "낫싱";

    private static List<Integer> answer;

    private static int[] result = new int[2];


    public Game(Scanner scanner) {
        this.scanner = scanner;
    }


    // 寃뚯엫�쓣 �떆�옉�븯硫댁꽌, 留욎텧 �닽�옄瑜� �깮�꽦�븳�떎.
    public static void startGame() {
        answer = Answer.makeAnswer();
        System.out.println(answer);
        playGame();
    }

    // �닽�옄 鍮꾧탳
    // �엺�듃瑜� 怨꾩궛�븯怨� 異쒕젰
    public static void playGame() {
        int inputNumber = Player.getPlayerInput();
        System.out.print(playMessage);
        System.out.println(inputNumber);
        List<Integer> userNumber = Player.numberToArray(inputNumber);

        result = Hint.grading(userNumber, answer);
        printResult();
    }


    // playGame �쓽 寃곌낵�뿉 �뵲�씪 硫붿떆吏�瑜� 異쒕젰�븳�떎.
    public static void printResult() {
        int sum = IntStream.of(result).sum();
        if (sum == 0) {
            System.out.println(nothingMessage);
        }
        if (result[0] > 0 && result[1] > 0) {
            System.out.print(result[0]+ballMessage);
            System.out.println(result[1]+strikeMessage);
        }
        else if (result[0] > 0 && result[1] == 0) {
            System.out.println(result[0]+ballMessage);
        }
        if (result[0] == 0 && result[1] > 0) {
            System.out.println(result[1]+strikeMessage);
            if (result[1] == 3) {
                System.out.println(outMessage);
                finish();
                return;
            }
        }
        playGame();
    }

    // 寃뚯엫 醫낅즺
    // �젙�떟�씠�씪硫� �셿猷뚰븷吏� 怨꾩냽 �븷吏�瑜� 諛쏅뒗�떎.
    public static void finish() {
        System.out.println(endMessage);

        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();
        if (response == 1) {
            startGame();
        }
        scanner.close();
    }

}
