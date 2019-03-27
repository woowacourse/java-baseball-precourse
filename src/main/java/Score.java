public class Score {
  int strike;
  int ball;

  public Score(int strikeCount, int ballCount) {
    strike = strikeCount;
    ball = ballCount;
  }

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }
}
