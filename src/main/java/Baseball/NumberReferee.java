package Baseball;

import java.security.InvalidParameterException;
import java.util.List;

public class NumberReferee implements Referee {
    @Override
    public Result judge(List<Integer> ballsHit, List<Integer> ballsPitched
    ) {
        if (!isValid(ballsHit, ballsPitched)) {
            throw new InvalidParameterException("입력된 공들에 문제가 있습니다.");
        }
        int strikes = countStrikes(ballsHit, ballsPitched);
        int B = countB(ballsHit, ballsPitched);

        return new Result(strikes, B);
    }

    private boolean isValid(List<Integer> ballsHit, List<Integer> ballsPitched) {
        if (ballsHit == null || ballsPitched == null) {
            return false;
        }
        return ballsHit.size() == 3 && ballsPitched.size() == 3;
    }

    private int countStrikes(List<Integer> ballsHit, List<Integer> ballsPitched) {
        int strikes = 0;

        for (int i = 0; i < ballsHit.size(); i++) {
            if (ballsHit.get(i).equals(ballsPitched
                    .get(i))) {
                strikes += 1;
            }
        }
        return strikes;
    }

    //B는 야구에서 '볼'을 의미합니다. 현재 프로그램에서 'ball'이 '공'을 뜻하기 때문에, 야구 전광판에서 사용하는 용어 'B'를 이용했습니다.
    private int countB(List<Integer> ballsHit, List<Integer> ballsPitched) {
        int B = 0;
        for (int i = 0; i < ballsHit.size(); i++) {
            if (ballsPitched
                    .contains(ballsHit.get(i)) && !ballsHit.get(i).equals(ballsPitched
                    .get(i))) {
                B += 1;
            }
        }

        return B;
    }

    @Override
    public void announce(Result result) {
        String sentence = "";
        if (result.getStrikes() != 0) {
            sentence += String.format("%d 스트라이크 ", result.getStrikes());
        }

        if (result.getB() != 0) {
            sentence += String.format("%d볼", result.getB());
        }

        System.out.println(sentence.trim());

        if (result.getStrikes() == 3 && result.getB() == 0) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
