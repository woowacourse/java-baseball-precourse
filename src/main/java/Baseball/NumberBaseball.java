package Baseball;

import java.util.List;

public class NumberBaseball implements Baseball {

    private Hitter hitter;
    private Pitcher pitcher;
    private Referee referee;

    NumberBaseball(Hitter hitter, Pitcher pitcher, Referee referee) {
        this.hitter = hitter;
        this.pitcher = pitcher;
        this.referee = referee;
    }

    @Override
    public void play() {
        Result result = start();
        List<Integer> ballsHit = hitter.hit();
        while (!isStrikeOut(result)) {
            List<Integer> ballsPitched = pitcher.pitch();
            result = referee.judge(ballsHit, ballsPitched);
            referee.announce(result);
        }

        if (pitcher.wantToPlayAgain()) {
            play();
        }

        finish();
    }
    private Result start() {
        return new Result(0,0);
    }

    private boolean isStrikeOut(Result result) {
        //todo: move to config
        return result.getStrikes() == 3 && result.getB() == 0;
    }

    private void finish() {
        System.out.println("게임이 완전히 종료되었습니다.");
    }
}
