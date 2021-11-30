package baseball.hint;

import baseball.pitch.Pitch;

import java.util.Set;

public class Hint {
    private int strike;
    private int ball;

    // 두 Pitcher 집합을 비교하며 strike 와 ball을 구하여
    // Hint 객체를 구성한다.
    public Hint(Set<Pitch> computerSet, Set<Pitch> playerSet) {
        for(Pitch pitch : computerSet) {
            strike += validStrike(pitch, playerSet);
            ball += validBall(pitch, playerSet);
        }
    }

    // for test case
    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    // Computer의 한 Pitch 와 Player의 Pitch들을 비교하면서
    // 스트라이크가 있다면 1을 반환 (1을 더할 것이다.)
    private int validStrike(Pitch pitch, Set<Pitch> playerSet) {
        // match 하는거 확인
        if(playerSet.stream().anyMatch(p -> p.isStrike(pitch))) {
            return 1;
        }
        return 0;
    }

    // Computer의 한 Pitch와 Player의 Pitch들을 비교하면서
    // 볼이 있다면 1을 반환 (1을 더할 것이다.)
    private int validBall(Pitch pitch, Set<Pitch> playerSet) {
        if(playerSet.stream().anyMatch(p-> p.isBall(pitch)))
            return 1;
        return 0;
    }

    // 사용자의 모든 Pitch가 Nothing이어야지 해당 숫자는 nothing 이다.
    private boolean validNothing(Pitch pitch, Set<Pitch> playerSet) {
        return playerSet.stream().allMatch(p -> p.isNothing(pitch));
    }

    // for test, 테스트 중에ㅔ 두 힌트가 같은지 판별하기 위해 추가한 메서드
    public boolean isSame(Hint target) {
        if(strike == target.strike && ball == target.ball)
            return true;
        return false;
    }

    public boolean isEnd() {
        if(strike == 3)
            return true;
        return false;
    }

    // ball이 있는지 확인
    public boolean hasBall() {
        return ball > 0;
    }
    // strike가 있는지 확인
    public boolean hasStrike() {
        return strike > 0;
    }
    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
