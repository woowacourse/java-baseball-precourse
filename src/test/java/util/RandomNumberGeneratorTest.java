package util;

import org.junit.Test;

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
        String result = RandomNumberGenerator.getUniqueNumbers(size, 1, 9).byString();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < result.length(); i++) {
            set.add(Character.getNumericValue(result.charAt(i)));
        }
        assertThat(set).hasSize(size);
    }
}
