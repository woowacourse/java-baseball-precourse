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
}
