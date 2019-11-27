package Baseball;

public interface BaseballFactory {
    public Baseball create(Pitcher pitcher, Hitter hitter, Referee referee);
}
