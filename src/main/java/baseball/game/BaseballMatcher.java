package baseball.game;

public class BaseballMatcher implements NumberMatcher<Baseball, BaseballCount> {

    public final Baseball targetBaseball;

    public BaseballMatcher(Baseball targetBaseball) {
        this.targetBaseball = targetBaseball;
    }

    @Override
    public BaseballCount match(Baseball baseball) {
        return baseball.match(targetBaseball);
    }
}
