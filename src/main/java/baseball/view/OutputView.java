package baseball.view;

import java.util.ArrayList;

public class OutputView {
    public final String STRIKE_MESSAGE = "스트라이크";
    public final String BALL_MESSAGE = "볼";
    public final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final int STRIKE = 3;
    public final int ZERO = 0;
    private ArrayList<String> randomNumber;
    private int strikePoint;
    private int ballPoint;

    public OutputView(int strikePoint, int ballPoint, ArrayList<String> randomNumber) {
        this.strikePoint = strikePoint;
        this.ballPoint = ballPoint;
        this.randomNumber = randomNumber;
    }

    public String display() {
        if (strikePoint == ZERO && ballPoint == ZERO) {
            return zeroPoint();
        }

        if (strikePoint == STRIKE) {
            return STRIKE + STRIKE_MESSAGE + System.lineSeparator() + ANSWER_MESSAGE;
        }

        if (strikePoint != ZERO && ballPoint != ZERO) {
            return ballPoint + BALL_MESSAGE + " " + strikePoint + STRIKE_MESSAGE;
        }

        if (strikePoint != ZERO) {
            return strikePoint + STRIKE_MESSAGE;
        } else {
            return ballPoint + BALL_MESSAGE;
        }
    }

    //같은 수가 없으면 포볼 또는 낫싱 ➔ 정답이 짝수인 경우 낫싱 / 홀수인 경우 포볼 출력
    public String zeroPoint() {
        String[] zeroMessage = {"포볼", "낫싱"};
        int random = Integer.parseInt(randomNumber.get(randomNumber.size()-1));
        int selectMessage = random % 2;
        return zeroMessage[selectMessage];
    }
}
