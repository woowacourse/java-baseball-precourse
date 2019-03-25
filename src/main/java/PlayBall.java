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
}
