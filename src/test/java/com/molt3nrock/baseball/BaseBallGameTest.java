package com.molt3nrock.baseball;

import static org.junit.Assert.*;

import com.molt3nrock.collection.DistinctList;
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
}