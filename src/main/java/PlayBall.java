/*
 * PlayBall은 콘솔 in-out으로 유저와 상호작용한다.
 * 상호작용의 근거는 BaseBall클래스에서 가져온다.
 */
import java.util.Scanner;

public class PlayBall {
    private int isContinue;     // 게임 지속여부 판단 기준. 1이면 continue, 2이면 종료.

    /**
     * 심플 생성자. isContinue를 1로 초기화한다.
     */
    PlayBall() {
        isContinue = 1;
    }

    /**
     * Main의 메인 메서드의 진입점
     */

    void playGame() {
        while (isContinue == 1) {
            playOneGame();
        }
    }

    /**
     * 야구게임 한판을 실행한다.
     */

    void playOneGame() {
        int strike = 0;
        int gameNumber;

        BaseBall bs = new BaseBall();
        gameNumber = bs.getGameNumber();

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = getInputConsole();

            if (!bs.isValid(input)) {
                printInvalidArgMessage();
                continue;
            }

            Scores scores = bs.getReferee(gameNumber,input);
            strike = scores.getStrike();
            System.out.println(scores.getScore());

        } while (strike != 3);

        printVictory();
        wantContinue();
    }

    /**
     * 사용자가 콘솔에 입력한 값을 가져온다.
     * @return string, 콘솔 입력값
     */
    String getInputConsole() {
        String result;
        Scanner sc = new Scanner(System.in);
        result = sc.nextLine();
        return result;
    }

    /**
     * 사용자가 콘솔에 입력한 값이 적절치 않을 경우, 사용자에게 알리고 재시도를 유도한다.
     */

    void printInvalidArgMessage() {
        System.out.println("유효한 입력이 아닙니다. 다시 입력해 주세요.");
    }

}
