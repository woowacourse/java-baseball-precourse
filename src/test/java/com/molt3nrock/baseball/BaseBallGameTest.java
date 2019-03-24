package com.molt3nrock.baseball;

import static org.junit.Assert.*;

import com.molt3nrock.collection.DistinctList;
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
}