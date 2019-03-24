package com.molt3nrock.baseball;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class HintTest {

  @Test
  public void toStringTest() {
    final String delimiter = ", ";
    String actual = Stream
        .of(new Hint(0, 0),
            new Hint(0, 1),
            new Hint(0, 2),
            new Hint(0, 3),
            new Hint(0, 4),
            new Hint(1, 0),
            new Hint(1, 1),
            new Hint(1, 2),
            new Hint(2, 0),
            new Hint(3, 0))
        .map(Hint::toString)
        .collect(Collectors.joining(delimiter));
    String expected = String
        .join(delimiter,
              "낫싱",
              "1볼",
              "2볼",
              "3볼",
              "4볼",
              "1 스트라이크",
              "1 스트라이크 1볼",
              "1 스트라이크 2볼",
              "2 스트라이크",
              "3 스트라이크");
    assertEquals(expected, actual);
  }
}