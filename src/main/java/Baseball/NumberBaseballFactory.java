package Baseball;

public class NumberBaseballFactory implements BaseballFactory {
    @Override
    public Baseball create(Hitter hitter, Pitcher pitcher, Referee referee) {
        return new NumberBaseball(hitter, pitcher, referee);
    }
}
