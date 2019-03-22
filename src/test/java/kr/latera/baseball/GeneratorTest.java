package kr.latera.baseball;

import kr.latera.baseball.NumberGeneratorImpl;
import kr.latera.baseball.interfaces.INumberGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {

    private INumberGenerator generator;

    @Before
    public void init() {
        // create generator
        generator = new NumberGeneratorImpl();
    }

    @Test
    public void testGenerate() {
        // 숫자가 랜덤임을 고려하여 100번 반복
        for (int i = 0; i < 100; i++) {
            testNumberValidity();
        }
    }

    private void testNumberValidity() {
        int[] nums = generator.generateNumber();

        Assert.assertEquals(INumberGenerator.NUMS_LENGTH, nums.length);

        Assert.assertTrue(nums[0] != nums[1]);
        Assert.assertTrue(nums[1] != nums[2]);
        Assert.assertTrue(nums[2] != nums[0]);

        for (int n : nums) {
            Assert.assertTrue(n >= INumberGenerator.MIN_FOR_EACH_NUM &&
                n <= INumberGenerator.MAX_FOR_EACH_NUM);
        }
    }
}
