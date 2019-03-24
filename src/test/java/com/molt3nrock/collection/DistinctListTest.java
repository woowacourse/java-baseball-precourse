package com.molt3nrock.collection;

import static org.junit.Assert.assertTrue;

import com.molt3nrock.baseball.GameDigit;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Test;

public class DistinctListTest {

  private DistinctList<GameDigit> createDigit(int... args) {
    return DistinctList.of(Arrays.stream(args).mapToObj(GameDigit::new));
  }

  @Test
  public void isConsecutive() {
    boolean allNarrow = Stream
        .of(new int[]{1, 2, 3},
            new int[]{1, 3, 2},
            new int[]{2, 1, 3},
            new int[]{2, 3, 1},
            new int[]{3, 1, 2},
            new int[]{3, 2, 1})
        .map(this::createDigit) .allMatch(DistinctList::isConsecutive);
    assertTrue(allNarrow);


    boolean allWide = Stream
        .of(new int[]{1, 2, 4},
            new int[]{1, 4, 2},
            new int[]{2, 1, 4},
            new int[]{2, 4, 1},
            new int[]{4, 1, 2},
            new int[]{4, 2, 1})
        .map(this::createDigit)
        .noneMatch(DistinctList::isConsecutive);
    assertTrue(allWide);

    boolean allEmpty = Stream
        .of(new int[]{1, 2, 2},
            new int[]{1, 1, 2},
            new int[]{1, 2, 1},
            new int[]{1, 1, 1},
            new int[]{1, 2},
            new int[]{1},
            new int[]{})
        .map(this::createDigit)
        .noneMatch(list -> list.equals(DistinctList.empty()));
    assertTrue(allEmpty);
  }
}