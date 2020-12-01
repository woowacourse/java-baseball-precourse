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
    
    static int playerNumber;

    
    // 게임을 시작. 먼저 숫자 야구의 정답을 생성한다.
    public static void startGame(Scanner scanner) {
        answer = Answer.makeAnswer(flag);
        System.out.println(answer);
        playGame();
    }

    
    // 플레이어의 숫자 입력을 받아 출력한다.
    public static void setPlayer() {
    	int playerNumber = Player.getPlayerInput();
    	System.out.println(playMessage+playerNumber);
    }
    
    
    // 입력을 리스트로 만들어 Hint와 비교, 점수를 매긴다.
    public static void playGame() {
        List<Integer> numberToList = Player.numberToArray(playerNumber);

        result = Hint.grading(numberToList, answer);
        printResult();
    }

    
    // 점수를 출력한다.
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

    
    // 3스트라이크일 때 게임을 끝낸다.
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
