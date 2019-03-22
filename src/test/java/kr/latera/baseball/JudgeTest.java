package kr.latera.baseball;

import kr.latera.baseball.interfaces.IJudge;
import kr.latera.baseball.interfaces.INumberGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JudgeTest {

  private IJudge judge;
  private INumberGenerator generator;
  private int[][] numbers;

  @Before
  public void init() {
    numbers = new int[][] {
        {1, 2, 4},
        {2, 3, 5},
        {6, 5, 2},
        {8, 9, 2},
        {9, 2, 6}
    };
    generator = new TestGeneartor(numbers);
  }

  @Test
  public void testJudging() {
    judge = new JudgeImpl(generator);

    judge.init();
    Assert.assertEquals(judge.checkStrike(new int[]{1, 3, 4}), 2);
    Assert.assertEquals(judge.checkStrike(new int[]{6, 2, 4}), 2);
    Assert.assertEquals(judge.checkStrike(new int[]{7, 6, 9}), 0);
    Assert.assertEquals(judge.checkStrike(new int[]{1, 2, 4}), 3);
    Assert.assertEquals(judge.checkBall(new int[]{4, 6, 1}), 2);
    Assert.assertEquals(judge.checkBall(new int[]{5, 1, 6}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{5, 1, 2}), 2);
    Assert.assertEquals(judge.checkBall(new int[]{4, 1, 2}), 3);

    judge.init();
    Assert.assertEquals(judge.checkStrike(new int[]{1, 3, 4}), 1);
    Assert.assertEquals(judge.checkStrike(new int[]{6, 2, 4}), 0);
    Assert.assertEquals(judge.checkStrike(new int[]{2, 6, 5}), 2);
    Assert.assertEquals(judge.checkStrike(new int[]{2, 3, 5}), 3);
    Assert.assertEquals(judge.checkBall(new int[]{4, 6, 2}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{7, 1, 6}), 0);
    Assert.assertEquals(judge.checkBall(new int[]{5, 1, 2}), 2);
    Assert.assertEquals(judge.checkBall(new int[]{2, 5, 3}), 2);

    judge.init();
    Assert.assertEquals(judge.checkStrike(new int[]{6, 3, 4}), 1);
    Assert.assertEquals(judge.checkStrike(new int[]{7, 2, 4}), 0);
    Assert.assertEquals(judge.checkStrike(new int[]{2, 6, 5}), 0);
    Assert.assertEquals(judge.checkStrike(new int[]{6, 5, 2}), 3);
    Assert.assertEquals(judge.checkBall(new int[]{4, 6, 2}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{7, 1, 6}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{9, 5, 2}), 0);
    Assert.assertEquals(judge.checkBall(new int[]{2, 6, 5}), 3);

    judge.init();
    Assert.assertEquals(judge.checkStrike(new int[]{6, 3, 2}), 1);
    Assert.assertEquals(judge.checkStrike(new int[]{7, 2, 4}), 0);
    Assert.assertEquals(judge.checkStrike(new int[]{8, 9, 5}), 2);
    Assert.assertEquals(judge.checkStrike(new int[]{6, 5, 2}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{4, 6, 2}), 0);
    Assert.assertEquals(judge.checkBall(new int[]{7, 8, 6}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{9, 5, 1}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{9, 2, 8}), 3);

    judge.init();
    Assert.assertEquals(judge.checkStrike(new int[]{6, 3, 2}), 0);
    Assert.assertEquals(judge.checkStrike(new int[]{7, 2, 4}), 1);
    Assert.assertEquals(judge.checkStrike(new int[]{8, 9, 6}), 1);
    Assert.assertEquals(judge.checkStrike(new int[]{9, 2, 6}), 3);
    Assert.assertEquals(judge.checkBall(new int[]{4, 6, 2}), 2);
    Assert.assertEquals(judge.checkBall(new int[]{7, 8, 6}), 0);
    Assert.assertEquals(judge.checkBall(new int[]{2, 5, 1}), 1);
    Assert.assertEquals(judge.checkBall(new int[]{9, 2, 1}), 0);
  }

  @Test
  public void testValidation() {
    judge = new JudgeImpl(generator);
    Assert.assertTrue(judge.isValidInput(new int[]{1, 2, 3}));
    Assert.assertTrue(judge.isValidInput(new int[]{8, 9, 7}));
    Assert.assertFalse(judge.isValidInput(new int[]{0, 1, 2}));
    Assert.assertFalse(judge.isValidInput(new int[]{6, 6, 6}));
    Assert.assertFalse(judge.isValidInput(new int[]{6, 1, 1}));
    Assert.assertFalse(judge.isValidInput(new int[]{6, 2, -1}));
    Assert.assertFalse(judge.isValidInput(new int[]{2, 3, 12}));
    Assert.assertFalse(judge.isValidInput(new int[]{23, 2, 12}));
  }
}
