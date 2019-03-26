package util;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author delf
 */
public class RandomNumberGeneratorTest {
    @Test
    public void 일정_범위_내의_중복되지_않는_난수를_N개를_생성한다() {
        int size = 3;
        int limit = 10;

        int[] result = RandomNumberGenerator.getUniqueNumbers(size, limit);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < result.length; i++) {
            set.add(result[i]);
        }
        assertThat(set).hasSize(size);
    }
}
