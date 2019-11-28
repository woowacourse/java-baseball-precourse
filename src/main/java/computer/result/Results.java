package computer.result;

import java.util.List;
import java.util.Objects;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public int getStrikeAmount() {
        return (int) this.results.stream()
                .filter(result -> result.equals(Result.STRIKE))
                .count();
    }

    public int getBallAmount() {
        return (int) this.results.stream()
                .filter(result -> result.equals(Result.BALL))
                .count();
    }

    public boolean hasStrike() {
        return this.results.contains(Result.STRIKE);
    }

    public boolean hasBall() {
        return this.results.contains(Result.BALL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
