package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//스프링으로 따지면 서비스에 해당
public class Balls {

    public static final int validBallSize = 3;

    // 스트라이크, 볼 검사용
    private List<Ball> balls;

    public Balls(List<Ball> balls) {

        validBallsSize(balls);
        validOverlappedBalls(balls);
        this.balls = new ArrayList<>(balls);
    }

    public int countStrike(List<Ball> inputBalls) {

        int strikeCount = 0;

        for (int i = 0; i < inputBalls.size(); i++) {
            if (inputBalls.get(i).getBall() == balls.get(i).getBall()) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(List<Ball> inputBalls) {

        int ballCount = 0;
        for (int i = 0; i < inputBalls.size(); i++) {

            if (inputBalls.get(i).getBall() != balls.get(i).getBall()
                    && toIntegerList(inputBalls).contains(balls.get(i).getBall())) {
                //inputBalls.contains(balls.get(i).getBall())
                ballCount++;
            }

        }

        return ballCount;

    }

    // Ball 자료형 리스트를 Integer 자료형 리스트로 바꾸는 과정이 필요해서 추가함.
    // 스트라이크 체크에는 필요 없지만 볼 체크에는 이 과정이 필요
    private List<Integer> toIntegerList(List<Ball> inputBalls) {

        List<Integer> integerBalls = new ArrayList<>();

        for (int i = 0; i < inputBalls.size(); i++) {
            integerBalls.add(inputBalls.get(i).getBall());
        }

        return integerBalls;
    }

    private void validBallsSize(List<Ball> balls) {

        if (balls.size() != validBallSize) {
            throw new IllegalArgumentException("3자리수를 입력하세요");
        }
    }

    private void validOverlappedBalls(List<Ball> balls) {

        HashSet<Ball> ballSet = new HashSet<>(balls);
        //HashSet은 중복된 값을 허용하지 않으므로 사이즈로 비교 가능하다
        if (balls.size() != ballSet.size()) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력하세요");
        }
    }

}
