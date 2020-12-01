package baseball;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Game {

    private static final String playMessage = "숫자를 입력해주세요 : ";
    private static final String endMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ballMessage = "볼 ";
    private static final String strikeMessage = "스트라이크";
    private static final String outMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String nothingMessage = "낫싱";

    private static List<Integer> answer;
    private static boolean flag = false;

    private static int[] result = new int[2];

    public static void startGame(Scanner scanner) {
        answer = Answer.makeAnswer(flag);
        System.out.println(answer);
        playGame();
    }


    public static void playGame() {
        int inputNumber = Player.getPlayerInput();
        System.out.println(playMessage+inputNumber);
        List<Integer> userNumber = Player.numberToArray(inputNumber);

        result = Hint.grading(userNumber, answer);
        printResult();
    }


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


    public static void finish() {
        System.out.println(endMessage);

        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();
        if (response == 1) {
        	flag = true;
            startGame(scanner);
        }
        scanner.close();
    }

}
