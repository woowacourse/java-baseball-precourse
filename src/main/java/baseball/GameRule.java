package baseball;

public class GameRule {
    private GameRule(){}

    public static int countStrike(Numbers target, Numbers guess) {
        return (int)guess.stream()
                .filter(num -> num == target.get(guess.indexOf(num)))
                .count();
    }

    public static int countBall(Numbers target, Numbers guess) {
        return countContainBoth(target, guess) - countStrike(target, guess);
    }

    private static int countContainBoth(Numbers target, Numbers guessed) {
        return (int)guessed.stream()
                .filter(x-> target.contains(x))
                .count();
    }

    public static boolean checkGameEnd(Score score) {
        return score.getStrikeCnt() == Numbers.DIGITS;
    }
}
