package Baseball;

import java.security.InvalidParameterException;
import java.util.List;

public class NumberReferee implements Referee {
    @Override
    public Result judge(List<Integer> ballsPitched, List<Integer> ballsHit) {
        if (!isValid(ballsPitched, ballsHit)) {
            throw new InvalidParameterException("입력된 공들에 문제가 있습니다.");
        }
        int strikes = countStrikes(ballsPitched, ballsHit);
        int B = countB(ballsPitched, ballsHit);

        return new Result(strikes, B);
    }

    private boolean isValid(List<Integer> ballsPitched, List<Integer> ballsHit) {
        if (ballsPitched == null || ballsHit == null) {
            return false;
        }
        return ballsPitched.size() == 3 && ballsHit.size() == 3;
    }

    private int countStrikes(List<Integer> ballsPitched, List<Integer> ballsHit) {
        int strikes = 0;

        for (int i = 0; i < ballsPitched.size(); i++) {
            if (ballsPitched.get(i).equals(ballsHit.get(i))) {
                strikes += 1;
            }
        }
        return strikes;
    }

    //B는 야구에서 '볼'을 의미합니다. 현재 프로그램에서 'ball'이 '공'을 뜻하기 때문에, 야구 전광판에서 사용하는 용어 'B'를 이용했습니다.
    private int countB(List<Integer> ballsPitched, List<Integer> ballsHit) {
        int B = 0;
        for (int i = 0; i < ballsPitched.size(); i++) {
            if (ballsHit.contains(ballsPitched.get(i)) && !ballsPitched.get(i).equals(ballsHit.get(i))) {
                B += 1;
            }
        }

        return B;
    }

    @Override
    public void announce(Result result) {

    }
}
