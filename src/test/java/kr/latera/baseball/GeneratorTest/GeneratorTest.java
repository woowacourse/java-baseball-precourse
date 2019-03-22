package kr.latera.baseball.GeneratorTest;

import kr.latera.baseball.NumberGenerator;
import kr.latera.baseball.interfaces.IGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {

    private IGenerator generator;

    @Before
    public void init() {
        // create generator
        generator = new NumberGenerator();
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

        Assert.assertEquals(IGenerator.NUMS_LENGTH, nums.length);

        Assert.assertTrue(nums[0] != nums[1]);
        Assert.assertTrue(nums[1] != nums[2]);
        Assert.assertTrue(nums[2] != nums[0]);

        for (int n : nums) {
            Assert.assertTrue(n >= IGenerator.MIN_FOR_EACH_NUM &&
                n <= IGenerator.MAX_FOR_EACH_NUM);
        }
    }
}
