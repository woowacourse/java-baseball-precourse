
/*
 * Game.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

public class Game {
    private final Numbers answerNumbers;

    /**
     * Create a game including random three numbers.
     * @param numbersGenerator
     * @throws Exception
     */
    public Game(NumbersGenerator numbersGenerator) throws Exception {
        this.answerNumbers = Numbers.valueOf(numbersGenerator.generate());
    }

    /**
     * This method is used to match user's numbers with random numbers.
     * @param userNumbers
     * @return MatchResult including counts of strike and ball.
     */
    public MatchResult match(Numbers userNumbers) {
        int strikeCount = answerNumbers.matchStrike(userNumbers);
        int ballCount = answerNumbers.matchBall(userNumbers);
        return new MatchResult(strikeCount, ballCount);
    }
}
