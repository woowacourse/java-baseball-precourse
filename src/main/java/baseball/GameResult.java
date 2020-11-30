package baseball;

/**
 * 게임 결과를 관리 하기위한 Class
 * 
 * @author junroot
 *
 */
public class GameResult {
    private int strike;
    private int ball;

    /**
     * GameResult가 생성되면 strike와 ball이 각각 0으로 설정됩니다.
     */
    public GameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    /**
     * 입력받은 값대로 strike와 ball을 가진 GameResult를 생성합니다.
     * 
     * @param strike 설정하고자 하는 strike입니다.
     * @param ball 설정하고자 하는 ball입니다.
     */
    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    /**
     * strike와 ball로부터 스코어를 출력합니다.
     */
    public void printResult() {
        if ((this.strike != 0) && (this.ball != 0)) {
            System.out.printf("%d볼 %d스트라이크\n", this.ball, this.strike);
        } else if (this.ball > 0) {
            System.out.printf("%d볼\n", this.ball);
        } else if (this.strike > 0) {
            System.out.printf("%d스트라이크\n", this.strike);
        } else {
            System.out.println("낫싱");
        }
    }

    /**
     * strike값을 1증가 시킵니다.
     */
    public void increaseStrike() {
        strike++;
    }

    /**
     * ball값을 1증가 시킵니다.
     */
    public void increaseBall() {
        ball++;
    }

    /**
     * 현재 strike 값을 반환합니다.
     * 
     * @return 현재 stirke입니다.
     */
    public int getStrike() {
        return this.strike;
    }

    /**
     * 현재 ball 값을 반환합니다.
     * 
     * @return 현재 ball입니다.
     */
    public int getBall() {
        return this.ball;
    }
}
