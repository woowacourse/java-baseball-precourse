import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {
    @Test
    public void Create() {
        Play play = new Play();
        assertThat(play).isNotNull();
        System.out.println(play.whatIsAnswer());
    }
}