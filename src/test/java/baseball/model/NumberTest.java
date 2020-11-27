package baseball.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    public void equalsTest(){
        Number source = Number.valueOf(1);
        Number destination = Number.valueOf(1);

        assertThat(source).isEqualTo(destination);
    }

    @Test
    public void hashEqualsTest(){
        Number source = Number.valueOf(1);
        Number destination = Number.valueOf(1);

        assertThat(source.hashCode()).isEqualTo(destination.hashCode());
    }
}
