package edu.woowacourse.first;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballTest {

  NumberBaseball game;

  @Before
  public void newNumberBaseball(){
    game = new NumberBaseball();
  }
}
