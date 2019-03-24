package com.molt3nrock.baseball;


/**
 * 게임에 사용될 숫자.
 *
 * 범위{@value MIN}(포함) ~ {@value MAX}(포함) 에 있는 숫자들이 게임에 사용 될 수 있습니다.
 *
 * @see #GameDigit
 */
public class GameDigit implements Comparable {

  static final int MIN = 1;
  static final int MAX = 9;
  private int value;

  /**
   * 생성자.
   *
   * @param i 숫자로 사용될 정수.
   *
   * @throws IllegalArgumentException {@code i}가 {@value MIN} 보다 작거나 {@value MAX} 보다 클 경우 발생합니다.
   */
  public GameDigit(int i) {
    if (i < MIN || i > MAX) {
      String message = String.format("%d는 사용 불가능한 숫자 입니다.", i);
      throw new IllegalArgumentException(message);
    }
    this.value = i;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj instanceof GameDigit) {
      GameDigit otherDigit = (GameDigit) obj;
      int lvalue = this.value;
      int rvalue = otherDigit.value;
      return Integer.compare(lvalue, rvalue);
    }
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof GameDigit) {
      GameDigit otherDigit = (GameDigit) obj;
      int lvalue = this.value;
      int rvalue = otherDigit.value;
      return lvalue == rvalue;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.value;
  }

  @Override
  public String toString() {
    return String.format("%d", this.value);
  }
}

