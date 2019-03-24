package com.molt3nrock.baseball;

import static org.junit.Assert.*;

import com.molt3nrock.collection.DistinctList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class BaseBallGameTest {

  @Test
  public void generateStrikeZone() {
    assertEquals(BaseBallGame.generateStrikeZone().size(), 3);

    assertTrue(BaseBallGame
                   .generateStrikeZone()
                   .stream()
                   .allMatch(i -> i.intValue() >= GameDigit.MIN && i.intValue() <= GameDigit.MAX));

    DistinctList<GameDigit> digits = BaseBallGame.generateStrikeZone();
    assertEquals(digits.size(), digits.stream().distinct().count());
  }

  @Test
  public void parseUserInput() {
    assertTrue(Stream
                   .of("", "1", "12", "112", "122", "121", "a11", "1a1", "11a", "012", "aaa")
                   .map(BaseBallGame::parseUserInput)
                   .noneMatch(distinctList -> distinctList.size() == 3));

    assertTrue(Stream
                   .of("123", "345", "678", "789", "231", "768", "987")
                   .map(BaseBallGame::parseUserInput)
                   .allMatch(distinctList -> distinctList.size() == 3));
  }

  @Test
  public void umpireDecides() {
    DistinctList<GameDigit> strikeZone = DistinctList.of(Stream.of(1, 2, 3).map(GameDigit::new));
    String actual = Stream
        .of("245", "431", "312", "145", "135", "132", "125", "123")
        .map(BaseBallGame::parseUserInput)
        .map(pitch -> BaseBallGame.umpireDecides(strikeZone, pitch))
        .map(hint -> String.format("%s", hint))
        .collect(Collectors.joining(", "));
    String expected = String
        .join(", ",
              "1볼",
              "2볼",
              "3볼",
              "1 스트라이크",
              "1 스트라이크 1볼",
              "1 스트라이크 2볼",
              "2 스트라이크",
              "3 스트라이크");
    assertEquals(expected, actual);

    DistinctList<GameDigit> pitch = DistinctList.of(Stream.of(7, 8, 9).map(GameDigit::new));

    String actual4Balls = Stream
        .of("123", "132", "213", "231", "321", "312")
        .map(BaseBallGame::parseUserInput)
        .map(narrowZone -> BaseBallGame.umpireDecides(narrowZone, pitch).toString())
        .collect(Collectors.joining(", "));

    String expected4Balls = String
        .join(", ", "4볼", "4볼", "4볼", "4볼", "4볼", "4볼");
    assertEquals(actual4Balls, expected4Balls);

    String actualNothing = Stream
        .of("124", "142", "214", "241", "421", "412")
        .map(BaseBallGame::parseUserInput)
        .map(wideZone -> BaseBallGame.umpireDecides(wideZone, pitch).toString())
        .collect(Collectors.joining(", "));

    String expectedNothing = String
        .join(", ", "낫싱", "낫싱", "낫싱", "낫싱", "낫싱", "낫싱");
    assertEquals(actualNothing, expectedNothing);
  }
}