package baseball;

public class Status {

    private long strikeCount;
    private long ballCount;


    public Status() {
        strikeCount = 0;
        ballCount = 0;
    }

    public long getStrikeCount() {
        return strikeCount;
    }

    public long getBallCount() {
        return ballCount;
    }

    public void check(Baseballs answerBalls, Baseballs guessingBalls) {
        ballCount = checkBalls(answerBalls, guessingBalls);
        strikeCount = checkStrikes(answerBalls, guessingBalls);
    }

    public long checkStrikes(Baseballs answerBalls, Baseballs guessingBalls) {
        return guessingBalls.getBalls().stream()
                .filter(x -> answerBalls.getBalls().contains(x))
                .filter(x -> guessingBalls.getBalls().indexOf(x) == answerBalls.getBalls().indexOf(x))
                .count();
    }

    public long checkBalls(Baseballs answerBalls, Baseballs guessingBalls) {
        return guessingBalls.getBalls().stream()
                .filter(x -> answerBalls.getBalls().contains(x))
                .filter(x -> guessingBalls.getBalls().indexOf(x) != answerBalls.getBalls().indexOf(x))
                .count();
    }
}
