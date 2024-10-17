package baseball.model;

public class Result {
    private final int strikes;
    private final int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public void printResult() {
        StringBuilder result = new StringBuilder();

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }

        if (balls > 0) {
            result.append(balls).append("볼 ");
        }
        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }

        System.out.println(result.toString().trim());
    }

    public boolean isGameWon() {
        return strikes == 3;
    }
}
