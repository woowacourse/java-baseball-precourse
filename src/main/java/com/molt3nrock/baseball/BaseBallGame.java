package com.molt3nrock.baseball;

import com.molt3nrock.collection.DistinctList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseBallGame {

  private static final int DIGITS_LENGTH = 3;

  /**
   * 컴퓨터의 랜덤숫자 생성.
   *
   * 사용자가 맞춰야 할 {@code GameDigit}으로 이루어진 중복이 없는 {@value DIGITS_LENGTH}자리의 숫자를 생성하는 함수 입니다.
   *
   * @return 중복이 없는 {@code GameDigit} 리스트.
   *
   * @see GameDigit
   */
  static DistinctList<GameDigit> generateStrikeZone() {
    assert (GameDigit.MAX <= 9);
    assert (GameDigit.MIN >= 1);
    assert (GameDigit.MAX > GameDigit.MIN);
    assert (GameDigit.MAX - GameDigit.MIN + 1 >= DIGITS_LENGTH);
    ArrayList<Integer> validDigits = IntStream
        .range(GameDigit.MIN, 1 + GameDigit.MAX)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));
    Collections.shuffle(validDigits);
    Stream<GameDigit> digitStream = validDigits
        .stream()
        .map(GameDigit::new)
        .limit(DIGITS_LENGTH);
    return new DistinctList<>(digitStream);
  }
}
