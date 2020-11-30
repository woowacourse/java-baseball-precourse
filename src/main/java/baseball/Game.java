package baseball;

import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class Game {

    private static final String playMessage = "숫자를 입력해주세요 : ";
    private static final String endMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ballMessage = "볼";
    private static final String strikeMessage = "스트라이크";
    private static final String outMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String nothingMessage = "낫싱";

    private List<Integer> userNumber;
    private List<Integer> answer;

    // 게임을 시작하면서, 맞출 숫자를 생성한다.
    public void startGame() {
        this.answer = Answer.makeAnswer();
    }

    // 숫자 비교
    // 힌트를 계산하고 출력하는 부분
    public void playGame() {
        int inputNumber = Player.getPlayerInput();
        System.out.println(playMessage + inputNumber);

        this.userNumber = Player.numberToArray(inputNumber);

        // 이 부분에서 계산할 것.
    }

    // 게임 종료
    // 정답이라면 완료할지 계속 할지를 받는다.
    public void finish() {
        System.out.println(endMessage);

        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();
        if (response == 1) {
            playGame();
        }
    }

}
