package com.molt3nrock.baseball;

/**
 * 게임의 야구 카운트 결과 나타내는 클래스.
 *
 * @see #Hint
 */
public class Hint {

  private final int strikes;
  private final int balls;

  /**
   * 생성자.
   *
   * 컴퓨터와 사용자의 {@code Distinct<GameDigit>}를 기준으로 서로 비교한 결과를 나타냅니다.
   *
   * @param strikes {@code GameDigit}의 위치와 값이 완전히 일치하는 숫자의 개수.
   * @param balls   {@code GameDigit}의 위치는 다르고 값이 일치하는 숫자의 개수. 단, {@code strikes}의 값이 0이고 {@code
   *                strikeZoneDigits}가 연속된 수 일 때 {@code balls}의 값은 {@value
   *                BaseBallGame#MAX_STRIKES} + 1을 나타냅니다.
   *
   * @see com.molt3nrock.collection.DistinctList#isConsecutive
   */
  Hint(int strikes, int balls) {
    this.strikes = strikes;
    this.balls = balls;
  }

  @Override
  public String toString() {
    if (balls > BaseBallGame.MAX_STRIKES) {
      return String.format("%d볼", BaseBallGame.MAX_STRIKES + 1);
    } else if (strikes > 0 && balls > 0) {
      return String.format("%d 스트라이크 %d볼", strikes, balls);
    } else if (strikes > 0) {
      return String.format("%d 스트라이크", strikes);
    } else if (balls > 0) {
      return String.format("%d볼", balls);
    } else {
      return "낫싱";
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Hint) {
      Hint otherState = (Hint) other;
      return otherState.strikes == this.strikes && otherState.balls == this.balls;
    } else {
      return false;
    }
  }
}

