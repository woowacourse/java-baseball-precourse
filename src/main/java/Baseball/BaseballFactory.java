package Baseball;

public interface BaseballFactory {
    public Baseball create(Hitter hitter, Pitcher pitcher, Referee referee);
}
