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

    private long checkStrikes(Baseballs answerBalls, Baseballs guessingBalls) {
        return guessingBalls.getBalls().stream()
            .filter(x -> answerBalls.getBalls().contains(x))
            .filter(x -> isInSameIndex(x, answerBalls, guessingBalls))
            .count();
    }

    private long checkBalls(Baseballs answerBalls, Baseballs guessingBalls) {
        return guessingBalls.getBalls().stream()
            .filter(x -> answerBalls.getBalls().contains(x))
            .filter(x -> isInDifferentIndex(x, answerBalls, guessingBalls))
            .count();
    }

    private boolean isInSameIndex(int x, Baseballs answerBalls, Baseballs guessingBalls) {
        return guessingBalls.getBalls().indexOf(x) == answerBalls.getBalls().indexOf(x);
    }

    private boolean isInDifferentIndex(int x, Baseballs answerBalls, Baseballs guessingBalls) {
        return guessingBalls.getBalls().indexOf(x) != answerBalls.getBalls().indexOf(x);
    }
}
