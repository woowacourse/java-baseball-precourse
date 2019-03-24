package com.molt3nrock.collection;


/**
 * 샐수 있는 수를 나태내는 추상클래스.
 *
 * @see #intValue
 */
public abstract class DiscreteNumber implements java.io.Serializable, Comparable {

  /**
   * 정수값으로 변환.
   *
   * @return 샐수 있는 수를 {@code int} 형태로 반환합니다.
   */
  public abstract int intValue();
}

