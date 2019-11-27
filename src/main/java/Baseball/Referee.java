package Baseball;

import java.util.List;

public interface Referee {
    public Result judge(List<Integer> ballsPitched, List<Integer> ballsHit);
    public void announce(Result result);
}
